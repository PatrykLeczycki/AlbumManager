package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Album;
import pl.coderslab.model.Label;
import pl.coderslab.service.AlbumService;
import pl.coderslab.service.LabelService;
import pl.coderslab.utils.Prompt;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

import static pl.coderslab.utils.Functions.getCountries;

@Controller
@RequiredArgsConstructor
public class LabelController {

    private final LabelService labelService;
    private final AlbumService albumService;
    private final Prompt prompt;

    @GetMapping("/labels/all")
    public String allLabels(Model model){
        model.addAttribute("labels", labelService.getAllLabels());

        if(prompt.doesContain("deleteerror")){
            prompt.getNames().remove("deleteerror");
            model.addAttribute("deleteerror", true);
        }

        if(prompt.doesContain("labelnotfound")){
            prompt.getNames().remove("labelnotfound");
            model.addAttribute("labelnotfound", true);
        }

        return "labels/all";
    }

    @GetMapping("/user/addlabel")
    public String addLabel(Model model){
        model.addAttribute("label", new Label());
        return "labels/add";
    }

    @PostMapping("/user/addlabel")
    public String addLabel(@Valid Label label, BindingResult result){

        //TODO: dać tłumaczenia błędów
        if (result.hasErrors())
            return "labels/add";

        labelService.addLabel(label);
        return "redirect:/labels/all";
    }

    @GetMapping("/admin/editlabel/{id}")
    public String editLabel(@PathVariable long id, Model model){
        model.addAttribute("label", labelService.getLabelById(id));
        return "labels/edit";
    }

    @PostMapping("/admin/editlabel")
    public String editLabel(@Valid Label label, BindingResult result){
        if (result.hasErrors())
            return "labels/edit";

        labelService.addLabel(label);
        return "redirect:/labels/all";
    }

    @GetMapping("/admin/deletelabel/{id}")
    public String deleteLabel(@PathVariable long id){

        Label label = labelService.getLabelById(id);

        if (!Objects.isNull(label)){
            List<Album> albums = albumService.getAlbumsByLabel(label);
            if (albums.isEmpty())
                labelService.deleteLabel(id);

            else prompt.add("deleteerror");
        } else prompt.add("labelnotfound");

        return "redirect:/labels/all";
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return getCountries();
    }
}
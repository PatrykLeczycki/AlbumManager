package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Label;
import pl.coderslab.model.LoggedUser;
import pl.coderslab.service.LabelService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/labels")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @Autowired
    private LoggedUser loggedUser;

    @GetMapping("/add")
    public String addLabel(Model model){
        model.addAttribute("label", new Label());
        return "labels/add";
    }

    @PostMapping("/add")
    public String addLabel(@Valid Label label, BindingResult result){
        if (result.hasErrors())
            return "labels/add";

        labelService.addLabel(label);
        return "redirect:/labels/all";
    }

    @GetMapping("/all")
    public String allLabels(Model model){
        model.addAttribute("labels", labelService.getAllLabels());
        System.out.println(loggedUser.getLogin());
        return "labels/all";
    }

    @GetMapping("/edit/{id}")
    public String editLabel(@PathVariable long id, Model model){
        model.addAttribute("label", labelService.getLabelById(id));
        return "labels/edit";
    }

    @PostMapping("/edit")
    public String editLabel(@Valid Label label, BindingResult result){
        if (result.hasErrors())
            return "labels/edit";

        labelService.addLabel(label);
        return "redirect:/labels/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteLabel(@PathVariable long id){
        labelService.deleteLabel(id);
        return "redirect:/labels/all";
    }


    @ModelAttribute("countries")
    public List<String> countries(){

        Locale.setDefault(new Locale("en"));
        String[] locales = Locale.getISOCountries();

        List<String> names = new ArrayList<>();

        for (String countryCode : locales){
            names.add(new Locale("", countryCode).getDisplayCountry());
        }

        Collections.sort(names);

        return names;
    }

}
package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.service.LabelService;
import pl.coderslab.utils.Prompt;

@Controller
@RequestMapping("/labels")
@RequiredArgsConstructor
public class LabelController {

    private final LabelService labelService;
    private final Prompt prompt;

    @GetMapping("/all")
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
}
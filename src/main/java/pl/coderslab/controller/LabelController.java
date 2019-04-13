package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.service.LabelService;

@Controller
@RequestMapping("/labels")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping("/all")
    public String allLabels(Model model){
        model.addAttribute("labels", labelService.getAllLabels());
        return "labels/all";
    }
}
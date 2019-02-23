package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Label;
import pl.coderslab.service.LabelService;

import javax.validation.Valid;

@Controller
@RequestMapping("/labels")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("label", new Label());
        return "labels/add";
    }

    @PostMapping("/add")
    public String add(@Valid Label label, BindingResult result){
        if (result.hasErrors())
            return "labels/add";

        labelService.addLabel(label);
        return "redirect:/labels/all";
    }

    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("labels", labelService.getAllLabels());
        return "labels/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        model.addAttribute("label", labelService.getLabelById(id));
        return "labels/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid Label label, BindingResult result){
        if (result.hasErrors())
            return "labels/edit";

        labelService.addLabel(label);
        return "redirect:/labels/all";
    }
}
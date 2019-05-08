package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.service.BandService;
import pl.coderslab.utils.Prompt;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bands")
public class BandController {

    private final BandService bandService;
    private final Prompt prompt;

    @GetMapping("/all")
    private String allBands(Model model){
        model.addAttribute("bands", bandService.getAllBands());

        if(prompt.doesContain("deleteerror")){
            prompt.getNames().remove("deleteerror");
            model.addAttribute("deleteerror", true);
        }

        if(prompt.doesContain("bandnotfound")){
            prompt.getNames().remove("bandnotfound");
            model.addAttribute("bandnotfound", true);
        }

        return "bands/all";
    }
}

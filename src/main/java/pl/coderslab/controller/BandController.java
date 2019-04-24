package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.service.BandService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bands")
public class BandController {

    private final BandService bandService;

    @GetMapping("/all")
    private String allBands(Model model){
        System.out.println(bandService.getAllBands().size());
        model.addAttribute("bands", bandService.getAllBands());
        return "bands/all";
    }
}

package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.service.ArtistService;
import pl.coderslab.utils.Prompt;


@Controller
@RequestMapping("/artists")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;
    private final Prompt prompt;

    @GetMapping("/all")
    private String allArtists(Model model){
        model.addAttribute("artists", artistService.getAllArtists());

        if(prompt.doesContain("deleteerror")){
            prompt.getNames().remove("deleteerror");
            model.addAttribute("deleteerror", true);
        }

        if(prompt.doesContain("deleteerror2")){
            prompt.getNames().remove("deleteerror2");
            model.addAttribute("deleteerror2", true);
        }

        if(prompt.doesContain("artistnotfound")){
            prompt.getNames().remove("artistnotfound");
            model.addAttribute("artistnotfound", true);
        }

        return "artists/all";
    }
}

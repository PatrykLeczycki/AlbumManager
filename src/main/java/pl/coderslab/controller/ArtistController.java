package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.service.ArtistService;


@Controller
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping("/all")
    private String allArtists(Model model){
        model.addAttribute("artists", artistService.getAllArtists());
        return "artists/all";
    }
}

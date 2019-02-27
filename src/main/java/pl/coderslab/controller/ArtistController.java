package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Artist;
import pl.coderslab.model.LoggedUser;
import pl.coderslab.service.ArtistService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;


    @Autowired
    private LoggedUser loggedUser;

    @GetMapping("/add")
    private String addArtist(Model model){
        model.addAttribute("artist", new Artist());
        return "artists/add";
    }

    @PostMapping("/add")
    private String addArtist(@Valid Artist artist, BindingResult result){
        if (result.hasErrors())
            return "artists/add";

        artistService.addArtist(artist);
        return "redirect:/artists/all";
    }

    @GetMapping("/all")
    private String allArtists(Model model){
        model.addAttribute("artists", artistService.getAllArtists());
        return "artists/all";
    }

    @GetMapping("/edit/{id}")
    private String editArtist(@PathVariable long id, Model model){
        model.addAttribute("artist", artistService.getArtistById(id));
        return "artists/edit";
    }

    @PostMapping("/edit")
    private String editArtist(@Valid Artist artist, BindingResult result){
        if (result.hasErrors())
            return "artists/edit";

        artistService.addArtist(artist);
        return "redirect:/artists/all";
    }

    @GetMapping("/delete/{id}")
    private String deleteArtist(@PathVariable long id){
        artistService.deleteArtist(id);
        return "redirect:/artists/all";
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

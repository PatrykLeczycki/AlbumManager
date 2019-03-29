package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Artist;
import pl.coderslab.model.LoggedUser;
import pl.coderslab.service.ArtistService;
import pl.coderslab.utils.Functions;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static pl.coderslab.utils.Functions.getCountries;

@Controller
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;


    @Autowired
    private LoggedUser loggedUser;

    @GetMapping("/all")
    private String allArtists(Model model){
        model.addAttribute("artists", artistService.getAllArtists());
        return "artists/all";
    }

    @ModelAttribute("countries")
    public List<String> countries(){
        return getCountries();
    }


}

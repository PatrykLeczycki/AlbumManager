package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Album;
import pl.coderslab.model.Artist;
import pl.coderslab.model.Band;
import pl.coderslab.service.AlbumService;
import pl.coderslab.service.ArtistService;
import pl.coderslab.service.BandService;
import pl.coderslab.utils.Prompt;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

import static pl.coderslab.utils.Functions.getCountries;


@Controller
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;
    private final AlbumService albumService;
    private final BandService bandService;
    private final Prompt prompt;

    @GetMapping("/artists/all")
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

    @GetMapping("/user/addartist")
    private String addArtist(Model model){
        model.addAttribute("artist", new Artist());
        return "artists/add";
    }

    @PostMapping("/user/addartist")
    private String addArtist(@Valid Artist artist, BindingResult result){

        //TODO: add custom error messages
        if (result.hasErrors())
            return "artists/add";

        artistService.addArtist(artist);
        return "redirect:/artists/all";
    }

    @GetMapping("/admin/editartist/{id}")
    private String editArtist(@PathVariable long id, Model model){
        model.addAttribute("artist", artistService.getArtistById(id));
        return "artists/edit";
    }

    @PostMapping("/admin/editartist")
    private String editArtist(@Valid Artist artist, BindingResult result){
        if (result.hasErrors())
            return "artists/edit";

        artistService.addArtist(artist);
        return "redirect:/artists/all";
    }

    @GetMapping("/admin/deleteartist/{id}")
    private String deleteArtist(@PathVariable long id){
        Artist artist = artistService.getArtistById(id);

        if (!Objects.isNull(artist)){
            List<Album> albums = albumService.getAlbumsByArtist(artist);
            List<Band> bands = bandService.getBandsByArtist(artist);
            if (albums.isEmpty() && bands.isEmpty())
                artistService.deleteArtist(id);
            else {
                if (!albums.isEmpty())
                    prompt.add("deleteerror");

                if (!bands.isEmpty())
                    prompt.add("deleteerror2");
            }
        } else prompt.add("artistnotfound");
        return "redirect:/artists/all";
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return getCountries();
    }
}

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

@Controller
@RequiredArgsConstructor
public class BandController {

    private final BandService bandService;
    private final AlbumService albumService;
    private final ArtistService artistService;
    private final Prompt prompt;

    @GetMapping("/bands/all")
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

    @GetMapping("/user/addband")
    public String addBand(Model model){
        model.addAttribute("band", new Band());
        return "bands/add";
    }

    @PostMapping("/user/addband")
    public String addBand(@Valid Band band, BindingResult result){

        //TODO: dać tłumaczenia błędów
        if (result.hasErrors())
            return "bands/add";

        bandService.addBand(band);
        return "redirect:/bands/all";
    }


    @GetMapping("/admin/editband/{id}")
    private String editBand(@PathVariable long id, Model model){
        model.addAttribute("band", bandService.getBandById(id));
        return "bands/edit";
    }

    @PostMapping("/admin/editband")
    private String editBand(@Valid Band band, BindingResult result){
        if (result.hasErrors())
            return "bands/edit";

        bandService.addBand(band);
        return "redirect:/bands/all";
    }

    @GetMapping("/admin/deleteband/{id}")
    private String deleteBand(@PathVariable long id){

        Band band = bandService.getBandById(id);

        if (!Objects.isNull(band)){
            List<Album> albums = albumService.getAlbumsByBand(band);
            if (albums.isEmpty())
                bandService.deleteBand(id);
            else prompt.add("deleteerror");

        } else prompt.add("bandnotfound");

        return "redirect:/bands/all";
    }

    @ModelAttribute("artists")
    public List<Artist> getArtists(){
        return artistService.getAllArtists();
    }
}

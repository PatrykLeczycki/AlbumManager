package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.model.Album;
import pl.coderslab.model.Artist;
import pl.coderslab.model.LoggedUser;
import pl.coderslab.model.enums.Format;
import pl.coderslab.model.Label;
import pl.coderslab.service.AlbumService;
import pl.coderslab.service.ArtistService;
import pl.coderslab.service.LabelService;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private LabelService labelService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private LoggedUser loggedUser;

    @Autowired
    private UserService userService;

    @GetMapping("/add")
    private String addAlbum(Model model){
        model.addAttribute("album", new Album());
        return "albums/add";
    }

    @PostMapping("/add")
    private String addAlbum(@Valid Album album, BindingResult result){
        //TODO: dać tłumaczenia błędów
        if (result.hasErrors())
            return "albums/add";

        albumService.addAlbum(album);
        return "redirect:/albums/all";
    }

    @GetMapping("/all")
    private String allAlbums(Model model){
        model.addAttribute("albums", albumService.getAllAlbums());
        return "albums/all";
    }

    @GetMapping("/edit/{id}")
    private String editAlbum(@PathVariable long id, Model model){
        model.addAttribute("album", albumService.getAlbumById(id));
        return "albums/edit";
    }

    @PostMapping("/edit")
    private String editAlbum(@Valid Album album, BindingResult result){
        if (result.hasErrors())
            return "albums/edit";

        albumService.addAlbum(album);
        return "redirect:/albums/all";
    }

    @GetMapping("/delete/{id}")
    private String deleteAlbum(@PathVariable long id, Model model, RedirectAttributes redirectAttributes){

        albumService.deleteAlbum(id);
        redirectAttributes.addFlashAttribute("deletion", "Album has been deleted.");
        return "redirect:/albums/all";
    }

    @ModelAttribute("labels")
    public List<Label> getLabels(){
        return labelService.getAllLabels();
    }

    @ModelAttribute("artists")
    public List<Artist> getArtists(){
        return artistService.getAllArtists();
    }

    @ModelAttribute("formats")
    public List<String> getFormats(){
        Format[] formats = Format.values();
        List<String> formatList = new ArrayList<>();

        for (Format f : formats){
            formatList.add(f.name());
        }

        return formatList;
    }

    @ModelAttribute("useralbumsids")
    public List<Long> getIds(){
        return albumService.getAlbumIdsByUserId(loggedUser.getId());
    }
}

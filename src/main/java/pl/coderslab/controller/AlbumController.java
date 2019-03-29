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

    @GetMapping("/all")
    private String allAlbums(Model model){
        model.addAttribute("albums", albumService.getAllAlbums());
        return "albums/all";
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

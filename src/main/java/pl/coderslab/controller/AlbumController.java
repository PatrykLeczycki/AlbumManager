package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Album;
import pl.coderslab.model.Artist;
import pl.coderslab.model.Band;
import pl.coderslab.model.Label;
import pl.coderslab.service.*;
import pl.coderslab.utils.Prompt;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Objects;

import static pl.coderslab.utils.Functions.getFormats;

@Controller
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;
    private final UserService userService;
    private final ArtistService artistService;
    private final LabelService labelService;
    private final BandService bandService;
    private final Prompt prompt;

    @GetMapping("/albums/all")
    private String allAlbums(Model model){
        model.addAttribute("albums", albumService.getAllAlbums());

        if(prompt.doesContain("albumincollection")){
            prompt.getNames().remove("albumincollection");
            model.addAttribute("deleteerror", true);
        }

        return "albums/all";
    }

    @GetMapping("/user/addalbum")
    private String addAlbum(Model model){
        model.addAttribute("album", new Album());
        return "albums/add";
    }

    @PostMapping("/user/addalbum")
    private String addAlbum(@Valid Album album, BindingResult result, Model model){
        //TODO: dać tłumaczenia błędów


        if (result.hasErrors() || (album.getArtists().isEmpty() && Objects.isNull(album.getBand()))){

            if (album.getArtists().isEmpty() && Objects.isNull(album.getBand()) ){
                model.addAttribute("noauthor", true);
                System.out.println("test0");
            }
            else if (!Objects.isNull(album.getBand())){
                model.addAttribute("gotoband", true);
                System.out.println("test2");
            }
            return "albums/add";
        }

        albumService.addAlbum(album);
        return "redirect:/albums/all";
    }

    @GetMapping("/admin/editalbum/{id}")
    private String editAlbum(@PathVariable long id, Model model){

        Album album = albumService.getAlbumById(id);

        model.addAttribute("album", album);

        if(!Objects.isNull(album.getBand()))
            model.addAttribute("gotoband", true);

        return "albums/edit";
    }

    @PostMapping("/admin/editalbum")
    private String editAlbum(@Valid Album album, BindingResult result){
        if (result.hasErrors())
            return "albums/edit";

        albumService.addAlbum(album);
        return "redirect:/albums/all";
    }

    @RequestMapping(value = "/admin/deletealbum/{id}", method = RequestMethod.GET)
    private String deleteAlbum(@PathVariable long id, Model model){

        if (albumService.countAlbumsByAlbumId(id) == 0)
            albumService.deleteAlbum(id);
        else prompt.add("albumincollection");

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

    @ModelAttribute("bands")
    public List<Band> getBands(){
        return bandService.getAllBands();
    }

    @ModelAttribute("formats")
    public List<String> formats(){
        return getFormats();
    }

    @ModelAttribute("useralbumsids")
    public List<Long> allUserAlbumIds(Principal principal){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth instanceof AnonymousAuthenticationToken)
            return null;

        Long id = userService.findUserByUsername(principal.getName()).getId();

        return albumService.getAlbumIdsByUserId(id);
    }
}

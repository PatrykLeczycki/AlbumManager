package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.*;
import pl.coderslab.repository.RoleRepository;
import pl.coderslab.service.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static pl.coderslab.utils.Functions.getCountries;
import static pl.coderslab.utils.Functions.getFormats;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final AlbumService albumService;
    private final ArtistService artistService;
    private final BandService bandService;
    private final LabelService labelService;
    private final RoleRepository roleRepository;

    @GetMapping("/users")
    public String all(Model model, Principal principal){

        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("loggedUser", principal.getName());

        //TODO: gryzie się z panelem powitalnym
        return "admins/allusers";
    }

    @RequestMapping(value = "/changerole/{id}", method = RequestMethod.GET)
    public String changeUserRole(@PathVariable long id, Model model, Principal principal){

        Optional<User> optionalUser = userService.findUserById(id);

        if (optionalUser.isPresent()){
            User user = optionalUser.get();

            if(!user.getUsername().equals(principal.getName())){
                if(user.getRoleSet().contains(roleRepository.findByName("ROLE_ADMIN")))
                    user.getRoleSet().remove(roleRepository.findByName("ROLE_ADMIN"));
                else user.getRoleSet().add(roleRepository.findByName("ROLE_ADMIN"));
                userService.addUser(user);

                return "redirect:/admin/users";
            }

            /*TODO: zamienić to na przekazywanie atrybutu z kontrolera do kontrolera*/

            model.addAttribute("users", userService.getAllUsers());
            model.addAttribute("loggedUser", principal.getName());
            model.addAttribute("ownRole", true);
            return "admins/allusers";
        }

        // TODO: dać obsługę nieistniejącego usera
        return "redirect:/admin/users";

    }

    ///////////////////////////////////////////////////////////////
    // ALBUMS ACTIONS

    @GetMapping("/editalbum/{id}")
    private String editAlbum(@PathVariable long id, Model model){
        model.addAttribute("album", albumService.getAlbumById(id));
        return "albums/edit";
    }

    @PostMapping("/editalbum")
    private String editAlbum(@Valid Album album, BindingResult result){
        if (result.hasErrors())
            return "albums/edit";

        albumService.addAlbum(album);
        return "redirect:/albums/all";
    }

    @RequestMapping(value = "/deletealbum/{id}", method = RequestMethod.GET)
    private String deleteAlbum(@PathVariable long id){

        albumService.deleteAlbum(id);
        return "redirect:/albums/all";
    }

    ///////////////////////////////////////////////////////////////

    // ARTISTS ACTIONS

    @GetMapping("/editartist/{id}")
    private String editArtist(@PathVariable long id, Model model){
        model.addAttribute("artist", artistService.getArtistById(id));
        return "artists/edit";
    }

    @PostMapping("/editartist")
    private String editArtist(@Valid Artist artist, BindingResult result){
        if (result.hasErrors())
            return "artists/edit";

        artistService.addArtist(artist);
        return "redirect:/artists/all";
    }

    @GetMapping("/deleteartist/{id}")
    private String deleteArtist(@PathVariable long id, Model model){
        Artist artist = artistService.getArtistById(id);

        if (!Objects.isNull(artist)){
            List<Album> albums = albumService.getAlbumsByArtist(artist);
            List<Band> bands = bandService.getBandsByArtist(artist);
            if (albums.isEmpty() && bands.isEmpty())
                artistService.deleteArtist(id);
            else {
                if (!albums.isEmpty())
                    model.addAttribute("deleteerror", true);

                if (!bands.isEmpty())
                    model.addAttribute("deleteerror2", true);
                model.addAttribute("artists", artistService.getAllArtists());
                return "artists/all";
            }
        }
        return "redirect:/artists/all";
    }

    ///////////////////////////////////////////////////////////////

    // BANDS ACTIONS

    @GetMapping("/editband/{id}")
    private String editBand(@PathVariable long id, Model model){
        model.addAttribute("band", bandService.getBandById(id));
        return "bands/edit";
    }

    @PostMapping("/editband")
    private String editBand(@Valid Band band, BindingResult result){
        if (result.hasErrors())
            return "bands/edit";

        bandService.addBand(band);
        return "redirect:/bands/all";
    }

    @GetMapping("/deleteband/{id}")
    private String deleteBand(@PathVariable long id, Model model){

        Band band = bandService.getBandById(id);

        if (!Objects.isNull(band)){
            List<Album> albums = albumService.getAlbumsByBand(band);
            if (albums.isEmpty())
                bandService.deleteBand(id);
            else {
                model.addAttribute("deleteerror", true);
                model.addAttribute("bands", bandService.getAllBands());
                return "bands/all";
            }
        }

        return "redirect:/bands/all";
    }

    ///////////////////////////////////////////////////////////////

    // LABEL ACTIONS

    @GetMapping("/editlabel/{id}")
    public String editLabel(@PathVariable long id, Model model){
        model.addAttribute("label", labelService.getLabelById(id));
        return "labels/edit";
    }

    @PostMapping("/editlabel")
    public String editLabel(@Valid Label label, BindingResult result){
        if (result.hasErrors())
            return "labels/edit";

        labelService.addLabel(label);
        return "redirect:/labels/all";
    }

    @GetMapping("/deletelabel/{id}")
    public String deleteLabel(@PathVariable long id, Model model){

        Label label = labelService.getLabelById(id);

        if (!Objects.isNull(label)){
            List<Album> albums = albumService.getAlbumsByLabel(label);
            if (albums.isEmpty())
                labelService.deleteLabel(id);
            else {
                model.addAttribute("deleteerror", true);
                model.addAttribute("labels", labelService.getAllLabels());
                return "labels/all";
            }
        }

        return "redirect:/labels/all";
    }

    ///////////////////////////////////////////////////////////////

    @ModelAttribute("labels")
    public List<Label> getLabels(){
        return labelService.getAllLabels();
    }

    @ModelAttribute("artists")
    public List<Artist> getArtists(){
        return artistService.getAllArtists();
    }

    @ModelAttribute("formats")
    public List<String> formats(){
        return getFormats();
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return getCountries();
    }
}

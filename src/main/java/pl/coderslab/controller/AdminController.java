package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.*;
import pl.coderslab.repository.RoleRepository;
import pl.coderslab.service.*;
import pl.coderslab.utils.Prompt;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Objects;

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
    private final Prompt prompt;

    @GetMapping("/users")
    public String all(Model model, Principal principal){

        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("loggedUser", principal.getName());

        if(prompt.doesContain("usernotfound")){
            prompt.getNames().remove("usernotfound");
            model.addAttribute("usernotfound", true);
        }

        if(prompt.doesContain("ownrole")){
            prompt.getNames().remove("ownrole");
            model.addAttribute("ownrole", true);
        }

        return "admins/allusers";
    }

    @RequestMapping(value = "/changerole/{id}", method = RequestMethod.GET)
    public String changeUserRole(@PathVariable long id, Principal principal){

        User user = userService.findUserById(id);

        if(!Objects.isNull(user)){
            if(!user.getUsername().equals(principal.getName())){
                if(user.getRoleSet().contains(roleRepository.findByName("ROLE_ADMIN")))
                    user.getRoleSet().remove(roleRepository.findByName("ROLE_ADMIN"));
                else user.getRoleSet().add(roleRepository.findByName("ROLE_ADMIN"));
                userService.addUser(user);

                return "redirect:/admin/users";
            }

            prompt.add("ownrole");
            return "admins/allusers";
        }

        prompt.add("usernotfound");
        return "redirect:/admin/users";
    }

    ///////////////////////////////////////////////////////////////
    // ALBUMS ACTIONS

    @GetMapping("/editalbum/{id}")
    private String editAlbum(@PathVariable long id, Model model){

        Album album = albumService.getAlbumById(id);

        model.addAttribute("album", album);

        if(!Objects.isNull(album.getBand()))
            model.addAttribute("gotoband", true);

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
    private String deleteAlbum(@PathVariable long id, Model model){

        if (albumService.countAlbumsByAlbumId(id) == 0)
            albumService.deleteAlbum(id);
        else prompt.add("albumincollection");

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
    public String deleteLabel(@PathVariable long id){

        Label label = labelService.getLabelById(id);

        if (!Objects.isNull(label)){
            List<Album> albums = albumService.getAlbumsByLabel(label);
            if (albums.isEmpty())
                labelService.deleteLabel(id);

            else prompt.add("deleteerror");
        } else prompt.add("labelnotfound");

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

    @ModelAttribute("bands")
    public List<Band> getBands(){
        return bandService.getAllBands();
    }

    @ModelAttribute("formats")
    public List<String> formats(){
        return getFormats();
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return getCountries();
    }

    // TODO: wywalić to, gdy ogarnę przenoszenie atrybutu z kontrolera do kontrolera

    @ModelAttribute("useralbumsids")
    public List<Long> allUserAlbumIds(Principal principal){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth instanceof AnonymousAuthenticationToken)
            return null;

        Long id = userService.findUserByUsername(principal.getName()).getId();

        return albumService.getAlbumIdsByUserId(id);
    }
}

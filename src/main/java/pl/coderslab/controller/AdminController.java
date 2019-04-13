package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.*;
import pl.coderslab.repository.RoleRepository;
import pl.coderslab.service.AlbumService;
import pl.coderslab.service.ArtistService;
import pl.coderslab.service.LabelService;
import pl.coderslab.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import static pl.coderslab.utils.Functions.getCountries;
import static pl.coderslab.utils.Functions.getFormats;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private LabelService labelService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/users")
    public String all(Model model, Principal principal){

        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("loggedUser", principal.getName());

        //TODO: gryzie się z panelem powitalnym
        return "admins/allUsers";
    }

    @RequestMapping(value = "/changerole/{id}", method = RequestMethod.GET)
    public String changeUserRole(@PathVariable long id, HttpServletRequest request, Principal principal){

        Optional<User> optionalUser = userService.findUserById(id);

        if (optionalUser.isPresent()){
            User user = optionalUser.get();

            if(!user.getUsername().equals(principal.getName())){
                if(user.getRoleSet().contains(roleRepository.findByName("ROLE_ADMIN")))
                    user.getRoleSet().remove(roleRepository.findByName("ROLE_ADMIN"));
                else user.getRoleSet().add(roleRepository.findByName("ROLE_ADMIN"));
                userService.addUser(user);
            } else request.setAttribute("ownRole", "You can't change your own role.");
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
    private String deleteArtist(@PathVariable long id){
        artistService.deleteArtist(id);
        return "redirect:/artists/all";
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
        labelService.deleteLabel(id);
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

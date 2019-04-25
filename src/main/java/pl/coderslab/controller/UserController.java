package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.*;
import pl.coderslab.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

import static pl.coderslab.utils.Functions.getCountries;
import static pl.coderslab.utils.Functions.getFormats;

@Controller
@SessionAttributes({"dashboard"})
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private LabelService labelService;

    @Autowired
    private BandService bandService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/newpassword")
    public String newPassword(){
        return "users/newPassword";
    }

    @PostMapping("/newpassword")
    public String newPassword(@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, @RequestParam("newPasswordRepeat") String newPasswordRepeat, Model model, Principal principal){

        User loggedUser = userService.findUserByUsername(principal.getName());

        if (!passwordEncoder.matches(oldPassword, loggedUser.getPassword())){
            model.addAttribute("oldwrong", "Old password doesn't match.");
            return "users/newPassword";
        }

        if (!newPassword.equals(newPasswordRepeat)){
            model.addAttribute("passnoteq", "Passwords don't match.");
            return "users/newPassword";
        }

        User user = userService.findUserByUsername(loggedUser.getUsername());
        user.setPassword(passwordEncoder.encode(newPassword));
        userService.addUser(user);
        model.addAttribute("newPassInfo", "Password has been changed.");
        return "redirect:/user/dashboard";
    }

    @RequestMapping("/dashboard")
    public String dashboard(HttpSession session, Model model, Principal principal){

        model.addAttribute("dashboard", true);
        return "users/dashboard";
    }

    @GetMapping("/albums")
    private String allUserAlbums(){
        return "users/allalbums";
    }

    @RequestMapping(value = "/addalbumtocollection/{id}", method = RequestMethod.GET)
    public String addAlbumToCollection(@PathVariable long id, Principal principal){

        User loggedUser = userService.findUserByUsername(principal.getName());

        userService.addAlbumToCollection(loggedUser.getId(), id);
        return "redirect:/albums/all";
    }

    @RequestMapping(value = "/deletealbumfromcollection/{id}", method = RequestMethod.GET)
    private String deleteAlbumFromCollection(@PathVariable long id, HttpServletRequest request, Principal principal){

        Long userId = userService.findUserByUsername(principal.getName()).getId();
        userService.deleteAlbumFromCollection(userId, id);

        if ("true".equals(request.getParameter("back")))
            return "redirect:/user/albums";

        return "redirect:/albums/all";
    }

    @GetMapping("/addalbum")
    private String addAlbum(Model model){
        model.addAttribute("album", new Album());
        return "albums/add";
    }

    @PostMapping("/addalbum")
    private String addAlbum(@Valid Album album, BindingResult result){
        //TODO: dać tłumaczenia błędów
        if (result.hasErrors())
            return "albums/add";

        albumService.addAlbum(album);
        return "redirect:/albums/all";
    }

    @GetMapping("/addartist")
    private String addArtist(Model model){
        model.addAttribute("artist", new Artist());
        return "artists/add";
    }

    // TODO: sprawdzić debuggerem, czemu trzeba odświeżyć, żeby zobaczyć świeżo dodany item

    @PostMapping("/addartist")
    private String addArtist(@Valid Artist artist, BindingResult result){
        //TODO: dać tłumaczenia błędów
        if (result.hasErrors())
            return "artists/add";

        artistService.addArtist(artist);
        return "redirect:/artists/all";
    }

    @GetMapping("/addlabel")
    public String addLabel(Model model){
        model.addAttribute("label", new Label());
        return "labels/add";
    }

    @PostMapping("/addlabel")
    public String addLabel(@Valid Label label, BindingResult result){

        //TODO: dać tłumaczenia błędów
        if (result.hasErrors())
            return "labels/add";

        labelService.addLabel(label);
        return "redirect:/labels/all";
    }

    @GetMapping("/addband")
    public String addBand(Model model){
        model.addAttribute("band", new Band());
        return "bands/add";
    }

    @PostMapping("/addband")
    public String addBand(@Valid Band band, BindingResult result){

        //TODO: dać tłumaczenia błędów
        if (result.hasErrors())
            return "bands/add";

        bandService.addBand(band);
        return "redirect:/bands/all";
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
    public List<String> formats(){
        return getFormats();
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return getCountries();
    }

    @ModelAttribute("allalbums")
    public List<Album> allAlbumsTest(){
        return albumService.getAllAlbums();
    }

    @ModelAttribute("useralbumids")
    public List<Long> allUsersAlbumsIds(Principal principal){

        /*Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth instanceof AnonymousAuthenticationToken)
            return null;*/

        Long id = userService.findUserByUsername(principal.getName()).getId();

        return albumService.getAlbumIdsByUserId(id);
    }
}

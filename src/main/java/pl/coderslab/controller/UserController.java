package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
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
import java.util.Objects;

import static pl.coderslab.utils.Functions.getCountries;
import static pl.coderslab.utils.Functions.getFormats;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AlbumService albumService;
    private final ArtistService artistService;
    private final LabelService labelService;
    private final BandService bandService;
    private final BCryptPasswordEncoder passwordEncoder;

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
    public String dashboard(Model model){

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

    @ModelAttribute("allalbums")
    public List<Album> allAlbumsTest(){
        return albumService.getAllAlbums();
    }

    @ModelAttribute("useralbumids")
    public List<Long> allUsersAlbumsIds(Principal principal){

        Long id = userService.findUserByUsername(principal.getName()).getId();

        return albumService.getAlbumIdsByUserId(id);
    }
}

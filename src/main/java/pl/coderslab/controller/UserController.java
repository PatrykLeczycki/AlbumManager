package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.model.*;
import pl.coderslab.service.AlbumService;
import pl.coderslab.service.ArtistService;
import pl.coderslab.service.LabelService;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

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
    private LoggedUser loggedUser;

    @GetMapping("/newpassword")
    public String newPassword(){
        return "users/newPassword";
    }

    @PostMapping("/newpassword")
    public String newPassword(@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, @RequestParam("newPasswordRepeat") String newPasswordRepeat, Model model){

        if(!BCrypt.checkpw(oldPassword, loggedUser.getPassword())){
            model.addAttribute("oldwrong", "Old password doesn't match.");
            return "users/newPassword";
        }

        if (!newPassword.equals(newPasswordRepeat)){
            model.addAttribute("passnoteq", "Passwords don't match.");
            return "users/newPassword";
        }

        User user = userService.findUserByLogin(loggedUser.getLogin());
        user.setPasswordHashed(newPassword);
        userService.addUser(user);
        model.addAttribute("newPassInfo", "Password has been changed.");
        return "redirect:/user/dashboard";
    }

    @RequestMapping("/dashboard")
    public String dashboard(HttpSession session, Model model){

        model.addAttribute("dashboard", true);
        return "users/dashboard";
    }

    @GetMapping("/albums")
    private String allUserAlbums(Model model){
        /*model.addAttribute("albums", userService.getAllUserAlbums(loggedUser.getId()));*/
        return "users/allalbums";
    }

    @RequestMapping(value = "/addalbumtocollection/{id}", method = RequestMethod.GET)
    public String addAlbumToCollection(@PathVariable long id){
        userService.addAlbumToCollection(loggedUser.getId(), id);
        return "redirect:/albums/all";
    }

    @RequestMapping(value = "/deletealbumfromcollection/{id}", method = RequestMethod.GET)
    private String deleteAlbum(@PathVariable long id, HttpServletRequest request,  RedirectAttributes redirectAttributes){

        albumService.deleteAlbum(id);
        if ("true".equals(request.getParameter("back"))){
            return "redirect:/user/albums";
        }
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

    @ModelAttribute("allalbums")
    public List<Album> allAlbumsTest(){
        return albumService.getAllAlbums();
    }

    @ModelAttribute("useralbumids")
    public List<Long> allUsersAlbums(){
        return userService.getAllUserAlbums(loggedUser.getId());
    }
}

package pl.coderslab.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Album;
import pl.coderslab.model.LoggedUser;
import pl.coderslab.model.User;
import pl.coderslab.service.AlbumService;
import pl.coderslab.service.UserService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private LoggedUser loggedUser;

    @GetMapping("/newpassword")
    public String newPassword(){
        return "users/newPassword";
    }

    @PostMapping("/newpassword")
    public String newPassword(@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, @RequestParam("newPasswordRepeat") String newPasswordRepeat, Model model){
        if (!oldPassword.equals(loggedUser.getPassword())){
            model.addAttribute("errorInfo", "Old password doesn't match.");
            return "users/newPassword";
        }

        if (!newPassword.equals(newPasswordRepeat)){
            model.addAttribute("errorInfo", "Passwords don't match.");
            return "users/newPassword";
        }

        User user = userService.findUserByLogin(loggedUser.getLogin());
        user.setPasswordHashed(newPassword);
        userService.changePassword(user);
        model.addAttribute("newPassInfo", "Password has been changed.");
        return "users/dashboard";
    }

    @RequestMapping("/dashboard")
    public String dashboard(HttpSession session, Model model){
        return "users/dashboard";
    }

    @GetMapping("/all")
    private String allUserAlbums(Model model){
        model.addAttribute("albums", userService.getAllUserAlbums(loggedUser.getId()));
        return "users/allalbums";
    }

    @RequestMapping(value = "/addalbum/{id}", method = RequestMethod.GET)
    public String addAlbumToCollection(@PathVariable long id){
        userService.addAlbumToCollection(loggedUser.getId(), id);
        return "redirect:/albums/all";
    }

    @RequestMapping(value = "/deletealbum/{id}", method = RequestMethod.GET)
    public String deleteAlbumFromCollection(@PathVariable long id){
        userService.deleteAlbumFromCollection(loggedUser.getId(), id);
        return "redirect:/albums/all";
    }

    /*@ModelAttribute("albums")
    public List<Album> allAlbums(){
        System.out.println("controller1 " + albumService.getAllAlbums());
        return albumService.getAllAlbums();
    }*/

    @ModelAttribute("allalbums")
    public List<Album> allAlbumsTest(){
        return albumService.getAllAlbums();
    }

    @ModelAttribute("useralbumids")
    public List<Long> allUsersAlbums(){
        System.out.println("controller2 " + userService.getAllUserAlbums(loggedUser.getId()).size());
        return userService.getAllUserAlbums(loggedUser.getId());
    }
}

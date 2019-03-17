package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.model.Album;
import pl.coderslab.model.LoggedUser;
import pl.coderslab.model.User;
import pl.coderslab.service.AlbumService;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/addalbum/{id}", method = RequestMethod.GET)
    public String addAlbumToCollection(@PathVariable long id){
        userService.addAlbumToCollection(loggedUser.getId(), id);
        return "redirect:/albums/all";
    }

    @RequestMapping(value = "/deletealbum/{id}", method = RequestMethod.GET)
    private String deleteAlbum(@PathVariable long id, HttpServletRequest request,  RedirectAttributes redirectAttributes){

        albumService.deleteAlbum(id);
        if ("true".equals(request.getParameter("back"))){
            return "redirect:/user/albums";
        }
        return "redirect:/albums/all";
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

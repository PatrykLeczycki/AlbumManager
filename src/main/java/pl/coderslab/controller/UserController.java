package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.LoggedUser;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoggedUser loggedUser;

    /*@GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String register(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "users/register";
        }
        user.setPasswordHashed(user.getPassword());
        userService.addUser(user);
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){
        if (loggedUser.getLogin() == null){
            model.addAttribute("user", new User());
            return "users/login";
        }

        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model, HttpSession session){

        User validUser = userService.findUserByLogin(user.getLogin());

        if(validUser.getLogin() != null && BCrypt.checkpw(user.getPassword(), validUser.getPassword())){
            loggedUser.setLogin(user.getLogin());
            loggedUser.setPassword(user.getPassword());
            model.addAttribute("hello", "Hello, " + loggedUser.getLogin());
            session.setAttribute("logged", true);
            return "users/dashboard";
        }

        model.addAttribute("wrongData", "Incorrect login or password.");
        return "users/login";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session){
        if(loggedUser.getLogin() != null){
            loggedUser.setLogin(null);
            loggedUser.setPassword(null);
            model.addAttribute("logout", "You have been logged out.");  //TODO: dodać to do widoku index.jsp
            session.setAttribute("logged", false);
        }

        return "redirect:/";
    }*/


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
        /*if (loggedUser.getLogin() != null){
            return "users/dashboard";
        }

        return "redirect:/login";*/
    }
}

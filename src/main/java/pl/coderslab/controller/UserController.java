package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.LoggedUser;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoggedUser loggedUser;

    @GetMapping("/register")
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

        System.out.println("testlogin2");
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){

        User validUser = userService.findUserByLogin(user.getLogin());

        if(validUser.getLogin() != null && BCrypt.checkpw(user.getPassword(), validUser.getPassword())){
            loggedUser.setLogin(user.getLogin());
            loggedUser.setPassword(user.getPassword());
            return "redirect:/";
        }

        model.addAttribute("wrongData", "Incorrect login or password.");
        return "users/login";
    }

    @GetMapping("/newpassword")
    public String newPass(){
        if(loggedUser.getLogin() == null)
            return "redirect:/user/login";

        return "users/newPassword";
    }

    @PostMapping("/newpassword")
    public String newPass(@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, @RequestParam("newPasswordRepeat") String newPasswordRepeat, Model model){

        if (!oldPassword.equals(loggedUser.getPassword())){
            model.addAttribute("errorInfo", "Old password doesn't match.");
            return "user/newpassword";
        }

        if (!newPassword.equals(newPasswordRepeat)){
            model.addAttribute("errorInfo", "Passwords don't match.");
            return "user/newpassword";
        }
        User user = userService.findUserByLogin(loggedUser.getLogin());
        user.setPasswordHashed(newPassword);
        userService.changePassword(user);
        model.addAttribute("newPassInfo", "Password has been changed.");
        return "users/dashboard";
    }

    @GetMapping("/forgotpassword")
    public String forgotPass(){
        if (loggedUser.getLogin() == null){
            return "/users/lostPassword";
        }

        return "users/dashboard";
    }



}

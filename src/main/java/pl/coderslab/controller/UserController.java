package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String login(@ModelAttribute User user, Model model){

        User validUser = userService.findUserByLogin(user.getLogin());

        System.out.println(user.getLogin() + " " + user.getPassword());

        if(validUser.getLogin() != null && BCrypt.checkpw(user.getPassword(), validUser.getPassword())){
            loggedUser.setLogin(user.getLogin());
            loggedUser.setPassword(user.getPassword());
            return "redirect:/";
        }
        System.out.println(validUser.getLogin() + " " + validUser.getPassword() + "\n");

        model.addAttribute("wrongData", "Incorrect login or password.");
        return "users/login";

    }




}

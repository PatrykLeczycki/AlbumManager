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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@SessionAttributes("logged")
public class LoginRegisterController {

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

        return "redirect:/user/dashboard";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model, HttpSession session){

        User validUser = userService.findUserByLogin(user.getLogin());

        if(validUser.getLogin() != null && BCrypt.checkpw(user.getPassword(), validUser.getPassword())){
            loggedUser.setLogin(user.getLogin());
            loggedUser.setPassword(user.getPassword());
            model.addAttribute("hello", "Hello, " + loggedUser.getLogin());
            session.setAttribute("logged", loggedUser.getLogin());
            return "redirect:/user/dashboard";
        }


        model.addAttribute("wrongData", "Incorrect login or password.");
        return "users/login";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session){
        if(loggedUser.getLogin() != null){
            loggedUser.setLogin(null);
            loggedUser.setPassword(null);
            System.out.println("NULLLOGOUTTEST");
            model.addAttribute("logout", "You have been logged out.");  //TODO: dodać to do widoku index.jsp
            //session.setAttribute("logged", null);
            session.removeAttribute("logged");
        }

        return "redirect:/";
    }

    @GetMapping("/lostpassword")
    public String lostPassword(){
        if (loggedUser.getLogin() == null)
            return "/users/lostPassword";

        return "redirect:/user/dashboard";   //TODO: zrobić akcję do wyświetlania dashboarda i zmienić na redirect
    }

    //TODO: zagnieździć weryfikację

    @PostMapping("/lostpassword")
    public String lostPassword(@RequestParam("login") String login, @RequestParam("newPassword") String newPassword, @RequestParam("newPasswordRepeat") String newPasswordRepeat, Model model){

        if(userService.findUserByLogin(login).getLogin() == null){
            model.addAttribute("errorInfo", "No user with given login exists.");
            return "users/lostpassword";
        }

        if(!newPassword.equals(newPasswordRepeat)){
            model.addAttribute("errorInfo", "Passwords don't match.");
            return "users/lostpassword";
        }

        User user = userService.findUserByLogin(login);

        user.setPasswordHashed(newPassword);
        userService.changePassword(user);
        model.addAttribute("newPassInfo", "Password has been changed.");
        return "redirect:/user/login";
    }
}

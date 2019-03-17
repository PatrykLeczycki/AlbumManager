package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("/dashboard")
    public String dashboard(HttpSession session, Model model){

        model.addAttribute("dashboard", true);
        return "admins/dashboard";
    }

    @GetMapping("/users")
    public String all(Model model){
        model.addAttribute("users", userService.getAllUsers());
        //TODO: gryzie się z panelem powitalnym
        return "admins/allUsers";
    }

}

package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.LoggedUser;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private LoggedUser loggedUser;

    @RequestMapping("/")
    public String home(Model model){

        if (loggedUser.getLogin() != null){
            model.addAttribute("hello", "Hello, " + loggedUser.getLogin());
        }
        return "index";
    }
}
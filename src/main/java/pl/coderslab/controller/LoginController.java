package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String login(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();

        if(session.getAttribute("loggedUser") != null){
            return "/user";
        }

        return "users/login";
    }

    @PostMapping
    public String login(){
        return "index";
    }
}

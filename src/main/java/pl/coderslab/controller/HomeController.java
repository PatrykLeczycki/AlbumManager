package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.MyUserDetails;
import java.security.Principal;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "users/index";
    }

    @GetMapping("/403")
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            MyUserDetails loginedUser = (MyUserDetails) ((Authentication) principal).getPrincipal();

            String userInfo = loginedUser.toString();

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }

        return "403";
    }


}
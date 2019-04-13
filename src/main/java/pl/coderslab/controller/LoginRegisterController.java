package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.UserDto;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class LoginRegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("userDto") @Valid UserDto userDto, BindingResult result, Model model) {

        if (!result.hasErrors() && !userDto.getUsername().equals(userDto.getPassword()) &&
                userService.findUserByEmail(userDto.getEmail()) == null &&
                userDto.getPassword().equals(userDto.getMatchingPassword()) &&
                userService.findUserByUsername(userDto.getUsername()) == null &&
                userDto.getUsername().length() >= 5 && userDto.getPassword().length() >= 8) {

            userDto.setEnabled(true);
            userService.registerUser(userDto);
            return "redirect:/login";
        }

        model.addAttribute("emailexists", userService.findUserByEmail(userDto.getEmail()) != null);
        model.addAttribute("passwordseq", !userDto.getPassword().equals(userDto.getMatchingPassword()));
        model.addAttribute("usernameexists", userService.findUserByUsername(userDto.getUsername()) != null);
        model.addAttribute("usernameeqpass", userDto.getUsername().equals(userDto.getPassword()));
        return "register";
    }

    @GetMapping("/login")
    public String loginPanel(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth instanceof AnonymousAuthenticationToken)
            return "login";

        return "redirect:/user/dashboard";
    }

    /*@RequestMapping("/logout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "redirect:/";
    }*/

    @GetMapping("/lostpassword")
    public String lostPassword(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth instanceof AnonymousAuthenticationToken)
            return "lostpassword";

        return "redirect:/user/dashboard";
    }

    @RequestMapping(value = "/lostpassword", method=RequestMethod.POST)
    public String lostPassword(@ModelAttribute("user") UserDto userDto, Model model){

        User user = userService.findUserByEmail(userDto.getEmail());

        if ( Objects.isNull(user) || !user.getUsername().equals(userDto.getUsername()) ||
               userDto.getPassword().length() < 8 || !userDto.getPassword().equals(userDto.getMatchingPassword())){
            if (Objects.isNull(user) || !user.getUsername().equals(userDto.getUsername())) //
                model.addAttribute("wrongemailorusername", true);

            if ( userDto.getPassword().length() < 8)
                model.addAttribute("passlength", true);
            else if (!userDto.getPassword().equals(userDto.getMatchingPassword()))
                model.addAttribute("passnoteq", true);
            return "lostpassword";
        }

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userService.addUser(user);
        model.addAttribute("newPassInfo", "Password has been changed.");
        return "redirect:/login";
    }
}

package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.dom4j.DocumentException;
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
import pl.coderslab.utils.Prompt;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class LoginRegisterController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final Prompt prompt;

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("userDto") @Valid UserDto userDto, BindingResult result, Model model) throws MessagingException, IOException, DocumentException {

        if (!result.hasErrors() && !userDto.getUsername().equals(userDto.getPassword()) &&
                userService.findUserByEmail(userDto.getEmail()) == null &&
                userDto.getPassword().equals(userDto.getMatchingPassword()) &&
                userService.findUserByUsername(userDto.getUsername()) == null &&
                userDto.getUsername().length() >= 5 && userDto.getPassword().length() >= 8) {

            userDto.setEnabled(false);
            userService.registerUser(userDto);
            prompt.add("registersuccess");
            return "redirect:/login";
        }

        model.addAttribute("emailexists", !Objects.isNull(userService.findUserByEmail(userDto.getEmail())));
        model.addAttribute("passwordseq", !userDto.getPassword().equals(userDto.getMatchingPassword()));
        model.addAttribute("usernameexists", !Objects.isNull(userService.findUserByUsername(userDto.getUsername())));
        model.addAttribute("usernameeqpass", userDto.getUsername().equals(userDto.getPassword()));
        return "register";
    }

    @RequestMapping(value = "/register/{id}/{token}", method = RequestMethod.GET)
    public String register(@PathVariable long id, @PathVariable String token){

        User user = userService.findUserById(id);

        if(!Objects.isNull(user) && user.getRegistrationToken().equals(token)){
            user.setRegistrationToken(null);
            user.setEnabled(true);
            userService.addUser(user);
        } else prompt.add("linkcorrupted");

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPanel(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth instanceof AnonymousAuthenticationToken){

            if(prompt.doesContain("registersuccess")){
                prompt.getNames().remove("registersuccess");
                model.addAttribute("registersuccess", true);
            }

            if(prompt.doesContain("recoverymailsent")){
                prompt.getNames().remove("recoverymailsent");
                model.addAttribute("recoverymailsent", true);
            }

            if(prompt.doesContain("linkcorrupted")){
                prompt.getNames().remove("linkcorrupted");
                model.addAttribute("linkcorrupted", true);
            }

            if(prompt.doesContain("passwordchanged")){
                prompt.getNames().remove("passwordchanged");
                model.addAttribute("passwordchanged", true);
            }

            return "login";
        }

        return "redirect:/user/dashboard";
    }

    @GetMapping("/lostpassword")
    public String lostPassword(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth instanceof AnonymousAuthenticationToken)
            return "lostpassword1";

        return "redirect:/user/dashboard";
    }

    @PostMapping("/lostpassword")
    public String lostPassword(@RequestParam("email-login") String emailLogin, Model model){

        User user = userService.findUserByEmail(emailLogin);

        if (Objects.isNull(user)){
            user = userService.findUserByUsername(emailLogin);
            if (Objects.isNull(user)){
                model.addAttribute("wrongemailorlogin", true);
                return "lostpassword1";
            }
        }

        userService.addPassRecoveryToken(user.getEmail());
        userService.sendPassRecoveryEmail(user.getEmail());

        prompt.add("recoverymailsent");

        return "redirect:/login";
    }

    @RequestMapping(value = "/lostpassword/{id}/{token}", method = RequestMethod.GET)
    @Transactional
    public String lostPassword(@PathVariable long id, @PathVariable String token, Model model){

        User user = userService.findUserById(id);

        if (!Objects.isNull(user)){
            String userToken = user.getPassRecoveryToken();
            if (userToken.equals(token)){
                user.setPassRecoveryToken(null);
                userService.addUser(user);
                model.addAttribute("id", id);
                model.addAttribute("token", token);
                return "lostpassword2";
            }
        }

        prompt.add("linkcorrupted");

        return "redirect:/login";
    }

    @RequestMapping(value = "/lostpassword/{id}/{token}", method=RequestMethod.POST)
    public String lostPassword(@PathVariable long id, @PathVariable String token, @RequestParam("newPassword") String newPassword, @RequestParam("newPasswordRepeat") String newPasswordRepeat, Model model){

        if(newPassword.length() < 8 || !newPassword.equals(newPasswordRepeat)){
            if (newPassword.length() < 8)
                model.addAttribute("passlength", true);
            if (!newPassword.equals(newPasswordRepeat))
                model.addAttribute("passnoteq", true);

            model.addAttribute("id", id);
            model.addAttribute("token", token);

            return "lostpassword2";
        }

        User user = userService.findUserById(id);

        if (!Objects.isNull(user)){
            user.setPassword(passwordEncoder.encode(newPassword));
            userService.addUser(user);
            prompt.add("passwordchanged");
        }

        return "redirect:/login";
    }
}

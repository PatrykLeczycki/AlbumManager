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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@SessionAttributes({"logged", "toLogin", "emailpattern", "emailexists", "passwordsequal", "loginexists", "loginlength", "passlength", "loginerror"})
public class LoginRegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoggedUser loggedUser;

    //TODO: dorzucić oddzielny widok rejestracji

    @GetMapping("/register")
    public String register(){
        return "users/register";
    }

    @PostMapping("/register")
    public String register(@RequestParam("email") String email, @RequestParam("login") String login, @RequestParam("password1") String password, @RequestParam("password2") String confirmPassword, Model model, HttpSession session){

        String emailPatternString = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}";

        Pattern emailPattern = Pattern.compile(emailPatternString);

        Matcher matcher = emailPattern.matcher(email);

        if (matcher.matches() && userService.findUserByEmail(email) == null && password.equals(confirmPassword) && userService.findUserByLogin(login) == null && login.length() >= 5 && password.length() >= 8){
            User user = new User(login, password, email);
            userService.addUser(user);
            session.removeAttribute("emailpattern");
            session.removeAttribute("emailexists");
            session.removeAttribute("passwordsequal");
            session.removeAttribute("loginexists");
            session.removeAttribute("loginlength");
            session.removeAttribute("passlength");

            return "redirect:/loginpanel";
        }

        model.addAttribute("emailpattern", !matcher.matches());
        model.addAttribute("emailexists", userService.findUserByEmail(email) != null);
        model.addAttribute("passwordsequal", !password.equals(confirmPassword));
        model.addAttribute("loginexists", userService.findUserByLogin(login) != null);
        model.addAttribute("loginlength", login.length() < 5);
        model.addAttribute("passlength", password.length() < 8);
        return "users/register";    //TODO: tutaj pewnie będzie wyświetlenie nowego widoku
    }

    @GetMapping("/login")
    public String loginPanel(){

        if (loggedUser.getLogin() == null)
            return "users/login";

        return "redirect:/user/dashboard";
    }

    //TODO: zagnieździć weryfikację

    @PostMapping("/login")
    public String loginPanel(@RequestParam("login") String login, @RequestParam("password") String password, HttpSession session, Model model){

        User userFromDb = userService.findUserByLogin(login);

        if(userFromDb != null && BCrypt.checkpw(password, userFromDb.getPassword())){
            System.out.println(login + " x " + userFromDb.getLogin());
            loggedUser = new LoggedUser(login, password);
            loggedUser.setId(userFromDb.getId());
            loggedUser.setEmail(userFromDb.getEmail());
            loggedUser.setAlbums(userFromDb.getAlbums());

            session.removeAttribute("loginerror");
            model.addAttribute("logged", true);
            return "redirect:/user/dashboard";
        }

        model.addAttribute("loginerror", true);
        model.addAttribute("toLogin", true);
        return "redirect:/login";
    }

    @RequestMapping("/logout")
    public String logout(Model model){
        if(loggedUser.getLogin() != null){
            userService.findUserByLogin(loggedUser.getLogin()).setAlbums(loggedUser.getAlbums());
            loggedUser.setId(0L);
            loggedUser.setLogin(null);
            loggedUser.setPassword(null);
            model.addAttribute("logout", "You have been logged out.");  //TODO: dodać to do widoku index.jsp
            model.addAttribute("logged", false);
        }
        return "redirect:/";
    }

    @GetMapping("/lostpassword")
    public String lostPassword(){
        if (loggedUser.getLogin() == null)
            return "/users/lostPassword";

        return "redirect:/user/dashboard";
    }

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
        return "redirect:/loginpanel";
    }
}

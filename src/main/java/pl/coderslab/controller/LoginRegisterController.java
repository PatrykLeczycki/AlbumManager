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
@SessionAttributes({"logged", "toLogin", "emailpattern", "emailexists", "passwordsequal", "loginexists", "loginlength", "passlength"})
public class LoginRegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoggedUser loggedUser;

    //TODO: dorzucić oddzielny widok rejestracji

    @GetMapping("/register")
    public String register(){
        System.out.println("test1");
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

    /*@GetMapping("/register")
    public String register(Model model){
        System.out.println("test1");


        return "users/register";
    }

    @PostMapping(value = "/register")
    public String register(@RequestParam("email") String email, @RequestParam("login") String login, @RequestParam("password1") String password, @RequestParam("password2") String confirmPassword){

        System.out.println("test");

        String emailPatternString = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}";

        Pattern emailPattern = Pattern.compile(emailPatternString);

        Matcher matcher = emailPattern.matcher(email);

        if (!matcher.matches() || userService.findUserByEmail(email) != null || !password.equals(confirmPassword) || userService.findUserByLogin(login) != null || login.length() < 5 || password.length() < 8){
            return "modals/register";    //TODO: tutaj pewnie będzie wyświetlenie nowego widoku
        }

        User user = new User(login, password, email);
        userService.addUser(user);

        return "redirect:/loginpanel";
    }*/

    /*@GetMapping("/loginpanel")
    public String testLoginPanel(){
        if (loggedUser.getLogin() == null){
            return "users/login";
        }
        return "redirect:/user/dashboard";
    }*/

    /*@RequestMapping(value = "/loginpanel", method = RequestMethod.GET)
    public String testLoginPanel(@RequestParam("login") String login, @RequestParam("password") String password, Model model) {

        User userFromDb = userService.findUserByLogin(login);
        if (userFromDb == null){
            model.addAttribute("notfound", "Couldn't find user with given login");
        } else if (!BCrypt.checkpw(password, userFromDb.getPassword())){
            model.addAttribute("wrongpass", "Wrong password");
        } else {
            loggedUser.setId(userFromDb.getId());
            loggedUser.setLogin(login);
            loggedUser.setPassword(password);
            loggedUser.setAlbums(userFromDb.getAlbums());
            return "redirect:/user/dashboard";
        }

        return "modals/login";
    }*/

    @GetMapping("/loginpanel")
    public String loginPanel(Model model){

        model.addAttribute("user", new User());
        return "users/login";
    }

    //TODO: zagnieździć weryfikację

    @PostMapping("/loginpanel")
    public String loginPanel(@Valid User user, BindingResult result, Model model){

        if(result.hasErrors()){
            return "users/login";
        }

        User userFromDb = userService.findUserByLogin(user.getLogin());

        // TODO: loggedUser.getLogin() != null dać do geta

        if(loggedUser.getLogin() != null || (userFromDb.getLogin() != null && BCrypt.checkpw(user.getPassword(), userFromDb.getPassword()))){
            loggedUser.setId(userService.findUserByLogin(user.getLogin()).getId());
            loggedUser.setLogin(user.getLogin());
            loggedUser.setPassword(userService.findUserByLogin(user.getLogin()).getPassword());
            loggedUser.setAlbums(userService.findUserByLogin(user.getLogin()).getAlbums());
            model.addAttribute("hello", "Hello, " + loggedUser.getLogin());
            model.addAttribute("logged", true);

            return "redirect:/user/dashboard";
        }

        model.addAttribute("wrongData", "Incorrect login or password.");
        model.addAttribute("toLogin", true);
        return "redirect:/loginpanel";
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

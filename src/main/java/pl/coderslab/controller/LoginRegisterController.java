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

import javax.validation.Valid;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@SessionAttributes({"logged", "toLogin"})
public class LoginRegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoggedUser loggedUser;

    // TODO: POTESTOWAĆ SKRAJNE PRZYPADKI, przekierowanie do #myModal

    /*@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@RequestParam("email") String email, @RequestParam("login") String login, @RequestParam("password1") String password, @RequestParam("password2") String confirmPassword){
        if (!password.equals(confirmPassword) || userService.findUserByLogin(login) != null || login.length() < 5 || password.length() < 8){
            return "redirect:/#myModalRegister";
        }

        User user = new User(login, password, email);
        userService.addUser(user);

        return "redirect:/#myModal";
    }*/

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@RequestParam("email") String email, @RequestParam("login") String login, @RequestParam("password1") String password, @RequestParam("password2") String confirmPassword, Model model){

        String text    =
                "This is the text to be searched " +
                        "for occurrences of the http:// pattern.";

        String emailPatternString = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}";

        Pattern emailPattern = Pattern.compile(emailPatternString);

        Matcher matcher = emailPattern.matcher(email);

        if (!matcher.matches() || userService.findUserByEmail(email) != null || !password.equals(confirmPassword) || userService.findUserByLogin(login) != null || login.length() < 5 || password.length() < 8){

            if (!matcher.matches())

            return "redirect:/register";
        }

        User user = new User(login, password, email);
        userService.addUser(user);
        model.addAttribute("toLogin", true);

        return "redirect:/loginpanel";
    }

    @GetMapping("/loginpanel")
    public String loginPanel(Model model){

        model.addAttribute("user", new User());
        return "users/login";
    }

    @PostMapping("/loginpanel")
    public String loginPanel(@Valid User user, BindingResult result, Model model){

        if(result.hasErrors()){
            return "users/login";
        }

        User userFromDb = userService.findUserByLogin(user.getLogin());

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

    /*@RequestMapping("/login")
    public String login(@RequestParam("login") String login, @RequestParam("password") String password, Model model){

        User tempUser = new User(login, password);

        User userFromDb = userService.findUserByLogin(login);

        if(userFromDb != null){
            tempUser.setId(userService.findUserByLogin(tempUser.getLogin()).getId());
            tempUser.setEmail(userService.findUserByLogin(tempUser.getLogin()).getEmail());

            if(loggedUser.getLogin() != null || (userFromDb.getLogin() != null && BCrypt.checkpw(tempUser.getPassword(), userFromDb.getPassword()))){
                long id = tempUser.getId();
                loggedUser.setId(id);
                loggedUser.setLogin(tempUser.getLogin());
                loggedUser.setPassword(tempUser.getPassword());
                loggedUser.setAlbums(tempUser.getAlbums());
                model.addAttribute("hello", "Hello, " + loggedUser.getLogin());
                model.addAttribute("logged", true);

                return "redirect:/user/dashboard";
            }
        }

        // TODO: stworzyć sztuczny widok do przechodzenia do /#myModal

        model.addAttribute("wrongData", "Incorrect login or password.");
        model.addAttribute("toLogin", true);
        return "redirect:/login";
    }
*/
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

        return "redirect:/user/dashboard";   //TODO: zrobić akcję do wyświetlania dashboarda i zmienić na redirect
    }

    //TODO: zagnieździć weryfikację

    /*@PostMapping("/lostpassword")
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
        return "redirect:/#myModal";
    }*/

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
        return "redirect:/login";
    }
}

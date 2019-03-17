package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.LoggedUser;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@SessionAttributes({"user", "admin"})
public class LoginRegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoggedUser loggedUser;

    @GetMapping("/register")
    public String register(HttpSession session){
        return "users/register";
    }

    @PostMapping("/register")
    public String register(@RequestParam("email") String email, @RequestParam("login") String login, @RequestParam("password1") String password, @RequestParam("password2") String confirmPassword, Model model, HttpSession session){

        String emailPatternString = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}";

        Pattern emailPattern = Pattern.compile(emailPatternString);

        Matcher matcher = emailPattern.matcher(email);

        if (matcher.matches() && !login.equals(password) && userService.findUserByEmail(email) == null && password.equals(confirmPassword) && userService.findUserByLogin(login) == null && login.length() >= 5 && password.length() >= 8){

            User user = new User(login, password, email);
            userService.addUser(user);
            return "redirect:/login";
        }

        model.addAttribute("emailpattern", !matcher.matches());
        model.addAttribute("emailexists", userService.findUserByEmail(email) != null);
        model.addAttribute("passwordseq", !password.equals(confirmPassword));
        model.addAttribute("loginexists", userService.findUserByLogin(login) != null);
        model.addAttribute("loginlength", login.length() < 5);
        model.addAttribute("passlength", password.length() < 8);
        model.addAttribute("logineqpass", login.equals(password));
        return "users/register";
    }

    @GetMapping("/login")
    public String loginPanel(HttpSession session){

        if (loggedUser.getLogin() == null)
            return "users/login";

        return "redirect:/user/dashboard";
    }

    //TODO: logowanie dziwnie działa (czasem podwójnie wchodzi do posta)

    @PostMapping("/login")
    public String loginPanel(@RequestParam("login") String login, @RequestParam("password") String password, HttpSession session, Model model){

        User userFromDb = userService.findUserByLogin(login);

        if(userFromDb == null || !BCrypt.checkpw(password, userFromDb.getPassword())){
            model.addAttribute("loginerror", true);
            return "users/login";
        }

        loggedUser.setLogin(userFromDb.getLogin());
        loggedUser.setPassword(userFromDb.getPassword());
        loggedUser.setId(userFromDb.getId());
        loggedUser.setEmail(userFromDb.getEmail());
        loggedUser.setAdmin(userFromDb.isAdmin());
        loggedUser.setAlbums(userFromDb.getAlbums());

        if (loggedUser.isAdmin()){
            model.addAttribute("admin", true);
            return "redirect:/admin/dashboard";
        }
        else{
            model.addAttribute("user", true);
            return "redirect:/user/dashboard";
        }
    }

    @RequestMapping("/logout")
    public String logout(Model model){
        if(loggedUser.getLogin() != null){
            // TODO: sprawdzić czy przypisywanie albumów jest konieczne
            userService.findUserByLogin(loggedUser.getLogin()).setAlbums(loggedUser.getAlbums());
            loggedUser.setId(0L);
            loggedUser.setLogin(null);
            loggedUser.setPassword(null);
            model.addAttribute("logout", "You have been logged out.");  //TODO: dodać to do widoku index.jsp
            model.addAttribute("admin", false);
            model.addAttribute("user", false);
        }
        return "redirect:/";
    }

    @GetMapping("/lostpassword")
    public String lostPassword(){
        if (loggedUser.getLogin() == null)
            return "users/lostPassword";

        return "redirect:/user/dashboard";
    }

    @RequestMapping(value = "/lostpassword", method=RequestMethod.POST)
    public String lostPassword(@RequestParam("email") String email, @RequestParam("login") String login, @RequestParam("newPassword") String newPassword, @RequestParam("newPasswordRepeat") String newPasswordRepeat, Model model){

        String emailPatternString = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}";

        Pattern emailPattern = Pattern.compile(emailPatternString);
        Matcher matcher = emailPattern.matcher(email);
        User user = userService.findUserByEmail(email);

        if (!matcher.matches() || user == null || !user.getLogin().equals(login) || newPassword.length() <= 8 || newPasswordRepeat.length() < 8 || !newPassword.equals(newPasswordRepeat)){
            if (!matcher.matches())
                model.addAttribute("wrongpattern", true);
            else if (user == null || !user.getLogin().equals(login)) //
                model.addAttribute("wrongemailorlogin", true);

            if (newPassword.length() <= 8 || newPasswordRepeat.length() < 8)
                model.addAttribute("passlength", true);
            else if (!newPassword.equals(newPasswordRepeat))
                model.addAttribute("passnoteq", true);
        }

        user.setPasswordHashed(newPassword);
        userService.addUser(user);
        model.addAttribute("newPassInfo", "Password has been changed.");
        return "redirect:/login";
    }
}

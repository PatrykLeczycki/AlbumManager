package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.*;
import pl.coderslab.repository.RoleRepository;
import pl.coderslab.service.*;
import pl.coderslab.utils.Prompt;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Objects;

import static pl.coderslab.utils.Functions.getCountries;
import static pl.coderslab.utils.Functions.getFormats;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final AlbumService albumService;
    private final ArtistService artistService;
    private final BandService bandService;
    private final LabelService labelService;
    private final RoleRepository roleRepository;
    private final Prompt prompt;

    @GetMapping("/users")
    public String all(Model model, Principal principal){

        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("loggedUser", principal.getName());

        if(prompt.doesContain("usernotfound")){
            prompt.getNames().remove("usernotfound");
            model.addAttribute("usernotfound", true);
        }

        if(prompt.doesContain("ownrole")){
            prompt.getNames().remove("ownrole");
            model.addAttribute("ownrole", true);
        }

        return "admins/allusers";
    }

    @RequestMapping(value = "/changerole/{id}", method = RequestMethod.GET)
    public String changeUserRole(@PathVariable long id, Principal principal){

        User user = userService.findUserById(id);

        if(!Objects.isNull(user)){
            if(!user.getUsername().equals(principal.getName())){
                if(user.getRoleSet().contains(roleRepository.findByName("ROLE_ADMIN")))
                    user.getRoleSet().remove(roleRepository.findByName("ROLE_ADMIN"));
                else user.getRoleSet().add(roleRepository.findByName("ROLE_ADMIN"));
                userService.addUser(user);

                return "redirect:/admin/users";
            }

            prompt.add("ownrole");
            return "admins/allusers";
        }

        prompt.add("usernotfound");
        return "redirect:/admin/users";
    }



    ///////////////////////////////////////////////////////////////

  /*  @ModelAttribute("labels")
    public List<Label> getLabels(){
        return labelService.getAllLabels();
    }

    @ModelAttribute("artists")
    public List<Artist> getArtists(){
        return artistService.getAllArtists();
    }

    @ModelAttribute("bands")
    public List<Band> getBands(){
        return bandService.getAllBands();
    }

    @ModelAttribute("formats")
    public List<String> formats(){
        return getFormats();
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return getCountries();
    }

    // TODO: wywalić to, gdy ogarnę przenoszenie atrybutu z kontrolera do kontrolera

    @ModelAttribute("useralbumsids")
    public List<Long> allUserAlbumIds(Principal principal){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth instanceof AnonymousAuthenticationToken)
            return null;

        Long id = userService.findUserByUsername(principal.getName()).getId();

        return albumService.getAlbumIdsByUserId(id);
    }*/
}

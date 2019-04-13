package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.service.AlbumService;
import pl.coderslab.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    private String allAlbums(Model model){
        model.addAttribute("albums", albumService.getAllAlbums());
        return "albums/all";
    }

    @ModelAttribute("useralbumsids")
    public List<Long> allUserAlbumIds(Principal principal){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth instanceof AnonymousAuthenticationToken)
            return null;

        Long id = userService.findUserByUsername(principal.getName()).getId();

        return albumService.getAlbumIdsByUserId(id);
    }
}

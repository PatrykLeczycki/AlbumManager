package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.model.Album;
import pl.coderslab.model.Artist;
import pl.coderslab.model.Label;
import pl.coderslab.model.LoggedUser;
import pl.coderslab.model.enums.Format;
import pl.coderslab.service.AlbumService;
import pl.coderslab.service.ArtistService;
import pl.coderslab.service.LabelService;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private LabelService labelService;

    @Autowired
    private LoggedUser loggedUser;

    @RequestMapping("/dashboard")
    public String dashboard(HttpSession session, Model model){

        model.addAttribute("dashboard", true);
        return "admins/dashboard";
    }

    @GetMapping("/users")
    public String all(Model model){
        model.addAttribute("users", userService.getAllUsers());
        //TODO: gryzie się z panelem powitalnym
        return "admins/allUsers";
    }

    ///////////////////////////////////////////////////////////////
    // ADMIN'S ALBUMS

    @GetMapping("/albums")
    private String allUserAlbums(Model model){
        return "admins/allalbums";
    }

    @RequestMapping(value = "/collectionaddalbum/{id}", method = RequestMethod.GET)
    public String addAlbumToCollection(@PathVariable long id){
        userService.addAlbumToCollection(loggedUser.getId(), id);
        return "redirect:/albums/all";
    }

    @RequestMapping(value = "/collectiondeletealbum/{id}", method = RequestMethod.GET)
    public String deleteAlbumFromCollection(@PathVariable long id, HttpServletRequest request){
        userService.deleteAlbumFromCollection(loggedUser.getId(), id);
        if ("true".equals(request.getParameter("back"))){
            return "redirect:/admin/albums";
        }
        return "redirect:/albums/all";
    }

    ///////////////////////////////////////////////////////////////
    // ALBUMS ACTIONS

    @GetMapping("/editalbum/{id}")
    private String editAlbum(@PathVariable long id, Model model){
        model.addAttribute("album", albumService.getAlbumById(id));
        return "albums/edit";
    }

    @PostMapping("/editalbum")
    private String editAlbum(@Valid Album album, BindingResult result){
        if (result.hasErrors())
            return "albums/edit";

        albumService.addAlbum(album);
        return "redirect:/albums/all";
    }

    @RequestMapping(value = "/deletealbum/{id}", method = RequestMethod.GET)
    private String deleteAlbum(@PathVariable long id, HttpServletRequest request,  RedirectAttributes redirectAttributes){

        albumService.deleteAlbum(id);
        return "redirect:/albums/all";
    }

    ///////////////////////////////////////////////////////////////

    // ARTISTS ACTIONS

    @GetMapping("/editartist/{id}")
    private String editArtist(@PathVariable long id, Model model){
        model.addAttribute("artist", artistService.getArtistById(id));
        return "artists/edit";
    }

    @PostMapping("/editartist")
    private String editArtist(@Valid Artist artist, BindingResult result){
        if (result.hasErrors())
            return "artists/edit";

        artistService.addArtist(artist);
        return "redirect:/artists/all";
    }

    @GetMapping("/deleteartist/{id}")
    private String deleteArtist(@PathVariable long id){
        artistService.deleteArtist(id);
        return "redirect:/artists/all";
    }

    ///////////////////////////////////////////////////////////////

    @ModelAttribute("labels")
    public List<Label> getLabels(){
        return labelService.getAllLabels();
    }

    @ModelAttribute("artists")
    public List<Artist> getArtists(){
        return artistService.getAllArtists();
    }

    @ModelAttribute("formats")
    public List<String> getFormats(){
        Format[] formats = Format.values();
        List<String> formatList = new ArrayList<>();

        for (Format f : formats){
            formatList.add(f.name());
        }

        return formatList;
    }

    @ModelAttribute("allalbums")
    public List<Album> allAlbumsTest1(){
        System.out.println("all albums " + albumService.getAllAlbums().size());
        return albumService.getAllAlbums();
    }

    @ModelAttribute("adminalbumids")
    public List<Long> allAdminAlbums(){
        System.out.println("all admin albums " + userService.getAllUserAlbums(loggedUser.getId()).size());
        return userService.getAllUserAlbums(loggedUser.getId());
    }
}

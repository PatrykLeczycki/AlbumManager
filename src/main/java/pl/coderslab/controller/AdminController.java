package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.model.*;
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
        model.addAttribute("loggedUserId", loggedUser.getId());
        //TODO: gryzie się z panelem powitalnym
        return "admins/allUsers";
    }

    @RequestMapping(value = "/changerole/{id}", method = RequestMethod.GET)
    public String changeUserRole(@PathVariable long id){

        User user = userService.findUserById(id);

        if(user.isAdmin())
            user.setAdmin(false);
        else user.setAdmin(true);

        userService.addUser(user);

        return "redirect:/admin/users";
    }
    ///////////////////////////////////////////////////////////////
    // ADMIN'S ALBUMS

    @GetMapping("/albums")
    private String allUserAlbums(Model model){
        return "admins/allalbums";
    }

    @RequestMapping(value = "/addalbumtocollection/{id}", method = RequestMethod.GET)
    public String addAlbumToCollection(@PathVariable long id){
        userService.addAlbumToCollection(loggedUser.getId(), id);
        return "redirect:/albums/all";
    }

    @RequestMapping(value = "/deletealbumfromcollection/{id}", method = RequestMethod.GET)
    public String deleteAlbumFromCollection(@PathVariable long id, HttpServletRequest request){
        userService.deleteAlbumFromCollection(loggedUser.getId(), id);
        if ("true".equals(request.getParameter("back"))){
            return "redirect:/admin/albums";
        }
        return "redirect:/albums/all";
    }

    ///////////////////////////////////////////////////////////////
    // ALBUMS ACTIONS

    @GetMapping("/addalbum")
    private String addAlbum(Model model){
        model.addAttribute("album", new Album());
        return "albums/add";
    }

    @PostMapping("/addalbum")
    private String addAlbum(@Valid Album album, BindingResult result){
        //TODO: dać tłumaczenia błędów
        if (result.hasErrors())
            return "albums/add";

        albumService.addAlbum(album);
        return "redirect:/albums/all";
    }

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

    @GetMapping("/addartist")
    private String addArtist(Model model){
        model.addAttribute("artist", new Artist());
        return "artists/add";
    }

    // TODO: sprawdzić debuggerem, czemu trzeba odświeżyć, żeby zobaczyć świeżo dodany item

    @PostMapping("/addartist")
    private String addArtist(@Valid Artist artist, BindingResult result){
        //TODO: dać tłumaczenia błędów
        if (result.hasErrors())
            return "artists/add";

        artistService.addArtist(artist);
        return "redirect:/artists/all";
    }

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

    // LABEL ACTIONS

    @GetMapping("/addlabel")
    public String addLabel(Model model){
        model.addAttribute("label", new Label());
        return "labels/add";
    }

    @PostMapping("/addlabel")
    public String addLabel(@Valid Label label, BindingResult result){

        //TODO: dać tłumaczenia błędów
        if (result.hasErrors())
            return "labels/add";

        labelService.addLabel(label);
        return "redirect:/labels/all";
    }

    @GetMapping("/editlabel/{id}")
    public String editLabel(@PathVariable long id, Model model){
        model.addAttribute("label", labelService.getLabelById(id));
        return "labels/edit";
    }

    @PostMapping("/editlabel")
    public String editLabel(@Valid Label label, BindingResult result){
        if (result.hasErrors())
            return "labels/edit";

        labelService.addLabel(label);
        return "redirect:/labels/all";
    }

    @GetMapping("/deletelabel/{id}")
    public String deleteLabel(@PathVariable long id){
        labelService.deleteLabel(id);
        return "redirect:/labels/all";
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
        return albumService.getAllAlbums();
    }

    @ModelAttribute("adminalbumids")
    public List<Long> allAdminAlbums(){
        return userService.getAllUserAlbums(loggedUser.getId());
    }
}

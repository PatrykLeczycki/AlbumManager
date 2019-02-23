package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping
public class HomeController {

    @RequestMapping
    public String home(){
        return "index";
    }


    @ModelAttribute("countries")
    public List<String> countries(){
        String[] locales = Locale.getISOCountries();

        List<String> names = new ArrayList<>();

        for (String countryCode : locales){
            names.add(new Locale("", countryCode).getDisplayCountry());
        }

        Collections.sort(names);

        return names;
    }

}
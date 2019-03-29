package pl.coderslab.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Functions {

    public static List<String> getCountries() {
        Locale.setDefault(new Locale("en"));
        String[] locales = Locale.getISOCountries();

        List<String> names = new ArrayList<>();

        for (String countryCode : locales)
            names.add(new Locale("", countryCode).getDisplayCountry());

        Collections.sort(names);
        return names;
    }

}

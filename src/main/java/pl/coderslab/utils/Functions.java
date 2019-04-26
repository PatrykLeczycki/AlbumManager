package pl.coderslab.utils;

import pl.coderslab.model.enums.Format;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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

    public static List<String> getFormats() {
        Format[] formats = Format.values();
        List<String> formatList = new ArrayList<>();

        for (Format f : formats){
            formatList.add(f.name());
        }

        return formatList;
    }

    public static String[] getData(){
//        File file = new File("/usr/local/bin/albummanager/data.txt");

        File file = new File("/password/data.txt");
        String[] data = new String[2];

        try (Scanner scan = new Scanner(file)) {
            //read lines from file
            data[0] = scan.nextLine();
            data[1] = scan.nextLine();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        return data;
    }

}

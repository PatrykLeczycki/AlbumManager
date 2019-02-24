package pl.coderslab.converter;

import org.springframework.core.convert.converter.Converter;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(String s) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        LocalDate date = LocalDate.parse(s, formatter);
        return date;
    }
}

/*public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {

        DateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");
        Date date = null;
        try {
            date = formatter.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}*/

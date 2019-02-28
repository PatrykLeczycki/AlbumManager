package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Artist;
import pl.coderslab.service.ArtistService;

public class ArtistConverter implements Converter<String, Artist> {

    @Autowired
    private ArtistService artistService;

    @Override
    public Artist convert(String s) {
            return artistService.getArtistById(Long.parseLong(s));
    }
}

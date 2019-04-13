package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Artist;
import pl.coderslab.service.ArtistService;

import java.util.Optional;

public class ArtistConverter implements Converter<String, Artist> {

    @Autowired
    private ArtistService artistService;

    @Override
    public Artist convert(String s) {

        Optional<Artist> optionalArtist = artistService.getArtistById(Long.parseLong(s));
        return optionalArtist.orElse(null);

    }
}

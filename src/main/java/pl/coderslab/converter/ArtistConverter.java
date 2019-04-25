package pl.coderslab.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Artist;
import pl.coderslab.service.ArtistService;
import java.util.Objects;

@RequiredArgsConstructor
public class ArtistConverter implements Converter<String, Artist> {

    private final ArtistService artistService;

    @Override
    public Artist convert(String s) {

        Artist artist = artistService.getArtistById(Long.parseLong(s));

        if (!Objects.isNull(artist))
            return artist;

        return null;
    }
}

package pl.coderslab.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Band;
import pl.coderslab.service.BandService;

import java.util.Objects;

@RequiredArgsConstructor
public class BandConverter implements Converter<String, Band> {

    private final BandService bandService;

    @Override
    public Band convert(String s) {

        Band band = bandService.getBandById(Long.parseLong(s));

        if(!Objects.isNull(band))
            return band;

        return null;
    }
}

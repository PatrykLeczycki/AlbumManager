package pl.coderslab.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Label;
import pl.coderslab.service.LabelService;
import java.util.Objects;

@RequiredArgsConstructor
public class LabelConverter implements Converter<String, Label> {


    private final LabelService labelService;

    @Override
    public Label convert(String s) {
        Label label = labelService.getLabelById(Long.parseLong(s));

        if (!Objects.isNull(label))
            return label;

        return null;

    }
}

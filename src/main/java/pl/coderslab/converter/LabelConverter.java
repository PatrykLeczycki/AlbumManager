package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Label;
import pl.coderslab.service.LabelService;

import java.util.Optional;

public class LabelConverter implements Converter<String, Label> {

    @Autowired
    private LabelService labelService;

    @Override
    public Label convert(String s) {
        Optional<Label> optionalLabel = labelService.getLabelById(Long.parseLong(s));

        return optionalLabel.orElse(null);
    }
}

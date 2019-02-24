package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Label;
import pl.coderslab.service.LabelService;

public class LabelConverter implements Converter<String, Label> {

    @Autowired
    private LabelService labelService;

    @Override
    public Label convert(String s) {
        return labelService.getLabelById(Long.parseLong(s));
    }
}

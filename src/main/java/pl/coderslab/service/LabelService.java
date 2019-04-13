package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Label;
import pl.coderslab.repository.LabelRepository;

import java.util.List;
import java.util.Optional;

@Component
public class LabelService {

    @Autowired
    private LabelRepository labelRepository;

    public void addLabel(Label label){
        labelRepository.save(label);
    }

    public List<Label> getAllLabels(){
        return labelRepository.findAll();
    }

    public Optional<Label> getLabelById(long id){
        return labelRepository.findById(id);
    }

    public void deleteLabel(long id){
        labelRepository.deleteById(id);
    }
}
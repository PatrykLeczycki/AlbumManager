package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Label;
import pl.coderslab.repository.LabelRepo;

import java.util.List;
import java.util.Optional;

@Component
public class LabelService {

    @Autowired
    private LabelRepo labelRepo;

    public void addLabel(Label label){
        labelRepo.save(label);
    }

    public List<Label> getAllLabels(){
        return labelRepo.findAll();
    }

    public Optional<Label> getLabelById(long id){
        return labelRepo.findById(id);
    }

    public void deleteLabel(long id){
        labelRepo.deleteById(id);
    }
}
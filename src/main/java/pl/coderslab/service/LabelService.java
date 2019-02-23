package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Label;
import pl.coderslab.repository.LabelRepo;

import java.util.List;

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

    public Label getLabelById(long id){
        return labelRepo.findOne(id);
    }
}

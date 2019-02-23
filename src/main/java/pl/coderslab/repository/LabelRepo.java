package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Label;

public interface LabelRepo extends JpaRepository <Label, Long> {
}

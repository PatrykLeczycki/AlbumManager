package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Band;

public interface BandRepository extends JpaRepository<Band, Long> {
}

package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Artist;

public interface ArtistRepo extends JpaRepository<Artist, Long> {
}

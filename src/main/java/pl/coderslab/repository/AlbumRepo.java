package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Album;

public interface AlbumRepo extends JpaRepository<Album, Long> {
}

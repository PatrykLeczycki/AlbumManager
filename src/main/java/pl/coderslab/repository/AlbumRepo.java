package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Album;

import java.util.List;

public interface AlbumRepo extends JpaRepository<Album, Long> {

    //List<Album> getAlbumsByUserId(long id);
}

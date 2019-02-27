package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.Album;

import java.util.List;

public interface AlbumRepo extends JpaRepository<Album, Long> {

    @Query(value = "select user_album.albums_id from user_album where User_id = :tempid", nativeQuery = true)
    List<Long> getAlbumIdsByUserId(@Param("tempid") Long id);
}

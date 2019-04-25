package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.Album;
import pl.coderslab.model.Artist;
import pl.coderslab.model.Band;
import pl.coderslab.model.Label;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findAlbumsByLabel(Label label);
    List<Album> findAlbumsByBand(Band band);

    @Query(value = "select user_album.album_id from user_album where User_id = :tempid", nativeQuery = true)
    List<Long> getAlbumIdsByUserId(@Param("tempid") Long id);

    @Query(value = "select user_album.album_id from user_album", nativeQuery = true)
    List<Long> getAllAlbumIds();
}

/*
package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.Album;

import java.util.List;

public interface UserAlbumRepo extends JpaRepository<Long, Long> {

    @Query(value = "insert into user_album values(:user, :album)", nativeQuery = true)
    void addAlbumToCollection(@Param("user") long user_id, @Param("album") long album_id);
}*/

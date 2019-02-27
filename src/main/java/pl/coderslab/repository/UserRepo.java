package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Album;
import pl.coderslab.model.User;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    User findUserByLogin(String login);

    // TODO: sprawdzić czy można wypchnąć annotacje nad interfejs

    @Modifying
    @Transactional
    @Query(value = "insert into user_album values(:tempuser, :album)", nativeQuery = true)
    void addAlbumToCollection(@Param("tempuser") long user_id, @Param("album") long album_id);

    @Modifying
    @Transactional
    @Query(value = "delete from user_album where user_album.User_id = :tempuser AND user_album.albums_id = :album", nativeQuery = true)
    void deleteAlbumFromCollection(@Param("tempuser") long user_id, @Param("album") long album_id);
}

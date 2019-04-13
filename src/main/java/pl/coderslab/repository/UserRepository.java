package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    // TODO: sprawdzić czy można wypchnąć annotacje nad interfejs

    @Modifying
    @Transactional
    @Query(value = "insert into user_album values(:tempuser, :album)", nativeQuery = true)
    void addAlbumToCollection(@Param("tempuser") long user_id, @Param("album") long album_id);

    @Modifying
    @Transactional
    @Query(value = "delete from user_album where user_album.User_id = :tempuser AND user_album.album_id = :album", nativeQuery = true)
    void deleteAlbumFromCollection(@Param("tempuser") long user_id, @Param("album") long album_id);

    @Query(value = "select album_id from user_album where User_id = :user_id", nativeQuery = true)
    List<Long> getAllUserAlbums(@Param("user_id") Long id);

}

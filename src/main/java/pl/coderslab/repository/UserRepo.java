package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

    User findUserByLogin(String login);

    @Modifying
    @Transactional
    @Query(value = "insert into user_album values(:user, :album)", nativeQuery = true)
    void addAlbumToCollection(@Param("user") long user_id, @Param("album") long album_id);
}

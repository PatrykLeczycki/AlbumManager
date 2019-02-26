package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.LoggedUser;
import pl.coderslab.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

    User findUserByLogin(String login);

}

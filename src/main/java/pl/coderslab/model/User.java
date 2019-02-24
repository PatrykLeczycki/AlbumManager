package pl.coderslab.model;

import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.utils.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Size(min = 5)
    private String login;

    @Column(nullable = false)
    @Size(min = 8)
    private String password;

    @ManyToMany
    @NotEmpty
    private List<Album> albumList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String login, String password) {
        this.login = login;
        this.setPasswordHashed(password);
    }

    public void setPasswordHashed(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }


}
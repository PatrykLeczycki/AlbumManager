package pl.coderslab.model;

import org.hibernate.validator.constraints.Email;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "login"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 20)
    private String login;

    @Column(nullable = false)
    @Size(min = 8)
    private String password;

    @Email(regexp = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}")
    private String email;

    //private boolean admin;

    public User() {
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.setPasswordHashed(password);
        this.email = email;
    }

    public User(String login, String password) {
        this.login = login;
        this.setPassword(password);
    }

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Album> albums;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albumList) {
        this.albums = albumList;
    }

    public void setPasswordHashed(String password){
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
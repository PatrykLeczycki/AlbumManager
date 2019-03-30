package pl.coderslab.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "login"))
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean admin;

    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 20)
    private String login;

    @Column(nullable = false)
    @Size(min = 8)
    private String password;

    @Column(unique = true)
    @Email(regexp = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}")
    private String email;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Album> albums;

    public User(String login, String password, String email) {
        this.login = login;
        this.setPasswordHashed(password);
        this.email = email;
        this.admin = false;
    }

    public User(String login, String password) {
        this.login = login;
        this.setPassword(password);
    }

    public void setPasswordHashed(String password){
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
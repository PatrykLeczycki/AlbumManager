package pl.coderslab.model;

import org.hibernate.validator.constraints.NotEmpty;

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

}

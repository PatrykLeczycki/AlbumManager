package pl.coderslab.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @ManyToMany
    private List<Artist> artists;

    @Column(nullable = false)
    @NotNull
    private String title;

    @ManyToOne
    private Label label;

    @Column(nullable = false)
    @NotNull
    private LocalDate releaseDate;

    @Column(nullable = false)
    @NotNull
    private Format format;
}
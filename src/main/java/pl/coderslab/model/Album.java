package pl.coderslab.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.model.enums.Format;
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
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Artist> artists;

    @Column(nullable = false)
    @NotBlank
    private String title;

    @ManyToOne
    @NotNull
    private Label label;

    @Column(nullable = false)
    @NotNull
    //TODO: dowiedzieć się czy pattern jest potrzebny
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @Column(nullable = false)
    @NotNull
    private Format format;

    @Column(nullable = false)
    @NotNull
    private String genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public String getArtistsToString(){
        StringBuilder artists = new StringBuilder();
        int counter = 0;

        for (Artist x : this.artists){
            if (counter != 0)
                artists.append(", ");
            artists.append(x.getPseudonym());
            counter++;
        }
        return artists.toString();
    }

    public String getFullTitleToString(){

        StringBuilder fullTitle = new StringBuilder();
        String artists = getArtistsToString();
        artists += " - " + this.title;

        return artists;
    }
}
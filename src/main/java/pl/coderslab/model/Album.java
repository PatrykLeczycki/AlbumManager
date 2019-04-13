package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "album_artist", joinColumns = @JoinColumn(name = "album_id"), inverseJoinColumns = @JoinColumn(name = "artist_id"))
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
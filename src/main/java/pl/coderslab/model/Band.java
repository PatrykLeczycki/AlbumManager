package pl.coderslab.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Band {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.MERGE)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "band_artist", joinColumns = @JoinColumn(name = "band_id"), inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private List<Artist> members;

    public String getMembersToString(){
        StringBuilder members = new StringBuilder();
        int counter = 0;

        for (Artist x : this.members){
            if (counter != 0)
                members.append(", ");
            members.append(x.getPseudonym());
            counter++;
        }
        return members.toString();
    }
}

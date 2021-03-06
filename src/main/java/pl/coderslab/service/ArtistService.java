package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Artist;
import pl.coderslab.repository.ArtistRepository;

import java.util.List;
import java.util.Optional;

@Component
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public void addArtist(Artist artist){
        artistRepository.save(artist);
    }

    public List<Artist> getAllArtists(){
        return artistRepository.findAll();
    }

    public Artist getArtistById(long id){

        Optional<Artist> optionalArtist = artistRepository.findById(id);
        return optionalArtist.orElse(null);
    }

    public void deleteArtist(long id){
        artistRepository.deleteById(id);
    }
}

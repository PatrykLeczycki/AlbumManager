package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Artist;
import pl.coderslab.repository.ArtistRepo;

import java.util.List;
import java.util.Optional;

@Component
public class ArtistService {

    @Autowired
    private ArtistRepo artistRepo;

    public void addArtist(Artist artist){
        artistRepo.save(artist);
    }

    public List<Artist> getAllArtists(){
        return artistRepo.findAll();
    }

    public Optional<Artist> getArtistById(long id){
        return artistRepo.findById(id);
    }

    public void deleteArtist(long id){
        artistRepo.deleteById(id);
    }
}

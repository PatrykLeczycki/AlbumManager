package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Album;
import pl.coderslab.model.Artist;
import pl.coderslab.model.Band;
import pl.coderslab.model.Label;
import pl.coderslab.repository.AlbumRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public void addAlbum(Album album){
        albumRepository.save(album);
    }

    public List<Album> getAllAlbums(){
        return albumRepository.findAll();
    }

    public List<Long> getAlbumIdsByUserId(Long id){
        return albumRepository.getAlbumIdsByUserId(id);
    }

    public List<Long> getAllAlbumIds(){
        return albumRepository.getAllAlbumIds();
    }

    public Album getAlbumById(long id){

        Optional<Album> optionalAlbum = albumRepository.findById(id);

        return optionalAlbum.orElse(null);
    }

    public Long countAlbumsByAlbumId(Long id){
        return albumRepository.countAlbumsByAlbumId(id);
    }

    public List<Album> getAlbumsByLabel(Label label){
        return albumRepository.findAlbumsByLabel(label);
    }

    public List<Album> getAlbumsByBand(Band band){
        return albumRepository.findAlbumsByBand(band);
    }

    public List<Album> getAlbumsByArtist(Artist artist){

        List<Album> allAlbums = getAllAlbums();

        List<Album> albumsByArtist = new ArrayList<>();

        for (Album album : allAlbums){
            if (album.getArtists().contains(artist))
                albumsByArtist.add(album);
        }

        return albumsByArtist;
    }

    public void deleteAlbum(long id){
        albumRepository.deleteById(id);
    }


}

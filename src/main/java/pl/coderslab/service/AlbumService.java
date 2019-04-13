package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Album;
import pl.coderslab.repository.AlbumRepo;

import java.util.List;
import java.util.Optional;

@Component
public class AlbumService {

    @Autowired
    private AlbumRepo albumRepo;

    public void addAlbum(Album album){
        albumRepo.save(album);
    }

    public List<Album> getAllAlbums(){
        return albumRepo.findAll();
    }

    public List<Long> getAlbumIdsByUserId(Long id){
        return albumRepo.getAlbumIdsByUserId(id);
    }

    public List<Long> getAllAlbumIds(){
        return albumRepo.getAllAlbumIds();
    }

    public Optional<Album> getAlbumById(long id){
        return albumRepo.findById(id);
    }

    public void deleteAlbum(long id){
        albumRepo.deleteById(id);
    }


}

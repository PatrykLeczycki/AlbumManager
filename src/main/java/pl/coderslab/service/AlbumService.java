package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Album;
import pl.coderslab.model.User;
import pl.coderslab.repository.AlbumRepo;

import java.util.List;

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

    public Album getAlbumById(long id){
        return albumRepo.findOne(id);
    }

    public void deleteAlbum(long id){
        albumRepo.delete(id);
    }


}

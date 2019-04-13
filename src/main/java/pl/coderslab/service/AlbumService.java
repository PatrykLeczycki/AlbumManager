package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Album;
import pl.coderslab.repository.AlbumRepository;

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

    public Optional<Album> getAlbumById(long id){
        return albumRepository.findById(id);
    }

    public void deleteAlbum(long id){
        albumRepository.deleteById(id);
    }


}

package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepo;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void addUser(User user){
        userRepo.save(user);
    }

    public User findUserByLogin(String login){
        return userRepo.findUserByLogin(login);
    }

    public void addAlbumToCollection(long user_id, long album_id){
        userRepo.addAlbumToCollection(user_id, album_id);
    }

    public void deleteAlbumFromCollection(long user_id, long album_id){
        userRepo.deleteAlbumFromCollection(user_id, album_id);
    }

    public User findUserByEmail(String email){
        return userRepo.findUserByEmail(email);
    }

    public List<Long> getAllUserAlbums(Long id){
        return userRepo.getAllUserAlbums(id);
    }
}

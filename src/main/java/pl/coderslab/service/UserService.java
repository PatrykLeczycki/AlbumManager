package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.UserDto;
import pl.coderslab.model.User;
import pl.coderslab.repository.RoleRepository;
import pl.coderslab.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    private final BCryptPasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    public void addUser(User user){
        userRepo.save(user);
    }

    public Optional<User> findUserById(Long id){
        return userRepo.findById(id);
    }

    public User findUserByUsername(String username){
        return userRepo.findUserByUsername(username);
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


    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public void registerUser(UserDto userDto) {

        final User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setEnabled(userDto.getEnabled());
        user.getRoleSet().add(roleRepository.findByName("ROLE_USER"));

        userRepo.save(user);
    }
}

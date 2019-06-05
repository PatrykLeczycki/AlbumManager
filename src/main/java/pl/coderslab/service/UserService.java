package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.dom4j.DocumentException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.UserDto;
import pl.coderslab.model.User;
import pl.coderslab.repository.RoleRepository;
import pl.coderslab.repository.UserRepo;
import pl.coderslab.utils.Mailer;
import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    private final BCryptPasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    private final Mailer mailer;

    ////////////////////////////////////

    public void addUser(User user){
        userRepo.save(user);
    }

    public User findUserById(Long id){

        Optional<User> optionalUser = userRepo.findById(id);

        return optionalUser.orElse(null);
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

    @Transactional
    public void registerUser(UserDto userDto) throws MessagingException, IOException, DocumentException {

        final User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setEnabled(false);
        user.getRoleSet().add(roleRepository.findByName("ROLE_USER"));
        user.setRegistrationToken(generateToken());
        userRepo.save(user);
        sendRegistrationEmail(user.getEmail());
    }

    public String generateToken(){
        Random generator = new Random();

        StringBuilder token = new StringBuilder();

        for (int i = 0; i < 20; i++){
            if (generator.nextInt(2) == 1)
                token.append((char)(generator.nextInt(26) + 97));

            else token.append(generator.nextInt(10));
        }

        return token.toString();
    }

    @Transactional
    public void addPassRecoveryToken(String email) {

        User user = userRepo.findUserByEmail(email);
        user.setPassRecoveryToken(generateToken());
        userRepo.save(user);
    }

    public void sendRegistrationEmail(String receiverEmail) throws MessagingException, IOException, DocumentException {

        User user = userRepo.findUserByEmail(receiverEmail);

        String link = "pleczycki.pl/albummanager/register/" + user.getId() + "/" + user.getRegistrationToken();

        //String link = "http://localhost:8080/register/" + user.getId() + "/" + user.getRegistrationToken();


        String message= "<html lang=\"en\">" +
                "<head>" +
                "<title>Confirm registration</title>" +
                "</head>" +
                "<body>" +
                "<<div style=\"background-color: #f9c910; text-align: center\"><h1><a href=\"pleczycki.pl/albummanager/\">Album Manager</a></h1></div>" +
                "<p style=\"text-align: center\">Thank you for registering on our site. Please click link below to confirm registration process:</p>" +
                "<p style=\"text-align: center\"><a style=\"color: #2c7021; text-decoration: none; font-size: 30px\" href=\"" + link + "\" target=\"_blank\">Confirm registration</a></p>" +
                "<p style=\"margin-top: 50px; text-align: center\">If you didn't register on our site, ignore this e-mail and make sure your data is safe.</p>" +
                "</body></html>";

        mailer.send(receiverEmail, "Registration on Album Manager", message);
    }

    public void sendPassRecoveryEmail(String receiverEmail) {

        User user = userRepo.findUserByEmail(receiverEmail);

        String link = "pleczycki.pl/albummanager/lostpassword/" + user.getId() + "/" + user.getPassRecoveryToken();

        //String link = "http://localhost:8080/lostpassword/" + user.getId() + "/" + user.getPassRecoveryToken();



        String message= "<html lang=\"en\">" +
                "<head>" +
                "<title>Password recovery</title>" +
                "</head>" +
                "<body>" +
                "<<div style=\"background-color: #f9c910; text-align: center\"><h1><a href=\"pleczycki.pl/albummanager/\">Album Manager</a></h1></div>" +
                "<p style=\"text-align: center\">You have received this e-mail because your e-mail address was given during password retrieval process. To retrieve your password click here:</p>" +
                "<p style=\"text-align: center\"><a style=\"color: #2c7021; text-decoration: none; font-size: 30px\" href=\"" + link + "\" target=\"_blank\">Retrieve password</a></p>" +
                "<p style=\"margin-top: 50px; text-align: center\">If you didn't lost your password, ignore this e-mail and make sure your data is safe.</p>" + "</body></html>";

        mailer.send(receiverEmail, "Album Manager - password recovery", message);
    }
}

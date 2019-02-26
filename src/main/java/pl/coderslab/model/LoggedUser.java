package pl.coderslab.model;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoggedUser {

    private String login;
    private String password;
    private List<Album> albumList;

    public LoggedUser() {
    }

    public LoggedUser(String login, String password) {
        this.login = login;
        setPassword(password);
        System.out.println("konstruktor");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    public void setPasswordHashed(String password){
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }
}

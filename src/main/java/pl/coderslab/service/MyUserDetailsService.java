package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.model.MyUserDetails;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepo;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

  private final UserRepo userRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findUserByUsername(username);
    if (Objects.isNull(user) ) {
      throw new UsernameNotFoundException(username);
    }
    return new MyUserDetails(user);
  }
}

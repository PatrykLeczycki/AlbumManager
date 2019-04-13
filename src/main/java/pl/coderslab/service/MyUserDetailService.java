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
public class MyUserDetailService implements UserDetailsService {

  private final UserRepo userRepo;

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    User user = userRepo.findUserByUsername(login);
    if (Objects.isNull(user) ) {
      throw new UsernameNotFoundException(login);
    }
    return new MyUserDetails(user);
  }
}

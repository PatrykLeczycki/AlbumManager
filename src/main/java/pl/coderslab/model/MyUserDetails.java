package pl.coderslab.model;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails extends User implements UserDetails {

  //Zamieniam usera na obiekt UserDetails
  public MyUserDetails(User user) {
    this.setEnabled(user.getEnabled());
    this.setPassword(user.getPassword());
    this.setRoleSet(user.getRoleSet());
    this.setUsername(user.getUsername());
    this.setEmail(user.getEmail());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.getRoleSet().stream()
        .map(el -> new SimpleGrantedAuthority(el.getName()))
        .collect(Collectors.toList());
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public String toString() {
   return super.toString();
  }
}

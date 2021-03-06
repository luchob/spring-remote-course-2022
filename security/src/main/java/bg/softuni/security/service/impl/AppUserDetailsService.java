package bg.softuni.security.service.impl;

import bg.softuni.security.model.entity.UserEntity;
import bg.softuni.security.model.entity.UserRoleEntity;
import bg.softuni.security.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public AppUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    return userRepository.
        findByEmail(email).
        map(this::map).
        orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found."));
  }

  private UserDetails map(UserEntity userEntity) {

    return new User(
        userEntity.getEmail(),
        userEntity.getPassword(),
        asGrantedAuthorities(userEntity.getRoles())
    );
  }

  private List<GrantedAuthority> asGrantedAuthorities(List<UserRoleEntity> roleEntities) {
    return roleEntities.
        stream().
        map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name())).
        collect(Collectors.toList());
  }
}

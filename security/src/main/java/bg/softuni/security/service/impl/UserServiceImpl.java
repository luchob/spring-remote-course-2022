package bg.softuni.security.service.impl;

import static bg.softuni.security.model.enums.UserRoleEnum.ADMIN;
import static bg.softuni.security.model.enums.UserRoleEnum.MODERATOR;

import bg.softuni.security.model.entity.UserEntity;
import bg.softuni.security.model.entity.UserRoleEntity;
import bg.softuni.security.repository.UserRepository;
import bg.softuni.security.repository.UserRoleRepository;
import bg.softuni.security.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRoleRepository userRoleRepository;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final String defaultAdminPassword;

  public UserServiceImpl(UserRoleRepository userRoleRepository,
      UserRepository userRepository,
      PasswordEncoder passwordEncoder,
      @Value("app.default.admin-password") String defaultAdminPassword) {
    this.userRoleRepository = userRoleRepository;
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.defaultAdminPassword = defaultAdminPassword;
  }

  @Override
  public void initUserRoles() {
    if (userRoleRepository.count() == 0) {
      UserRoleEntity adminRole = new UserRoleEntity().setRole(ADMIN);
      UserRoleEntity moderatorRole = new UserRoleEntity().setRole(MODERATOR);

      userRoleRepository.saveAll(List.of(adminRole, moderatorRole));
    }


  }

  @Override
  public void initAdminUser() {
    if (userRepository.count() == 0) {
      UserEntity adminUser = new UserEntity().
          setFirstName("Admin").
          setLastName("Admin").
          setEmail("admin@example.com").
          setPassword(passwordEncoder.encode(defaultAdminPassword)).
          setRoles(userRoleRepository.findAll());

      userRepository.save(adminUser);
    }
  }
}

package bg.softuni.security.service.impl;

import static bg.softuni.security.model.enums.UserRoleEnum.ADMIN;
import static bg.softuni.security.model.enums.UserRoleEnum.MODERATOR;

import bg.softuni.security.model.entity.UserRoleEntity;
import bg.softuni.security.repository.UserRoleRepository;
import bg.softuni.security.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRoleRepository userRoleRepository;

  public UserServiceImpl(UserRoleRepository userRoleRepository) {
    this.userRoleRepository = userRoleRepository;
  }

  @Override
  public void initUserRoles() {
    if (userRoleRepository.count() == 0) {
      UserRoleEntity adminRole = new UserRoleEntity().setRole(ADMIN);
      UserRoleEntity moderatorRole = new UserRoleEntity().setRole(MODERATOR);

      userRoleRepository.saveAll(List.of(adminRole, moderatorRole));
    }
  }
}

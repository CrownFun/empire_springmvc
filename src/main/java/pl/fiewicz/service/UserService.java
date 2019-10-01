package pl.fiewicz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.fiewicz.model.Army;
import pl.fiewicz.model.Resources;
import pl.fiewicz.model.User;
import pl.fiewicz.model.UserRole;
import pl.fiewicz.repository.UserRepository;
import pl.fiewicz.repository.UserRoleRepository;

import javax.transaction.Transactional;

@Service
public class UserService {

    private static final String DEFAULT_ROLE = "ROLE_USER";
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void userRegistrationWithDefaultRole(User user) {
        UserRole defaultRole = userRoleRepository.findByRole(DEFAULT_ROLE);
        user.getUserRoles().add(defaultRole);
        setStartBonus(user);
        String hashPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPass);
        userRepository.save(user);
    }

    private void setStartBonus(User user) {
        Army army = new Army(100,100,20);
        user.setArmy(army);
        Resources resources = new Resources(500,1000,1000);
        user.setResources(resources);
        user.setPremiumDays(7);
    }


}

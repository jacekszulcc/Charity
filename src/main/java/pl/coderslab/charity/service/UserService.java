package pl.coderslab.charity.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.UserCredentialsDto;
import pl.coderslab.charity.dto.UserCredentialsDtoMapper;
import pl.coderslab.charity.dto.UserRegistrationDto;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.entity.UserRole;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.repository.UserRoleRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private static final String DEFAULT_USER_ROLE = "USER";
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       UserRoleRepository userRoleRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void registerUserWithDefaultRole(UserRegistrationDto userRegistration) {
        UserRole defaultRole = userRoleRepository.findByName(DEFAULT_USER_ROLE).orElseThrow();
        User user = new User();
        user.setEmail(userRegistration.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
        user.getRoles().add(defaultRole);
        userRepository.save(user);
    }

    public Optional<UserCredentialsDto> findCredentialsByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserCredentialsDtoMapper::map);
    }

    public void changeRoleToAdmin(User user){
        UserRole adminRole = userRoleRepository.findByName("ADMIN").orElseThrow();
        UserRole userRole = userRoleRepository.findByName("USER").orElseThrow();
        user.getRoles().remove(userRole);
        user.getRoles().add(adminRole);
        userRepository.save(user);
    }

    public void changeRoleToUser(User user){
        UserRole adminRole = userRoleRepository.findByName("ADMIN").orElseThrow();
        UserRole userRole = userRoleRepository.findByName("USER").orElseThrow();
        user.getRoles().remove(adminRole);
        user.getRoles().add(userRole);
        userRepository.save(user);
    }

    public Optional<User> findUserById(Long id){ return userRepository.findById(id); }

    public List<User> findUsersByRole(UserRole role){ return userRepository.findUsersByRoles(role);}

    public Optional<UserRole> findByName(String name){ return userRoleRepository.findByName(name);}

    public void deleteUserById(Long id){ userRepository.deleteById(id); }

    public void saveUser(User user){ userRepository.save(user); }

}

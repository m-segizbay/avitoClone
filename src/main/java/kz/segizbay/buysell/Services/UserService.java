package kz.segizbay.buysell.Services;

import kz.segizbay.buysell.models.User;
import kz.segizbay.buysell.models.enums.Role;
import kz.segizbay.buysell.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public boolean createUser(User user) {
        String email = user.getEmail();
        if (userRepository.findByEmail(email).isPresent()) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        userRepository.save(user);
        log.info("User created: {}", email);
        return true;
    }
}

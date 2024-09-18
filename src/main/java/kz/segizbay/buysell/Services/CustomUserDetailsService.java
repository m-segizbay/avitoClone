package kz.segizbay.buysell.Services;

import kz.segizbay.buysell.models.User;
import kz.segizbay.buysell.repositories.UserRepository;
import kz.segizbay.buysell.security.MyUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) throw  new UsernameNotFoundException("User not found");

        return new MyUserDetails(user.get());
    }
}

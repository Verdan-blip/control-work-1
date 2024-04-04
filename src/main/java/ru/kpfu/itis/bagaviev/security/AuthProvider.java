package ru.kpfu.itis.bagaviev.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.bagaviev.model.User;
import ru.kpfu.itis.bagaviev.repositories.UserRepository;
import ru.kpfu.itis.bagaviev.util.PasswordEncryptUtil;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthProvider implements AuthenticationProvider {

    private final UserRepository userRepository;

    public AuthProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userRepository.findOneByEmailAndPassword(username, PasswordEncryptUtil.encrypt(password));

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(r -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + r.getName()));
        });

        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}

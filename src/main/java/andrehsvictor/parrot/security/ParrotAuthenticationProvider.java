package andrehsvictor.parrot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import andrehsvictor.parrot.entity.User;
import andrehsvictor.parrot.exception.ParrotException;
import andrehsvictor.parrot.service.UserService;

@Component
public class ParrotAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String usernameOrEmail = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userService.findByUsernameOrEmail(usernameOrEmail);
        validateCredentials(password, user);
        UserDetails userDetails = new UserDetailsImpl(user);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
    
    private void validateCredentials(String password, User user) {
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new ParrotException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }
        if (!user.getVerified()) {
            throw new DisabledException("User is not verified");
        }
    }
}

package andrehsvictor.parrot.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import andrehsvictor.parrot.entity.User;
import andrehsvictor.parrot.exception.ParrotException;
import andrehsvictor.parrot.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findByUsernameOrEmail(String usernameOrEmail) {
        return userRepository.findByUsernameOrEmail(usernameOrEmail)
                .orElseThrow(() -> new ParrotException(HttpStatus.NOT_FOUND, "User not found"));
    }
}

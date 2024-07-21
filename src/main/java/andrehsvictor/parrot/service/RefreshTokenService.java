package andrehsvictor.parrot.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import andrehsvictor.parrot.entity.RefreshToken;
import andrehsvictor.parrot.exception.ParrotException;
import andrehsvictor.parrot.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByToken(String token) {
        return refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new ParrotException(HttpStatus.NOT_FOUND, "Refresh token not found"));
    }
}

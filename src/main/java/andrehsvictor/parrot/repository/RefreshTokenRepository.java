package andrehsvictor.parrot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import andrehsvictor.parrot.entity.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
}

package andrehsvictor.parrot.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ParrotException extends RuntimeException {

    private final HttpStatus status;

    public ParrotException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}

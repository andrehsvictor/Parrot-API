CREATE TABLE verification_codes (
    id         SERIAL       PRIMARY KEY,
    code       VARCHAR(255) NOT NULL,
    user_id    INT          NOT NULL,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    expires_at TIMESTAMP    NOT NULL
);
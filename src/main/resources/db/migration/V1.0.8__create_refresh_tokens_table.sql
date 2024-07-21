CREATE TABLE refresh_tokens (
    id         SERIAL       PRIMARY KEY,
    token      VARCHAR(255) NOT NULL,
    user_id    INT          NOT NULL,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    expires_at TIMESTAMP    NOT NULL
);
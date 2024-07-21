CREATE TABLE users (
    id         SERIAL       PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    username   VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    avatar_url VARCHAR(255),
    bio        TEXT,
    verified   BOOLEAN      NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,

    UNIQUE (username),
    UNIQUE (email)
);

CREATE TABLE posts (
    id         SERIAL       PRIMARY KEY,
    user_id    INTEGER      NOT NULL,
    title      VARCHAR(255) NOT NULL,
    content    TEXT         NOT NULL,
    image_url  VARCHAR(255),
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE comments (
    id         SERIAL       PRIMARY KEY,
    post_id    INTEGER      NOT NULL,
    user_id    INTEGER      NOT NULL,
    content    TEXT         NOT NULL,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,

    FOREIGN KEY (post_id) REFERENCES posts (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE likes (
    id         SERIAL       PRIMARY KEY,
    post_id    INTEGER      NOT NULL,
    user_id    INTEGER      NOT NULL,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (post_id) REFERENCES posts (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE follows (
    id         SERIAL       PRIMARY KEY,
    follower_id INTEGER      NOT NULL,
    followee_id INTEGER      NOT NULL,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (follower_id) REFERENCES users (id),
    FOREIGN KEY (followee_id) REFERENCES users (id)
);
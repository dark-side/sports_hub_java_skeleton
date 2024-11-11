CREATE TABLE app_user (
    id                      UUID,
    username                VARCHAR(50)     NOT NULL,
    email                   VARCHAR(100)    NOT NULL,
    password                VARCHAR(255)    NOT NULL,
    creation_timestamp      TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_timestamp   TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT app_users_unique_username UNIQUE (username),
    CONSTRAINT app_users_unique_email UNIQUE (email)
);
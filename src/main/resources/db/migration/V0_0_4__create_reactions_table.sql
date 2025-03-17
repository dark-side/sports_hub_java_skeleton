CREATE TABLE reactions (
    id                      SERIAL,
    content_type            VARCHAR(20)     NOT NULL, -- 'article' or 'comment'
    content_id              UUID            NOT NULL, -- ID of the article or comment
    user_id                 UUID            NOT NULL, -- ID of the user who reacted
    reaction_type           VARCHAR(10)     NOT NULL, -- 'like', 'dislike', etc.
    creation_timestamp      TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_timestamp   TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE (content_type, content_id, user_id), -- Prevent duplicate reactions
    FOREIGN KEY (user_id) REFERENCES app_user(id)
);
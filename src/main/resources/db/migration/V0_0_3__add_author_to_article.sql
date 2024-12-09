-- Insert the admin user
INSERT INTO app_user (id, username, password, email) VALUES (gen_random_uuid(), 'admin', '2769be6e-235c-434d-b92b-0569eebf78e9', 'admin@localhost');

-- Add the column without a default value
ALTER TABLE article ADD COLUMN author_id UUID;

-- Update existing rows to set the default value
UPDATE article SET author_id = (SELECT id FROM app_user WHERE username = 'admin');

-- Add the NOT NULL constraint
ALTER TABLE article ALTER COLUMN author_id SET NOT NULL;

-- Add the foreign key constraint
ALTER TABLE article ADD CONSTRAINT fk_article_author FOREIGN KEY (author_id) REFERENCES app_user(id);
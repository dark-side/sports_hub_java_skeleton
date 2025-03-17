CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE image_storage (
    id                      UUID            DEFAULT gen_random_uuid(),
    image                   TEXT            NOT NULL,
    creation_timestamp      TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_timestamp   TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE article
(
    id                      UUID            DEFAULT gen_random_uuid(),
    title                   VARCHAR(255)    NOT NULL,
    short_description       VARCHAR(255)    NOT NULL,
    description             TEXT            NOT NULL,
    image_id                UUID            NOT NULL,
    creation_timestamp      TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_timestamp   TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (image_id) REFERENCES image_storage(id),
    CONSTRAINT unique_title UNIQUE (title)
);

CREATE TABLE comment
(
    id                      UUID            DEFAULT gen_random_uuid(),
    article_id              UUID            NOT NULL,
    content                 TEXT            NOT NULL,
    creation_timestamp      TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_timestamp   TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (article_id) REFERENCES article(id)
);



INSERT INTO image_storage(id, image) VALUES
    ('4f815eb4-4c29-46a2-ba4f-4f9d989bc08a', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('65a8e821-715f-485b-bad4-029bb5448e66', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('ac2654e3-7153-448f-bc0a-2d6811ef96de', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('99d9f4b7-33ad-40c2-b6d3-f2bbf6ee0f34', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('0407ace9-7218-4fda-88e5-4ccfed862db6', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('e66c1dd4-7376-455b-83a7-a3062679c6c1', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('c4ec4508-07d0-4b9b-93bf-21d7756768b1', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('93817942-27e7-4a6c-a881-482be11bd909', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('b426f79f-4361-4a08-b08f-2e924c165843', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('9b791740-3506-4270-a849-d2846e1dfe91', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('d9c9ca31-1812-4fa8-8aae-77d6b0522f5e', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('ff218569-bf6b-4ac8-b6ea-7e887d9e42ef', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('e1c4034f-702c-454c-99db-377d23e5fa87', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('65fd0cac-81af-490c-8d8e-58e276fcec52', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('bb13263b-f8d2-46f7-b164-f1c6af132093', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('eb5b3dec-6783-472f-9141-d7f3ca43be6f', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('3721dbc8-b163-4ad4-bc83-ad3b8bea83fd', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('9ac59933-c37f-4f47-a164-6befff171906', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('418713f3-ad30-4e21-a9d9-166ba2acb515', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII'),
    ('dc5b51bf-6381-4ae7-b83b-86bfeafa55a7', 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII');

INSERT INTO article (title, short_description, description, image_id) VALUES
    ('The Rise of Soccer', 'A look at soccer''s global popularity', 'Soccer has become the most popular sport in the world, with millions of fans. It is played in almost every country and has a rich history.', '4f815eb4-4c29-46a2-ba4f-4f9d989bc08a'),
    ('Basketball Legends', 'Profiles of the greatest basketball players', 'From Michael Jordan to LeBron James, basketball has seen some of the greatest athletes. Their impact on the sport is immeasurable.', '65a8e821-715f-485b-bad4-029bb5448e66'),
    ('Olympic Games History', 'The evolution of the Olympic Games', 'The Olympic Games have a rich history dating back to ancient Greece. They have evolved significantly over the centuries.', 'ac2654e3-7153-448f-bc0a-2d6811ef96de'),
    ('The World of Tennis', 'An overview of professional tennis', 'Tennis is a sport that requires agility, strength, and strategy. It is played on various surfaces and has a global following.', '99d9f4b7-33ad-40c2-b6d3-f2bbf6ee0f34'),
    ('Marathon Running', 'The challenge of marathon running', 'Running a marathon is a test of endurance and mental strength. It requires months of training and preparation.', '0407ace9-7218-4fda-88e5-4ccfed862db6'),
    ('The NFL Experience', 'Inside the National Football League', 'The NFL is one of the most popular sports leagues in the United States. It features intense competition and passionate fans.', 'e66c1dd4-7376-455b-83a7-a3062679c6c1'),
    ('Cricket: A Global Sport', 'Cricket''s impact around the world', 'Cricket is a sport that has a massive following in countries like India and Australia. It is known for its long matches and strategic play.', 'c4ec4508-07d0-4b9b-93bf-21d7756768b1'),
    ('The Art of Gymnastics', 'The beauty and skill of gymnastics', 'Gymnastics is a sport that combines strength, flexibility, and grace. It is performed on various apparatus and requires years of training.', '93817942-27e7-4a6c-a881-482be11bd909'),
    ('Formula 1 Racing', 'The thrill of Formula 1', 'Formula 1 racing is a high-speed sport that requires precision and skill. It features some of the fastest cars and most talented drivers.', 'b426f79f-4361-4a08-b08f-2e924c165843'),
    ('The World of Rugby', 'Rugby''s global influence', 'Rugby is a sport that is known for its physicality and teamwork. It is played in many countries and has a passionate fan base.', '9b791740-3506-4270-a849-d2846e1dfe91'),
    ('Golf: A Gentleman''s Game', 'The traditions of golf', 'Golf is a sport that is steeped in tradition and requires skill and patience. It is played on beautifully manicured courses around the world.', 'd9c9ca31-1812-4fa8-8aae-77d6b0522f5e'),
    ('The Evolution of Baseball', 'Baseball''s history and impact', 'Baseball is a sport that has a rich history in the United States. It is known as America''s pastime and has a significant cultural impact.', 'ff218569-bf6b-4ac8-b6ea-7e887d9e42ef'),
    ('The World of Boxing', 'The intensity of boxing', 'Boxing is a sport that requires strength, strategy, and endurance. It has produced some of the most famous athletes in history.', 'e1c4034f-702c-454c-99db-377d23e5fa87'),
    ('The Spirit of Volleyball', 'Volleyball''s popularity and rules', 'Volleyball is a sport that is enjoyed by millions around the world. It is played both indoors and on the beach.', '65fd0cac-81af-490c-8d8e-58e276fcec52'),
    ('The World of Swimming', 'Competitive swimming insights', 'Swimming is a sport that requires speed, technique, and endurance. It is a popular event in the Olympic Games.', 'bb13263b-f8d2-46f7-b164-f1c6af132093'),
    ('The World of Hockey', 'Ice hockey''s global reach', 'Hockey is a sport that is known for its speed and physicality. It is played on ice and has a strong following in countries like Canada.', 'eb5b3dec-6783-472f-9141-d7f3ca43be6f'),
    ('The World of Surfing', 'The culture of surfing', 'Surfing is a sport that is enjoyed by many for its connection to the ocean. It requires balance, skill, and a love for the waves.', '3721dbc8-b163-4ad4-bc83-ad3b8bea83fd'),
    ('The World of Skiing', 'Skiing''s appeal and techniques', 'Skiing is a sport that is enjoyed by many for its thrill and challenge. It is performed on snow-covered slopes and requires skill and practice.', '9ac59933-c37f-4f47-a164-6befff171906'),
    ('The World of Snowboarding', 'Snowboarding''s rise in popularity', 'Snowboarding is a sport that has gained popularity for its excitement and style. It is performed on snow-covered slopes and requires balance and skill.', '418713f3-ad30-4e21-a9d9-166ba2acb515'),
    ('The World of Cycling', 'Competitive cycling insights', 'Cycling is a sport that requires endurance, strategy, and teamwork. It is performed on various terrains and has a global following.', 'dc5b51bf-6381-4ae7-b83b-86bfeafa55a7');

INSERT INTO comment (article_id, content) VALUES
    ((SELECT id FROM article WHERE title = 'The Rise of Soccer'), 'Soccer is truly a global phenomenon.'),
    ((SELECT id FROM article WHERE title = 'The Rise of Soccer'), 'I love watching soccer matches on weekends.'),
    ((SELECT id FROM article WHERE title = 'Basketball Legends'), 'Michael Jordan is the greatest of all time.'),
    ((SELECT id FROM article WHERE title = 'Basketball Legends'), 'LeBron James has had an incredible career.'),
    ((SELECT id FROM article WHERE title = 'Olympic Games History'), 'The history of the Olympics is fascinating.'),
    ((SELECT id FROM article WHERE title = 'Olympic Games History'), 'I enjoy watching the opening ceremonies.'),
    ((SELECT id FROM article WHERE title = 'The World of Tennis'), 'Tennis matches are so intense and exciting.'),
    ((SELECT id FROM article WHERE title = 'The World of Tennis'), 'Roger Federer is my favorite tennis player.'),
    ((SELECT id FROM article WHERE title = 'Marathon Running'), 'Running a marathon is a huge accomplishment.'),
    ((SELECT id FROM article WHERE title = 'Marathon Running'), 'I am training for my first marathon.'),
    ((SELECT id FROM article WHERE title = 'The NFL Experience'), 'The NFL playoffs are always thrilling.'),
    ((SELECT id FROM article WHERE title = 'The NFL Experience'), 'I am a big fan of the New England Patriots.'),
    ((SELECT id FROM article WHERE title = 'Cricket: A Global Sport'), 'Cricket matches can last for days.'),
    ((SELECT id FROM article WHERE title = 'Cricket: A Global Sport'), 'I love watching cricket with my family.'),
    ((SELECT id FROM article WHERE title = 'The Art of Gymnastics'), 'Gymnastics requires incredible skill and strength.'),
    ((SELECT id FROM article WHERE title = 'The Art of Gymnastics'), 'The balance beam is my favorite event.'),
    ((SELECT id FROM article WHERE title = 'Formula 1 Racing'), 'Formula 1 races are so fast and exciting.'),
    ((SELECT id FROM article WHERE title = 'Formula 1 Racing'), 'Lewis Hamilton is an amazing driver.'),
    ((SELECT id FROM article WHERE title = 'The World of Rugby'), 'Rugby is such a physical and demanding sport.'),
    ((SELECT id FROM article WHERE title = 'The World of Rugby'), 'I enjoy watching the Rugby World Cup.'),
    ((SELECT id FROM article WHERE title = 'Golf: A Gentleman''s Game'), 'Golf courses are always so beautiful.'),
    ((SELECT id FROM article WHERE title = 'Golf: A Gentleman''s Game'), 'Tiger Woods is a legendary golfer.'),
    ((SELECT id FROM article WHERE title = 'The Evolution of Baseball'), 'Baseball has a rich and storied history.'),
    ((SELECT id FROM article WHERE title = 'The Evolution of Baseball'), 'I love going to baseball games in the summer.'),
    ((SELECT id FROM article WHERE title = 'The World of Boxing'), 'Boxing matches are so intense and thrilling.'),
    ((SELECT id FROM article WHERE title = 'The World of Boxing'), 'Muhammad Ali is the greatest boxer of all time.'),
    ((SELECT id FROM article WHERE title = 'The Spirit of Volleyball'), 'Volleyball is a fun and fast-paced sport.'),
    ((SELECT id FROM article WHERE title = 'The Spirit of Volleyball'), 'I enjoy playing beach volleyball with friends.'),
    ((SELECT id FROM article WHERE title = 'The World of Swimming'), 'Swimming is a great way to stay in shape.'),
    ((SELECT id FROM article WHERE title = 'The World of Swimming'), 'Michael Phelps is an incredible swimmer.'),
    ((SELECT id FROM article WHERE title = 'The World of Hockey'), 'Hockey games are so fast and exciting.'),
    ((SELECT id FROM article WHERE title = 'The World of Hockey'), 'I am a big fan of the Toronto Maple Leafs.'),
    ((SELECT id FROM article WHERE title = 'The World of Surfing'), 'Surfing is such a cool and laid-back sport.'),
    ((SELECT id FROM article WHERE title = 'The World of Surfing'), 'I would love to learn how to surf.'),
    ((SELECT id FROM article WHERE title = 'The World of Skiing'), 'Skiing down a mountain is so exhilarating.'),
    ((SELECT id FROM article WHERE title = 'The World of Skiing'), 'I enjoy skiing with my family every winter.'),
    ((SELECT id FROM article WHERE title = 'The World of Snowboarding'), 'Snowboarding is such a fun and exciting sport.'),
    ((SELECT id FROM article WHERE title = 'The World of Snowboarding'), 'I love watching snowboarding competitions.'),
    ((SELECT id FROM article WHERE title = 'The World of Cycling'), 'Cycling is a great way to explore the outdoors.'),
    ((SELECT id FROM article WHERE title = 'The World of Cycling'), 'I enjoy going on long bike rides on weekends.'),
    ((SELECT id FROM article WHERE title = 'The Rise of Soccer'), 'The World Cup is the biggest event in soccer.'),
    ((SELECT id FROM article WHERE title = 'Basketball Legends'), 'Kobe Bryant was an incredible player.'),
    ((SELECT id FROM article WHERE title = 'Olympic Games History'), 'The Olympic Games bring the world together.'),
    ((SELECT id FROM article WHERE title = 'The World of Tennis'), 'The Wimbledon tournament is my favorite.'),
    ((SELECT id FROM article WHERE title = 'Marathon Running'), 'Running a marathon is a true test of endurance.'),
    ((SELECT id FROM article WHERE title = 'The NFL Experience'), 'The Super Bowl is the biggest event in the NFL.'),
    ((SELECT id FROM article WHERE title = 'Cricket: A Global Sport'), 'Cricket is a sport that requires strategy and skill.'),
    ((SELECT id FROM article WHERE title = 'The Art of Gymnastics'), 'Gymnastics routines are so beautiful to watch.'),
    ((SELECT id FROM article WHERE title = 'Formula 1 Racing'), 'Formula 1 cars are incredibly fast and powerful.'),
    ((SELECT id FROM article WHERE title = 'The World of Rugby'), 'Rugby matches are always so intense and exciting.');
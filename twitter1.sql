create table "user" (
                        id bigserial primary key,
                        first_name varchar(50),
                        last_name varchar(50),
                        username varchar(50) NOT NULL,
                        password varchar(20) NOT NULL,
                        birth_date date,
                        gender boolean,
                        user_pic varchar(256)
);

create table tweet(
                      id bigserial primary key,
                      user_id bigint references "user"
                          (id),
                      text varchar(240),
                      photo varchar(256),
                      pub_date date,
                      replies_to bigint references tweet(id),
                      retweets bigint references tweet(id)
);

create table Mention(
                        id serial primary key,
                        tweet_id bigint references tweet(id),
                        user_id bigint references tweet(id)
);

create table hashtag(
                        id serial primary key,
                        text varchar(239)
);

create table tweet_hashtag(
                              id serial primary key,
                              tweet_id bigint references tweet(id),
                              hashtag_id bigint references hashtag(id)
);

create table user_like(
                          id serial primary key,
                          user_id bigint references "user"(id),
                          tweet_id bigint references tweet(id)
);

create table subscribers(
                            id_subscriber bigserial references "user"(id),
                            user_subscribers bigint references "user"(id) /* чьи подписчики*/

);

create table subscriptions(
                              id_subscription bigint references "user"(id),
                              user_subscriptions bigint references "user"(id)
);

INSERT INTO "user" (first_name, last_name, username, password, birth_date, gender, user_pic)
VALUES ('Александр', 'Кузнецов', 'wumBach', '362536jhk51j3gjhg34', '1999-01-01', TRUE, '');

INSERT INTO tweet (user_id, text, photo, pub_date, replies_to, retweets) VALUES
(1, 'Hello! This is my first tweet!', '', '2021-09-21', Null, NULL),
(1, 'Hello! This is my second tweet!', '', '2021-09-21', Null, NULL),
(1, 'Hello! This is my third tweet!', '', '2021-09-21', Null, NULL),
(1, 'Hello! This is my fourth tweet!', '', '2021-09-21', Null, NULL),
(1, 'Hello! This is my fifth tweet!', '', '2021-09-21', Null, NULL);

insert into "user" (first_name, last_name, username, password, birth_date, gender, user_pic)
VALUES ('Карина', 'Обшарова', 'malikarii','qwerty007','2002-08-31', FALSE ,'');

insert into subscriptions (id_subscription, user_subscriptions)
VALUES (2, 1);

insert into subscribers (id_subscriber, user_subscribers)
VALUES (2, 1);

INSERT INTO tweet (user_id, text, photo, pub_date, replies_to, retweets) VALUES
(2, 'Hello! This is my first tweet!', '', '2021-09-21', Null, NULL);

insert into hashtag (text) VALUES ('twitter');

insert into tweet_hashtag(tweet_id, hashtag_id) VALUES
(6, 1);

insert into user_like(user_id, tweet_id) VALUES
(1,6);

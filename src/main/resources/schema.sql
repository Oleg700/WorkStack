CREATE TABLE users(
id serial NOT NULL PRIMARY KEY,
name VARCHAR(30) NOT NULL,
lastname VARCHAR(30) NOT NULL,
email VARCHAR(50) UNIQUE NOT NULL,
city VARCHAR(50) NOT NULL,
birth_date DATE NOT NULL );

CREATE TABLE resume(
id serial NOT NULL PRIMARY KEY,
job_position VARCHAR(30) NOT NULL,
description VARCHAR(1000) NOT NULL,
CONSTRAINT fk_user_id FOREIGN KEY (id) REFERENCES users(id));

CREATE TABLE article(
id serial NOT NULL PRIMARY KEY,
topic VARCHAR(100) NOT NULL,
content VARCHAR(4000) NOT NULL,
publication_date DATE NOT NULL,
user_id integer NOT NULL,
CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id));

CREATE TABLE comment(
id serial NOT NULL PRIMARY KEY,
content VARCHAR(500) NOT NULL,
user_id integer NOT NULL,
article_id integer NOT NULL,
CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id),
CONSTRAINT fk_article_id FOREIGN KEY (article_id) REFERENCES article(id));



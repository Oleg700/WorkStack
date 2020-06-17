DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS resume;
DROP TABLE IF EXISTS article;
DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS users;

CREATE TABLE users(
id serial NOT NULL PRIMARY KEY,
name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
email VARCHAR(50) UNIQUE NOT NULL,
city VARCHAR(50) NOT NULL,
birth_date DATE NOT NULL,
password VARCHAR(70) NOT NULL);

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

CREATE TABLE role(
id serial NOT NULL PRIMARY KEY,
name VARCHAR(50) NOT NULL);

CREATE TABLE users_roles(
user_id integer not null,
role_id integer not null,
PRIMARY KEY(user_id, role_id),
CONSTRAINT FK_USERS FOREIGN KEY (user_id) REFERENCES users(id),
CONSTRAINT FK_ROLES FOREIGN KEY (role_id) REFERENCES role(id));


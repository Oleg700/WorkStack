INSERT INTO users(name, last_name, email, city, birth_date, password)
VALUES('John','Smith','john@gmai.com','London','1992-06-23', 'password');

INSERT INTO users(name, last_name, email, city, birth_date, password)
VALUES('Paul','Smith','johan@gmai.com','London','1992-06-23', 'password');

INSERT INTO resume(job_position, description)
VALUES('developer', 'have 3 years experience');

INSERT INTO article(topic, content, publication_date, user_id)
VALUES('Java','Lorem Ipsum', '2016-06-23', 1);

INSERT INTO article(topic, content, publication_date, user_id)
VALUES('Kotlin','Lorem Ipsum', '2016-06-23', 1);

INSERT INTO article(topic, content, publication_date, user_id)
VALUES('Java','Lorem Ipsum', '2016-06-23', 2);

INSERT INTO article(topic, content, publication_date, user_id)
VALUES('Kotlin','Lorem Ipsum', '2016-06-23', 2);

INSERT INTO comment(content, user_id, article_id)
VALUES('good work', 1, 1);

INSERT INTO comment(content, user_id, article_id)
VALUES('good work2', 1, 2);

INSERT INTO comment(content, user_id, article_id)
VALUES('good work', 2, 3);

INSERT INTO comment(content, user_id, article_id)
VALUES('good work', 2, 4);

INSERT INTO role(name)
VALUES('admin');

INSERT INTO role(name)
VALUES('user');

INSERT INTO users_roles(user_id, role_id)
VALUES(1,1);

INSERT INTO users_roles(user_id, role_id)
VALUES(2,2);
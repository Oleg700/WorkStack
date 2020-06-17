INSERT INTO users(name, last_name, email, city, birth_date, password)
VALUES('John','Smith','john@gmai.com','London','1992-06-23', 'password');

INSERT INTO resume(job_position, description)
VALUES('developer', 'have 3 years experience');

INSERT INTO article(topic, content, publication_date, user_id)
VALUES('Java','Lorem Ipsum', '2016-06-23', 1);

INSERT INTO comment(content, user_id, article_id)
VALUES('good work', 1, 1);
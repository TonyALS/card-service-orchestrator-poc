CREATE TABLE person (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    birthdate DATE NOT NULL,
    CONSTRAINT id UNIQUE (id)
);

INSERT INTO person (name, email, birthdate) VALUES ('John Doe', 'john@doe.com', '2000-01-01');
INSERT INTO person (name, email, birthdate) VALUES ('Foo Bar', 'foo@bar.com', '1980-01-01');
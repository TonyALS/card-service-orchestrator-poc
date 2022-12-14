CREATE TABLE person (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    birth_date DATE NOT NULL,
    CONSTRAINT id UNIQUE (id)
);

INSERT INTO person (name, email, birth_date) VALUES ('John Doe', 'john@doe.com', '2000-01-01');
INSERT INTO person (name, email, birth_date) VALUES ('Foo Bar', 'foo@bar.com', '1980-01-01');
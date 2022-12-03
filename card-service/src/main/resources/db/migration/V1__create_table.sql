CREATE TABLE card_request (
    id SERIAL PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    request_status INTEGER NOT NULL,
    CONSTRAINT id UNIQUE (id)
);

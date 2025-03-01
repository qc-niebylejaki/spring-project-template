CREATE TABLE Book
(
    id     BIGSERIAL PRIMARY KEY,
    title  VARCHAR(255),
    author VARCHAR(255),
    isbn   VARCHAR(255),
    year   INTEGER
);
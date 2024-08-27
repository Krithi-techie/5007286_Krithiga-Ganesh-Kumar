CREATE TABLE books (
    id BIGINT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    price DECIMAL(10, 2),
    isbn VARCHAR(13)
);

CREATE TABLE customers (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255)
);

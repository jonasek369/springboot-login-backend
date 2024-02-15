create table if not exists users (
    name VARCHAR(255) UNIQUE PRIMARY KEY,
    email VARCHAR(255) UNIQUE,
    password_hash CHAR(64)
);
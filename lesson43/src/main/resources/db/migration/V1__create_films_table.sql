CREATE TABLE films (
                       id UUID PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       director VARCHAR(255) NOT NULL,
                       year INT NOT NULL,
                       description TEXT,
                       page_count INT
);
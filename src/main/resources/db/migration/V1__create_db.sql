CREATE TABLE IF NOT EXISTS client (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(201) NOT NULL CHECK (CHAR_LENGTH(name)>2 and CHAR_LENGTH(name)<201)
);

CREATE TABLE IF NOT EXISTS planet  (
    id VARCHAR(100) NOT NULL PRIMARY KEY CHECK (CHAR_LENGTH(REGEXP_REPLACE(id, '[A-Z\d]', '')) = 0),
    name VARCHAR(501) NOT NULL CHECK (CHAR_LENGTH(name)>0 and CHAR_LENGTH(name)<501)
);

CREATE TABLE IF NOT EXISTS ticket  (
    id IDENTITY PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    client_id INT NOT NULL,
    from_planet_id VARCHAR(100) NOT NULL,
    to_planet_id VARCHAR(100) NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client (id),
    FOREIGN KEY (from_planet_id) REFERENCES planet (id),
    FOREIGN KEY (to_planet_id) REFERENCES planet (id)
);
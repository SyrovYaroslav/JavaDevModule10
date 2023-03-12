INSERT INTO client
(name)
VALUES
    ('Zoro'),
    ('Luffy'),
    ('Tanjiro'),
    ('Gon'),
    ('Ichigo'),
    ('Misha'),
    ('Anna'),
    ('Tanya'),
    ('Yan'),
    ('Masha'),
    ('Dima');

INSERT INTO planet
(id, name)
VALUES
    ('E37', 'Earth'),
    ('M67', 'Mars'),
    ('V99', 'Venera'),
    ('U96', 'Uran'),
    ('P54', 'Pluto');

INSERT INTO ticket
(created_at, client_id, from_planet_id, to_planet_id)
VALUES
    ('2007-01-01 15:00:45+01', 11, 'M67', 'E37'),
    ('2020-01-01 15:00:45+05', 2, 'E37', 'M67'),
    ('2019-01-01 15:00:45+03', 3, 'V99', 'M67'),
    ('2017-01-01 15:00:45+02', 4, 'M67', 'V99'),
    ('2021-01-01 15:00:45+04', 5, 'V99', 'U96'),
    ('2022-01-01 15:00:45+06', 6, 'U96', 'V99'),
    ('2023-01-01 15:00:45-04', 7, 'U96', 'P54'),
    ('2020-01-01 15:00:45-01', 8, 'P54', 'U96'),
    ('2021-01-01 15:00:45-02', 9, 'E37', 'P54'),
    ('2002-01-01 15:00:45-03', 10, 'P54', 'E37');
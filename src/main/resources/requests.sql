
CREATE TABLE houses
(
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    price       INTEGER CHECK ( price > 0 ),
    district    TEXT,
    underground TEXT
);

INSERT INTO houses VALUES (1, 2000000, 'Советский', NULL);
INSERT INTO houses VALUES (2, 2000000, 'Авиастроительный', 'Авиостроительная');
INSERT INTO houses VALUES (3, 5000000, 'Приволжский', NULL);
INSERT INTO houses VALUES (4, 4000000, 'Приволжский', 'Проспект победы');
INSERT INTO houses VALUES (5, 7000000, 'Приволжский', NULL);


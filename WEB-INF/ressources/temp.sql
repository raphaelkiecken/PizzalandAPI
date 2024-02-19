INSERT INTO pizzas (pino, piname) VALUES (1, 'Margherita');
INSERT INTO pizzas (pino, piname) VALUES (2, 'Reine');
INSERT INTO pizzas (pino, piname) VALUES (3, '4 fromages');
INSERT INTO pizzas (pino, piname) VALUES (4, 'Calzone');
INSERT INTO pizzas (pino, piname) VALUES (5, 'Hawaïenne');
INSERT INTO pizzas (pino, piname) VALUES (6, 'Poulet curry');
INSERT INTO pizzas (pino, piname) VALUES (7, 'Végétarienne');
INSERT INTO pizzas (pino, piname) VALUES (8, 'Kebab');
INSERT INTO pizzas (pino, piname) VALUES (9, 'Chèvre miel');
INSERT INTO pizzas (pino, piname) VALUES (10, 'Saumon fumé');

INSERT INTO ingredients (ino, name, price) VALUES (1, 'Tomate', 0.5);
INSERT INTO ingredients (ino, name, price) VALUES (2, 'Mozzarella', 1.5);
INSERT INTO ingredients (ino, name, price) VALUES (3, 'Jambon', 2.0);
INSERT INTO ingredients (ino, name, price) VALUES (4, 'Champignons', 1.0);
INSERT INTO ingredients (ino, name, price) VALUES (5, 'Oeuf', 1.0);
INSERT INTO ingredients (ino, name, price) VALUES (6, 'Anchois', 2.0);
INSERT INTO ingredients (ino, name, price) VALUES (7, 'Olives', 1.0);
INSERT INTO ingredients (ino, name, price) VALUES (8, 'Câpres', 1.0);
INSERT INTO ingredients (ino, name, price) VALUES (9, 'Poivrons', 1.0);
INSERT INTO ingredients (ino, name, price) VALUES (10, 'Basilic', 0.5);
INSERT INTO ingredients (ino, name, price) VALUES (11, 'Origan', 0.5);
INSERT INTO ingredients (ino, name, price) VALUES (12, 'Pesto', 1.0);
INSERT INTO ingredients (ino, name, price) VALUES (13, 'Parmesan', 1.0);
INSERT INTO ingredients (ino, name, price) VALUES (14, 'Chèvre', 2.0);
INSERT INTO ingredients (ino, name, price) VALUES (15, 'Roquette', 1.0);
INSERT INTO ingredients (ino, name, price) VALUES (16, 'Miel', 1.0);
INSERT INTO ingredients (ino, name, price) VALUES (17, 'Poulet', 2.0);
INSERT INTO ingredients (ino, name, price) VALUES (18, 'Chorizo', 2.0);
INSERT INTO ingredients (ino, name, price) VALUES (19, 'Saumon', 3.0);
INSERT INTO ingredients (ino, name, price) VALUES (20, 'Courgette', 1.0);
INSERT INTO ingredients (ino, name, price) VALUES (21, 'Crevettes', 3.0);
INSERT INTO ingredients (ino, name, price) VALUES (22, 'Ail', 0.5);
INSERT INTO ingredients (ino, name, price) VALUES (23, 'Salami', 2.0);
INSERT INTO ingredients (ino, name, price) VALUES (24, 'Pastrami', 2.0);
INSERT INTO ingredients (ino, name, price) VALUES (25, 'Oignon', 0.5);
INSERT INTO ingredients (ino, name, price) VALUES (26, 'Epinards', 1.0);
INSERT INTO ingredients (ino, name, price) VALUES (27, 'Piment', 0.5);
INSERT INTO ingredients (ino, name, price) VALUES (28, 'Noix', 1.0);
INSERT INTO ingredients (ino, name, price) VALUES (29, 'Asperges', 1.0);
INSERT INTO ingredients (ino, name, price) VALUES (30, 'Persil', 0.5);
INSERT INTO ingredients (ino, name, price) VALUES (31, 'Crabe', 3.0);
INSERT INTO ingredients (ino, name, price) VALUES (32, 'Gorgonzola', 2.0);
INSERT INTO ingredients (ino, name, price) VALUES (33, 'Romarin', 0.5);
INSERT INTO ingredients (ino, name, price) VALUES (34, 'Moules', 3.0);
INSERT INTO ingredients (ino, name, price) VALUES (35, 'Ananas', 10.0);
INSERT INTO ingredients (ino, name, price) VALUES (36, 'Poulet tandoori', 2.0);
INSERT INTO ingredients (ino, name, price) VALUES (37, 'Lentilles', 1.0);
INSERT INTO ingredients (ino, name, price) VALUES (38, 'Kebab', 2.0);

INSERT INTO contient (pino, ino) VALUES (1, 1);
INSERT INTO contient (pino, ino) VALUES (1, 2);
INSERT INTO contient (pino, ino) VALUES (2, 1);
INSERT INTO contient (pino, ino) VALUES (2, 2);
INSERT INTO contient (pino, ino) VALUES (2, 3);
INSERT INTO contient (pino, ino) VALUES (3, 2);
INSERT INTO contient (pino, ino) VALUES (3, 13);
INSERT INTO contient (pino, ino) VALUES (3, 14);
INSERT INTO contient (pino, ino) VALUES (4, 1);
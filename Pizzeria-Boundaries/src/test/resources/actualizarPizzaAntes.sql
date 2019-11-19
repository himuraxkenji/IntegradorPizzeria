DELETE FROM Pizzas;

ALTER SEQUENCE seq_pizzas restart with 1;

INSERT INTO Pizzas VALUE (nextval('seq_pizzas'), 'Napolitana', 150.0, 12);
INSERT INTO Pizzas VALUE (nextval('seq_pizzas'), 'Muzzarella', 180.0, 15);
INSERT INTO Pizzas VALUE (nextval('seq_pizzas'), 'Fugazzeta', 200.0, 20);
INSERT INTO Pizzas VALUE (nextval('seq_pizzas'), 'Especial', 120.0, 10);




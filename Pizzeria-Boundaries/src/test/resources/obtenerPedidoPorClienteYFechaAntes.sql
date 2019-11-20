TRUNCATE TABLE clientes CASCADE;
TRUNCATE TABLE pizzas CASCADE;
TRUNCATE TABLE barrios CASCADE;
TRUNCATE TABLE pedidos CASCADE;
TRUNCATE TABLE pizzas_por_pedido CASCADE;

ALTER SEQUENCE seq_barrios RESTART WITH 1;
ALTER SEQUENCE seq_clientes RESTART WITH 1;
ALTER SEQUENCE seq_pedidos RESTART WITH 1;
ALTER SEQUENCE seq_pizzas RESTART WITH 1;

INSERT INTO barrios VALUES(NEXTVAL('seq_barrios'),'Nueva Italia');
INSERT INTO clientes (id_cliente, direccion, documento, nombre, id_barrio) VALUES (NEXTVAL('seq_clientes'), 'San Juan 570','37492933', 'Federico',1);
INSERT INTO pizzas VALUES(nextval('seq_pizzas'), 'Muzzarella', 250.0, 30);
INSERT INTO pizzas VALUES(nextval('seq_pizzas'), 'Comun', 100.0, 30);
INSERT INTO pizzas VALUES(nextval('seq_pizzas'), 'Napolitana', 300.0, 45);
INSERT INTO pizzas VALUES(nextval('seq_pizzas'), 'Con Champignones Salteados', 250.0, 30);

INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),1,'08/11/2019 19:30',2);
INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),1,'08/11/2019 21:35',2);
INSERT INTO pedidos(id_pedido,id_cliente,fecha,numero_pedido) VALUES(nextval('seq_pedidos'),1,'08/11/2019 23:55',1);

INSERT INTO pizzas_por_pedido VALUES(1,1);
INSERT INTO pizzas_por_pedido VALUES(1,2);
INSERT INTO pizzas_por_pedido VALUES(2,3);
INSERT INTO pizzas_por_pedido VALUES(2,4);
INSERT INTO pizzas_por_pedido VALUES(3,1);
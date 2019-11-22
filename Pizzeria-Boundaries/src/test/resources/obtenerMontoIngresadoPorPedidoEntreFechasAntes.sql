
delete from pizzas_por_pedido;
delete from pedidos;
delete from clientes;
delete from barrios;
delete from pizzas;

alter SEQUENCE seq_pedidos restart with 1;
alter SEQUENCE seq_clientes restart with 1;
alter SEQUENCE seq_barrios restart with 1;
alter SEQUENCE seq_pizzas restart with 1;

INSERT INTO pizzas VALUES(nextval('seq_pizzas'), 'Comun', 150.0, 30);
INSERT INTO pizzas VALUES(nextval('seq_pizzas'), 'Especial', 200.0, 30);

INSERT INTO barrios VALUES(NEXTVAL('seq_barrios'),'Mayo');
INSERT INTO barrios VALUES(NEXTVAL('seq_barrios'),'Paiman Sur');

INSERT INTO clientes (id_cliente, direccion, documento, nombre, id_barrio) VALUES (NEXTVAL('seq_clientes'), 'San Juan 570','37492933', 'Manuel',1);
INSERT INTO clientes (id_cliente, direccion, documento, nombre, id_barrio) VALUES (NEXTVAL('seq_clientes'), 'Santa Rosa 544','38222999', 'Federico',2);

INSERT INTO pedidos VALUES(nextval('seq_pedidos'),to_date('15/11/2019 21:30','DD/MM/YYYY HH24:MI'),1,1);
INSERT INTO pedidos VALUES(nextval('seq_pedidos'),to_date('18/11/2019 20:10','DD/MM/YYYY HH24:MI'),1,2);
INSERT INTO pedidos VALUES(nextval('seq_pedidos'),to_date('18/11/2019 20:30','DD/MM/YYYY HH24:MI'),2,2);
INSERT INTO pedidos VALUES(nextval('seq_pedidos'),to_date('19/11/2019 21:30','DD/MM/YYYY HH24:MI'),1,1);

INSERT INTO pizzas_por_pedido VALUES(1,2);
INSERT INTO pizzas_por_pedido VALUES(2,1);
INSERT INTO pizzas_por_pedido VALUES(3,1);
INSERT INTO pizzas_por_pedido VALUES(3,2);
INSERT INTO pizzas_por_pedido VALUES(4,1);
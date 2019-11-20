delete from pedidos;
delete from pizzas;
delete from clientes;
delete from barrios;

alter sequence seq_pedidos restart with 1;
alter sequence seq_id_pizza restart with 1;
alter sequence seq_clientes restart with 1;
alter sequence seq_barrios restart with 1;

insert into pizzas values(nextval('seq_id_pizza'), 'Napolitana', 250.0, 15);
insert into pizzas values(nextval('seq_id_pizza'), 'Comun', 200.0, 10);

insert into barrios values(nextval('seq_barrios'), 'San Francisco');

insert into clientes values(nextval('seq_clientes'), 'San Francisco', '28131367', 'Rodrigo Alarcon',1);

insert into pedidos values(nextval('seq_pedidos'), 1, '2019-11-03',1,1);
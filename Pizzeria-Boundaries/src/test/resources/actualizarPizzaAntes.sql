delete from pizzas;
alter sequence seq_id_pizza restart with 1;

insert into pizzas values(nextval('seq_id_pizza'), 'Napolitana', 120.0, 15);
insert into pizzas values(nextval('seq_id_pizza'), 'Muzzarella', 200.0, 18);
insert into pizzas values(nextval('seq_id_pizza'), 'Fugazzeta', 230.0, 20);
insert into pizzas values(nextval('seq_id_pizza'), 'Especial', 250.0, 15);




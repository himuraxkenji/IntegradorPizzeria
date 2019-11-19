Delete from barrios;
Delete from clientes;
alter SEQUENCE seq_barrios restart with 1;
Insert into barrios values (nextval('seq_barrios'),'Siempre');
Insert into barrios values (nextval('seq_barrios'),'Viva');

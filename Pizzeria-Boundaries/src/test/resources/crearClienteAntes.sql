DELETE  FROM clientes;
DELETE  FROM barrios;

ALTER SEQUENCE seq_barrios RESTART WITH 1;
ALTER SEQUENCE seq_clientes RESTART WITH 1;

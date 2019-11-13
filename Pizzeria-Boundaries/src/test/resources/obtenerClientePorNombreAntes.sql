DELETE  FROM clientes;
DELETE  FROM barrios;

ALTER SEQUENCE seq_barrios RESTART WITH 1;
ALTER SEQUENCE seq_clientes RESTART WITH 1;

INSERT INTO barrios VALUES (NEXTVAL('seq_barrios'), 'Castro y Bazan');
INSERT INTO clientes (id_cliente, direccion, documento, nombre, id_barrio) VALUES (NEXTVAL('seq_clientes'), 'Castro y Bazan', '39300672', 'Jose', 1);


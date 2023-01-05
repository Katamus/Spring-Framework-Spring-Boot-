/* Populate tables */
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'John', 'Doe', 'john.doe@gmail.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'John', 'Doe', 'john.doe@gmail.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'John', 'Doe', 'john.doe@gmail.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'John', 'Doe', 'john.doe@gmail.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'John', 'Doe', 'john.doe@gmail.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'John', 'Doe', 'john.doe@gmail.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'John', 'Doe', 'john.doe@gmail.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'John', 'Doe', 'john.doe@gmail.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'John', 'Doe', 'john.doe@gmail.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'John', 'Doe', 'john.doe@gmail.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'John', 'Doe', 'john.doe@gmail.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'John', 'Doe', 'john.doe@gmail.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'John', 'Doe', 'john.doe@gmail.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'John', 'Doe', 'john.doe@gmail.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'John', 'Doe', 'john.doe@gmail.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2022-12-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'John', 'Doe', 'john.doe@gmail.com', '2022-12-22','');


INSERT INTO productos (nombre, precio, create_at) VALUES ( 'Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ( 'Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ( 'Apple iPod shuffle', 14999909, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ( 'Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ( 'Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ( 'Bianchi Bicliqueta Aro 26', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ( 'Mica Comoda 5 Cajones', 259990, NOW());

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES ('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1,1,1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (2,1,4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1,1,5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1,1,7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES ('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (3,2,6);

INSERT INTO users (password, username, enabled) VALUES ('$2a$10$fN/Qkjb4yIFREN9bwlvjC.7Z6N.9LyLMTAx924m8vGg47Fb8B/DXe', 'andres', 1);
INSERT INTO users (password, username, enabled) VALUES ('$2a$10$iC4Ds3YqRE.QMuo1BNGXIeCeLwk8edyHQ4oK6owFPLfz7rjrMVwSS', 'admin', 1);

INSERT INTO authorities (user_id, authority) VALUES ( 1, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES ( 2, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES ( 2, 'ROLE_ADMIN');
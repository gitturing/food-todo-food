CREATE SCHEMA IF NOT EXISTS food;
SET SCHEMA food;
CREATE TABLE IF NOT EXISTS restaurantes
    (id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    tipo_cocina VARCHAR(100),
    ubicacion VARCHAR(100),
    PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS clientes
    (id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    documento VARCHAR(100),
    email VARCHAR(60),
    direccion VARCHAR(60),
    telefono VARCHAR(60),
    fecha_fegistro DATE,
    PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS pedidos
    (id INT NOT NULL AUTO_INCREMENT,
    fecha DATE,
    total DECIMAL(10, 2),
    estado VARCHAR(20),
    id_cliente INT,
    id_restaurante INT,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id),
    FOREIGN KEY (id_restaurante) REFERENCES restaurantes(id),
    PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS productos
    (id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    precio DECIMAL(10, 2),
    descripcion VARCHAR(100),
    id_restaurante INT,
    FOREIGN KEY (id_restaurante) REFERENCES restaurantes(id),
    PRIMARY KEY (id));


-- INSERT INTO Restaurante
INSERT INTO restaurantes (nombre, tipo_cocina, ubicacion) VALUES ('Poly', 'Comida Internacional', 'Cr9-32-39');
INSERT INTO restaurantes (nombre, tipo_cocina, ubicacion) VALUES ('Garibaldi', 'Comida Mexicana', 'Cr10-32-38');
INSERT INTO restaurantes (nombre, tipo_cocina, ubicacion) VALUES ('Food', 'Comida Internacional', 'Cr11-32-40');
INSERT INTO restaurantes (nombre, tipo_cocina, ubicacion) VALUES ('Mercagan', 'Comida Internacional', 'Cr12-32-39');
INSERT INTO restaurantes (nombre, tipo_cocina, ubicacion) VALUES ('Macho', 'Comida Mexicana', 'Cr13-32-38');
INSERT INTO restaurantes (nombre, tipo_cocina, ubicacion) VALUES ('Mediterraneo', 'Comida Internacional', 'Cr14-32-40');
INSERT INTO restaurantes (nombre, tipo_cocina, ubicacion) VALUES ('tovalo', 'Comida Internacional', 'Cr15-32-39');
INSERT INTO restaurantes (nombre, tipo_cocina, ubicacion) VALUES ('Matue', 'Comida Mexicana', 'Cr16-32-38');
INSERT INTO restaurantes (nombre, tipo_cocina, ubicacion) VALUES ('Dulce', 'Comida Internacional', 'Cr17-32-40');
INSERT INTO restaurantes (nombre, tipo_cocina, ubicacion) VALUES ('Meat & Ribs', 'Comida Internacional', 'Cr8-32-40');

-- INSERT INTO Cliente
INSERT INTO clientes (nombre, documento, email, direccion, telefono,fecha_fegistro) VALUES ('Juan Diaz', '1100892202', 'Juan@example.com','Cr9-32-39', '3165768904','2020-10-10');
INSERT INTO clientes (nombre, documento, email, direccion, telefono,fecha_fegistro) VALUES ('Camilo Pizarro', '1100892203', 'Camilo@example.com','Cr10-32-39', '3165768905','2020-10-10');
INSERT INTO clientes (nombre, documento, email, direccion, telefono,fecha_fegistro) VALUES ('Jose Jaimes', '1100892204', 'Jose@example.com', 'Cr11-32-39', '3165768905','2020-10-10');
INSERT INTO clientes (nombre, documento, email, direccion, telefono,fecha_fegistro) VALUES ('Natalia Mantilla', '1100892205', 'Natalia@example.com','Cr12-32-39', '3165768906','2020-10-10');
INSERT INTO clientes (nombre, documento, email, direccion, telefono,fecha_fegistro) VALUES ('Hernando Matilla', '1100892206', 'Hernando@example.com','Cr13-32-39', '3165768907','2020-10-10');
INSERT INTO clientes (nombre, documento, email, direccion, telefono,fecha_fegistro) VALUES ('Mauricio Pedraza', '1100892207', 'Mauricio@example.com','Cr14-32-39', '3165768908','2020-10-10');
INSERT INTO clientes (nombre, documento, email, direccion, telefono,fecha_fegistro) VALUES ('Carlos Perez', '1100892208', 'Carlos@example.com','Cr15-32-39', '3165768909','2020-10-10');
INSERT INTO clientes (nombre, documento, email, direccion, telefono,fecha_fegistro) VALUES ('Leidy Roman', '1100892210', 'Lediy@example.com','Cr16-32-39', '3165768910','2020-10-10');
INSERT INTO clientes (nombre, documento, email, direccion, telefono,fecha_fegistro) VALUES ('Justino Cuadros', '1100892211', 'Justino@example.com','Cr17-32-39','3165768924','2020-10-10');
INSERT INTO clientes (nombre, documento, email, direccion, telefono,fecha_fegistro) VALUES ('Victor Castillo', '1100562202', 'Victor@example.com', 'Cr18-32-39','3156768904','2020-10-10');

-- INSERT INTO Pedido
INSERT INTO pedidos (fecha, total, estado, id_cliente, id_restaurante) VALUES ('2023-01-01', 50.00, 'Despachado', 1, 1);
INSERT INTO pedidos (fecha, total, estado, id_cliente, id_restaurante) VALUES ('2023-01-01', 90.00, 'Despachado', 2, 2);
INSERT INTO pedidos (fecha, total, estado, id_cliente, id_restaurante) VALUES ('2023-01-01', 50.00, 'Pendiente', 3, 3);
INSERT INTO pedidos (fecha, total, estado, id_cliente, id_restaurante) VALUES ('2023-01-01', 100.00, 'Despachado', 4, 4);
INSERT INTO pedidos (fecha, total, estado, id_cliente, id_restaurante) VALUES ('2023-01-01', 350.00, 'Despachado', 5, 5);
INSERT INTO pedidos (fecha, total, estado, id_cliente, id_restaurante) VALUES ('2023-01-01', 750.00, 'Cancelado', 6, 6);
INSERT INTO pedidos (fecha, total, estado, id_cliente, id_restaurante) VALUES ('2023-01-01', 550.00, 'Despachado', 7, 7);
INSERT INTO pedidos (fecha, total, estado, id_cliente, id_restaurante) VALUES ('2023-01-01', 950.00, 'Despachado', 8, 8);
INSERT INTO pedidos (fecha, total, estado, id_cliente, id_restaurante) VALUES ('2023-01-01', 70.00, 'Despachado', 9, 9);
INSERT INTO pedidos (fecha, total, estado, id_cliente, id_restaurante) VALUES ('2023-01-01', 80.00, 'Despachado', 10, 10);

-- INSERT INTO Producto
INSERT INTO productos (nombre, precio, descripcion, id_restaurante) VALUES ('Cheleta de cerdo', 10.00, 'Descripción del Producto 1', 1);
INSERT INTO productos (nombre, precio, descripcion, id_restaurante) VALUES ('Hamburgueza', 50.00, 'Descripción del Producto 2', 2);
INSERT INTO productos (nombre, precio, descripcion, id_restaurante) VALUES ('Carne asada', 120.00, 'Descripción del Producto 3', 3);
INSERT INTO productos (nombre, precio, descripcion, id_restaurante) VALUES ('Caldo con papa', 60.00, 'Descripción del Producto 4', 4);
INSERT INTO productos (nombre, precio, descripcion, id_restaurante) VALUES ('Vandeja paisa', 40.00, 'Descripción del Producto 5', 5);
INSERT INTO productos (nombre, precio, descripcion, id_restaurante) VALUES ('Pizza italina', 50.00, 'Descripción del Producto 6', 6);
INSERT INTO productos (nombre, precio, descripcion, id_restaurante) VALUES ('Almejas', 100.00, 'Descripción del Producto 7', 7);
INSERT INTO productos (nombre, precio, descripcion, id_restaurante) VALUES ('Camarones en salsa', 30.00, 'Descripción del Producto 8', 8);
INSERT INTO productos (nombre, precio, descripcion, id_restaurante) VALUES ('Cerdo en vino', 20.00, 'Descripción del Producto 9', 9);
INSERT INTO productos (nombre, precio, descripcion, id_restaurante) VALUES ('Carne a la llanera', 80.00, 'Descripción del Producto 10', 10);
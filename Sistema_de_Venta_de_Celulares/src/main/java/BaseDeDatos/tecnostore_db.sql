CREATE DATABASE tecnostore_db;

USE tecnostore_db;

-- Tabla Celular

CREATE TABLE celular (
    id INT NOT NULL AUTO_INCREMENT,
    marca VARCHAR(50)  NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    sistema_operativo VARCHAR(50) NOT NULL,
    gama ENUM ('Alta','Media','Baja') NOT NULL,
    precio DOUBLE NOT NULL,
    stock INT NOT NULL,
    PRIMARY KEY (id)
);

-- Tabla Cliente

CREATE TABLE cliente (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    identificacion VARCHAR(50) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    telefono VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

-- Tabla Venta

CREATE TABLE venta (
    id INT NOT NULL AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    fecha DATETIME DEFAULT NOW() NOT NULL,
    total DOUBLE DEFAULT 0,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

-- Tabla detalle de venta

CREATE TABLE detalle_venta(
    id INT NOT NULL AUTO_INCREMENT,
    id_venta INT NOT NULL,
    id_celular INT NOT NULL,
    cantidad INT NOT NULL,
    subtotal DOUBLE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_venta) REFERENCES venta(id),
    FOREIGN KEY (id_celular) REFERENCES celular(id)
);

-- Insertar datos


INSERT INTO celular (marca, modelo, sistema_operativo, gama, precio, stock) VALUES
('Samsung', 'Galaxy S23', 'Android', 'Alta', 4200, 15),
('Apple', 'iPhone 14', 'iOS', 'Alta', 5200, 10),
('Xiaomi', 'Redmi Note 12', 'Android', 'Media', 1200, 25),
('Motorola', 'Moto G22', 'Android', 'Media', 950, 30),
('Nokia', 'C21', 'Android', 'Baja', 550, 40);


INSERT INTO cliente (nombre, identificacion, correo, telefono) VALUES
('Juan Perez', '0102030405', 'juan.perez@gmail.com', '0991234567'),
('María Gomez', '0918273645', 'maria.gomez@hotmail.com', '0987654321'),
('Carlos Lopez', '1102938475', 'carlos.lopez@yahoo.com', '0974561230');


INSERT INTO venta (id_cliente, fecha, total) VALUES
(1, '2026-02-10 14:30:00', 4200),
(2, '2026-02-10 16:00:00', 2400),
(3, '2026-02-11 10:15:00', 550);


INSERT INTO detalle_venta (id_venta, id_celular, cantidad, subtotal) VALUES
(1, 1, 1, 4200),   
(2, 3, 2, 2400),   
(3, 5, 1, 550);    

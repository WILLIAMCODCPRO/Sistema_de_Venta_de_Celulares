CREATE DATABASE tecnostore_db;

USE tecnostore_db;

-- Tabla celulares

CREATE TABLE celular (
    id INT NOT NULL AUTO_INCREMENT,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    correo_electronico VARCHAR(50) NOT NULL,
    sistema_operativo VARCHAR(50) NOT NULL,
    gama ENUM ('Alta','Media','Baja') NOT NULL,
    precio DOUBLE NOT NULL,
    stock INT NOT NULL
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
    total DOUBLE NOT NULL,
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

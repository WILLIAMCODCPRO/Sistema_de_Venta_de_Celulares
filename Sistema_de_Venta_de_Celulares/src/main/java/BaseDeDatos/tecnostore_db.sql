CREATE DATABASE tecnostore_db;

USE tecnostore_db;

-- Tabla celulares

CREATE TABLE celular (
    id INT NOT NULL AUTO_INCREMENT,
    id_marca INT NOT NULL,
    id_modelo INT NOT NULL,
    id_sistema_operativo INT NOT NULL,
    gama ENUM ('Alta','Media','Baja') NOT NULL,
    precio DOUBLE NOT NULL,
    stock INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_marca) REFERENCES marca(id),
    FOREIGN KEY (id_modelo) REFERENCES modelo(id),
    FOREIGN KEY (id_sistema_operativo) REFERENCES sistema_operativo(id)
);

-- Tabla marca

CREATE TABLE marca(
    id INT NOT NULL AUTO_INCREMENT,
    nombre_marca VARCHAR(50) NOT NULL
    PRIMARY KEY (id)
);

-- Tabla modelo

CREATE TABLE modelo(
    id INT NOT NULL AUTO_INCREMENT,
    nombre_modelo VARCHAR(50) NOT NULL
    PRIMARY KEY (id)
);

-- Tabla sistema operativo

CREATE TABLE sistema_operativo(
    id INT NOT NULL AUTO_INCREMENT,
    nombre_sistema_operativo VARCHAR(50) NOT NULL
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

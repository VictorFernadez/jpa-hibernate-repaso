CREATE DATABASE IF NOT EXISTS demo_jpa_onetomany;
USE demo_jpa_onetomany;

-- Crear tabla 'categoria'
CREATE TABLE categoria (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           tipo VARCHAR(50) NOT NULL
);

-- Crear tabla 'producto'
CREATE TABLE producto (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          categoria_id BIGINT,
                          CONSTRAINT fk_categoria FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

-- Insertar 10 registros en 'categoria'
INSERT INTO categoria (tipo)
VALUES
    ('ELECTRONICA'),
    ('ROPA'),
    ('HOGAR'),
    ('DEPORTE'),
    ('LIBROS'),
    ('ALIMENTOS'),
    ('JUGUETES'),
    ('COSMETICOS'),
    ('AUTOMOVILES'),
    ('OTROS');

-- Insertar 100 registros en 'producto' usando INSERT INTO
-- Cada producto se asigna a una categoría de forma cíclica
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 1', 1);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 2', 2);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 3', 3);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 4', 4);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 5', 5);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 6', 6);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 7', 7);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 8', 8);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 9', 9);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 10', 10);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 11', 1);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 12', 2);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 13', 3);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 14', 4);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 15', 5);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 16', 6);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 17', 7);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 18', 8);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 19', 9);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 20', 10);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 21', 1);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 22', 2);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 23', 3);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 24', 4);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 25', 5);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 26', 6);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 27', 7);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 28', 8);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 29', 9);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 30', 10);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 31', 1);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 32', 2);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 33', 3);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 34', 4);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 35', 5);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 36', 6);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 37', 7);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 38', 8);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 39', 9);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 40', 10);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 41', 1);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 42', 2);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 43', 3);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 44', 4);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 45', 5);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 46', 6);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 47', 7);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 48', 8);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 49', 9);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 50', 10);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 51', 1);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 52', 2);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 53', 3);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 54', 4);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 55', 5);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 56', 6);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 57', 7);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 58', 8);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 59', 9);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 60', 10);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 61', 1);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 62', 2);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 63', 3);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 64', 4);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 65', 5);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 66', 6);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 67', 7);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 68', 8);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 69', 9);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 70', 10);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 71', 1);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 72', 2);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 73', 3);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 74', 4);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 75', 5);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 76', 6);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 77', 7);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 78', 8);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 79', 9);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 80', 10);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 81', 1);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 82', 2);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 83', 3);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 84', 4);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 85', 5);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 86', 6);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 87', 7);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 88', 8);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 89', 9);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 90', 10);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 91', 1);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 92', 2);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 93', 3);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 94', 4);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 95', 5);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 96', 6);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 97', 7);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 98', 8);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 99', 9);
INSERT INTO producto (nombre, categoria_id) VALUES ('Producto 100', 10);
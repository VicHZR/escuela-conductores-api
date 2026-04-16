CREATE DATABASE escuela_conductores_db
WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Peru.1252'
    LC_CTYPE = 'Spanish_Peru.1252'
    TEMPLATE = template0;

\c escuela_conductores_db;

CREATE TABLE departamento (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    estado CHAR(1) NOT NULL DEFAULT 'A'
);

CREATE TABLE provincia (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    estado CHAR(1) NOT NULL DEFAULT 'A',
    departamento_id INTEGER NOT NULL,
    CONSTRAINT fk_provincia_departamento
        FOREIGN KEY (departamento_id)
        REFERENCES departamento(id)
);

CREATE TABLE distrito (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    estado CHAR(1) NOT NULL DEFAULT 'A',
    provincia_id INTEGER NOT NULL,
    CONSTRAINT fk_distrito_provincia
        FOREIGN KEY (provincia_id)
        REFERENCES provincia(id)
);

CREATE TABLE escuela_conductor (
    id SERIAL PRIMARY KEY,
    razon_social VARCHAR(200) NOT NULL,
    direccion VARCHAR(300),
    estado CHAR(1) NOT NULL DEFAULT 'A',
    distrito_id INTEGER,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP,

    CONSTRAINT fk_escuela_distrito
        FOREIGN KEY (distrito_id)
        REFERENCES distrito(id)
);

INSERT INTO departamento (nombre, estado) VALUES
('LIMA', 'A'),
('AREQUIPA', 'A'),
('CUSCO', 'A'),
('PIURA', 'I');

INSERT INTO provincia (nombre, estado, departamento_id) VALUES
('LIMA', 'A', 1),
('HUAURA', 'A', 1),
('AREQUIPA', 'A', 2);
``

INSERT INTO distrito (nombre, estado, provincia_id) VALUES
('MIRAFLORES', 'A', 1),
('SAN ISIDRO', 'A', 1),
('BARRANCA', 'A', 2),
('YANAHUARA', 'A', 3);

INSERT INTO escuela_conductor (razon_social, direccion, estado, distrito_id)
VALUES
('ESCUELA DE CONDUCTORES LIMA SEGURA', 'Av. Principal 123', 'A', 1),
('ESCUELA AUTO PERU', 'Jr. Libertad 456', 'A', 4);

-- Departamentos activos
SELECT * FROM departamento WHERE estado = 'A';

-- Provincias con departamento
SELECT p.id, p.nombre, d.nombre AS departamento
FROM provincia p
JOIN departamento d ON d.id = p.departamento_id;

-- Distritos con provincia
SELECT di.id, di.nombre, pr.nombre AS provincia
FROM distrito di
JOIN provincia pr ON pr.id = di.provincia_id;

-- Escuelas con distrito
SELECT e.razon_social, d.nombre AS distrito
FROM escuela_conductor e
LEFT JOIN distrito d ON d.id = e.distrito_id;

UPDATE departamento
SET estado = 'I'
WHERE id = 1;


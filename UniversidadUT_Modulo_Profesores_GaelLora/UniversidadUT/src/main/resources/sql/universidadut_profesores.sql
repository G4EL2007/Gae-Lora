CREATE DATABASE IF NOT EXISTS universidadUt;
USE universidadUt;

CREATE TABLE IF NOT EXISTS alumnos (
    numExpediente INT PRIMARY KEY,
    nombre VARCHAR(80) NOT NULL,
    curp CHAR(18) NOT NULL UNIQUE,
    grupo VARCHAR(20) NOT NULL,
    promedio DECIMAL(3,1) NOT NULL CHECK (promedio >= 0 AND promedio <= 10)
);

CREATE TABLE IF NOT EXISTS profesores (
    numEmpleado INT PRIMARY KEY,
    nombre VARCHAR(80) NOT NULL,
    curp CHAR(18) NOT NULL UNIQUE,
    puesto VARCHAR(80) NOT NULL,
    sueldo DECIMAL(10,2) NOT NULL CHECK (sueldo > 0)
);

SELECT * FROM profesores;

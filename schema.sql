-- ============================================================
-- Práctica UT8 - Gestión de Hotel
-- Alumno: Engel Nieves
-- ============================================================

CREATE DATABASE IF NOT EXISTS hotel_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE hotel_db;

-- Tabla de habitaciones
CREATE TABLE IF NOT EXISTS habitacion (
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo       VARCHAR(50)    NOT NULL,
    precio_por_noche DECIMAL(10,2) NOT NULL,
    capacidad  INT            NOT NULL,
    descripcion VARCHAR(255)  NOT NULL,
    disponible  TINYINT(1)    NOT NULL DEFAULT 1
);

-- Tabla de reservas
CREATE TABLE IF NOT EXISTS reserva (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_cliente  VARCHAR(100)  NOT NULL,
    email_cliente   VARCHAR(150)  NOT NULL,
    fecha_entrada   DATE          NOT NULL,
    fecha_salida    DATE          NOT NULL,
    num_personas    INT           NOT NULL,
    observaciones   VARCHAR(255),
    habitacion_id   BIGINT        NOT NULL,
    CONSTRAINT fk_reserva_habitacion FOREIGN KEY (habitacion_id) REFERENCES habitacion(id)
);

-- Usuario de la aplicación con permisos de escritura
-- Ejecutar como root si es necesario:
-- CREATE USER IF NOT EXISTS 'hotel_user'@'%' IDENTIFIED BY 'hotel_pass';
-- GRANT ALL PRIVILEGES ON hotel_db.* TO 'hotel_user'@'%';
-- FLUSH PRIVILEGES;

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-11-2023 a las 19:48:11
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `vacunar23_grupo59`
--
CREATE DATABASE IF NOT EXISTS `vacunar23_grupo59` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `vacunar23_grupo59`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citavacunacion`
--

CREATE TABLE `citavacunacion` (
  `codCita` int(11) NOT NULL,
  `idCiudadano` int(7) NOT NULL,
  `codRefuerzo` int(1) NOT NULL,
  `fechaHoraCita` varchar(10) NOT NULL,
  `centroVacunacion` varchar(50) NOT NULL,
  `horarioTurno` time NOT NULL,
  `idVacuna` int(7) NOT NULL,
  `estado` varchar(8) NOT NULL COMMENT 'Activa-Cancelada-Vencida'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadano`
--

CREATE TABLE `ciudadano` (
  `idCiudadano` int(7) NOT NULL,
  `dni` int(8) NOT NULL,
  `nombreCompleto` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `celular` varchar(18) NOT NULL,
  `patologia` varchar(30) NOT NULL,
  `ambitoTrabajo` varchar(40) NOT NULL,
  `distrito` varchar(12) NOT NULL,
  `codRefuerzo` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudadano`
--

INSERT INTO `ciudadano` (`idCiudadano`, `dni`, `nombreCompleto`, `email`, `celular`, `patologia`, `ambitoTrabajo`, `distrito`, `codRefuerzo`) VALUES
(1, 37258147, 'Fulano Perez', 'fulanoperez@gmail.com', '2664154785', 'diabetes', 'Salud', 'zona Sur', 0),
(2, 12345678, 'Juan Pérez', 'juan@gmail.com', '5551234567', 'Hipertensión', 'Salud', 'Zona Sur', 1),
(3, 23456789, 'María Rodríguez', 'maria@hotmail.com', '5552345678', 'Diabetes', 'Educación', 'Zona Norte', 0),
(4, 34567890, 'Carlos González', 'carlos@gmail.com', '5553456789', 'Asma', 'Seguridad', 'Zona Oeste', 2),
(5, 45678901, 'Laura Martínez', 'laura@hotmail.com', '5554567890', 'Ninguna', 'Arte', 'Zona Este', 1),
(6, 56789012, 'Pedro Sánchez', 'pedro@gmail.com', '5555678901', 'Diabetes', 'Transporte', 'Zona Centro', 3),
(7, 67890123, 'Ana López', 'ana@gmail.com', '5556789012', 'Hipertensión', 'Atención al Cliente', 'Zona Sur', 0),
(8, 78901234, 'David Torres', 'david@hotmail.com', '5557890123', 'Ninguna', 'Turismo', 'Zona Norte', 2),
(9, 89012345, 'Sofía Rodríguez', 'sofia@gmail.com', '5558901234', 'Asma', 'Salud', 'Zona Oeste', 1),
(10, 90123456, 'José Pérez', 'jose@hotmail.com', '5559012345', 'Diabetes', 'Educación', 'Zona Este', 0),
(11, 12312312, 'María González', 'maria@gmail.com', '5551231234', 'Ninguna', 'Seguridad', 'Zona Centro', 3),
(12, 23423423, 'Carlos Martínez', 'carlos@hotmail.com', '5552342345', 'Hipertensión', 'Arte', 'Zona Sur', 2),
(13, 34534534, 'Laura Sánchez', 'laura@gmail.com', '5553453456', 'Asma', 'Transporte', 'Zona Norte', 1),
(14, 45645645, 'Pedro Rodríguez', 'pedro@hotmail.com', '5554564567', 'Ninguna', 'Atención al Cliente', 'Zona Oeste', 0),
(15, 56756756, 'Ana Martínez', 'ana@hotmail.com', '5555675678', 'Diabetes', 'Turismo', 'Zona Este', 1),
(16, 67867867, 'David González', 'david@gmail.com', '5556786789', 'Ninguna', 'Salud', 'Zona Centro', 2),
(17, 78978978, 'Sofía Sánchez', 'sofia@hotmail.com', '5557897890', 'Asma', 'Seguridad', 'Zona Sur', 3),
(18, 89089089, 'Miguel Torres', 'miguel@gmail.com', '5558908908', 'Ninguna', 'Educación', 'Zona Oeste', 0),
(19, 98798798, 'Elena Pérez', 'elena@hotmail.com', '5559879879', 'Diabetes', 'Arte', 'Zona Norte', 1),
(20, 87687687, 'Daniel Sánchez', 'daniel@gmail.com', '5558768768', 'Asma', 'Atención al Cliente', 'Zona Centro', 2),
(21, 76576576, 'Isabel González', 'isabel@gmail.com', '5557657657', 'Ninguna', 'Turismo', 'Zona Este', 0),
(22, 65465465, 'Jorge Martínez', 'jorge@gmail.com', '5556546546', 'Hipertensión', 'Salud', 'Zona Sur', 3),
(23, 54354354, 'Carmen López', 'carmen@gmail.com', '5555435435', 'Diabetes', 'Transporte', 'Zona Oeste', 1),
(24, 43243243, 'Luis Rodríguez', 'luis@gmail.com', '5554324324', 'Ninguna', 'Seguridad', 'Zona Norte', 2),
(25, 32132132, 'Patricia Sánchez', 'patricia@gmail.com', '5553213213', 'Asma', 'Educación', 'Zona Centro', 1),
(26, 21021021, 'Antonio González', 'antonio@gmail.com', '5552102102', 'Ninguna', 'Arte', 'Zona Este', 0),
(27, 10210210, 'Lucía Martínez', 'lucia@gmail.com', '5551021021', 'Hipertensión', 'Salud', 'Zona Sur', 3),
(28, 98712345, 'Manuel Pérez', 'manuel@gmail.com', '5559871234', 'Diabetes', 'Transporte', 'Zona Centro', 2),
(29, 87623456, 'Eva Sánchez', 'eva@gmail.com', '5558762345', 'Asma', 'Atención al Cliente', 'Zona Oeste', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `laboratorio`
--

CREATE TABLE `laboratorio` (
  `idLaboratorio` int(11) NOT NULL,
  `CUIT` bigint(11) NOT NULL,
  `nomLaboratorio` varchar(50) NOT NULL,
  `pais` varchar(20) NOT NULL,
  `domComercial` varchar(30) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `laboratorio`
--

INSERT INTO `laboratorio` (`idLaboratorio`, `CUIT`, `nomLaboratorio`, `pais`, `domComercial`, `estado`) VALUES
(7, 20234567890, 'Centro Nacional Gamaleya de Ep', 'Rusia', '123 Main Street, NY', 1),
(8, 30567890123, 'Centro Nacional Gamaleya de Ep', 'Rusia', '456 Elm Street, CA', 1),
(9, 40123456789, 'Serum Institute - India', 'India', '789 Oak Avenue, London', 1),
(10, 50012345678, 'Beijing Institute of Biologica', 'China', '101 Willow Road, Beijing', 1),
(11, 60098765432, 'AstraZeneca-Oxford - Reino Uni', 'Reino Unido', '246 Cedar Lane, NJ', 1),
(12, 70345678901, 'Moderna Switzerland GmbH', 'Suiza', '369 Birch Street, Moscow', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacuna`
--

CREATE TABLE `vacuna` (
  `idVacuna` int(7) NOT NULL,
  `nroSerieDosis` int(8) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `medida` double NOT NULL,
  `fechaCaduca` date NOT NULL,
  `colocada` tinyint(1) NOT NULL,
  `idLaboratorio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vacuna`
--

INSERT INTO `vacuna` (`idVacuna`, `nroSerieDosis`, `marca`, `medida`, `fechaCaduca`, `colocada`, `idLaboratorio`) VALUES
(110, 12345678, 'Gam-COVID-Vac', 0.3, '2024-06-30', 1, 7),
(111, 23456789, 'Sputnik LIGHT', 0.3, '2024-09-30', 0, 7),
(112, 34567890, 'Covishield', 0.5, '2024-11-30', 1, 9),
(113, 45678901, 'Sinopharm', 0.5, '2025-02-28', 1, 10),
(114, 56789012, 'AstraZeneca-Oxford', 0.9, '2024-10-31', 0, 11),
(115, 67890123, 'Moderna', 0.5, '2025-01-31', 1, 12),
(116, 78901234, 'Convidecia', 0.5, '2025-03-31', 0, 9),
(117, 89012345, 'Comirnaty', 0.3, '2024-08-31', 1, 10),
(118, 90123456, 'Sputnik V', 0.3, '2024-07-31', 1, 11),
(119, 12312312, 'Gam-COVID-Vac', 0.3, '2024-06-30', 0, 12),
(120, 23423423, 'Sputnik LIGHT', 0.5, '2024-09-30', 1, 7),
(121, 34534534, 'Covishield', 0.3, '2024-11-30', 0, 7),
(122, 45645645, 'Sinopharm', 0.3, '2025-02-28', 1, 9),
(123, 56756756, 'AstraZeneca-Oxford', 0.9, '2024-10-31', 1, 10),
(124, 67867867, 'Moderna', 0.9, '2025-01-31', 0, 11),
(125, 78978978, 'Convidecia', 0.5, '2025-03-31', 1, 12),
(126, 89089089, 'Comirnaty', 0.3, '2024-08-31', 0, 7),
(127, 98798798, 'Sputnik V', 0.3, '2024-07-31', 1, 7),
(128, 87687687, 'Gam-COVID-Vac', 0.5, '2024-06-30', 1, 10),
(129, 76576576, 'Sputnik LIGHT', 0.9, '2024-09-30', 0, 10),
(130, 65465465, 'Covishield', 0.3, '2024-11-30', 1, 11),
(131, 54354354, 'Sinopharm', 0.5, '2025-02-28', 1, 12),
(132, 43243243, 'AstraZeneca-Oxford', 0.5, '2024-10-31', 0, 7),
(133, 32132132, 'Moderna', 0.9, '2025-01-31', 1, 7),
(134, 21021021, 'Convidecia', 0.5, '2025-03-31', 1, 9),
(135, 10210210, 'Comirnaty', 0.3, '2024-08-31', 0, 10);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citavacunacion`
--
ALTER TABLE `citavacunacion`
  ADD UNIQUE KEY `codCita` (`codCita`),
  ADD UNIQUE KEY `idVacuna` (`idVacuna`),
  ADD KEY `idCiudadano` (`idCiudadano`);

--
-- Indices de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  ADD PRIMARY KEY (`idCiudadano`),
  ADD UNIQUE KEY `idCiudadano` (`idCiudadano`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  ADD PRIMARY KEY (`idLaboratorio`),
  ADD UNIQUE KEY `CUIT` (`CUIT`,`nomLaboratorio`);

--
-- Indices de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD PRIMARY KEY (`idVacuna`),
  ADD UNIQUE KEY `idVacuna` (`idVacuna`),
  ADD KEY `idLaboratorio` (`idLaboratorio`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  MODIFY `idCiudadano` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  MODIFY `idLaboratorio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  MODIFY `idVacuna` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=136;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citavacunacion`
--
ALTER TABLE `citavacunacion`
  ADD CONSTRAINT `citavacunacion_ibfk_1` FOREIGN KEY (`idCiudadano`) REFERENCES `ciudadano` (`idCiudadano`),
  ADD CONSTRAINT `citavacunacion_ibfk_2` FOREIGN KEY (`idVacuna`) REFERENCES `vacuna` (`idVacuna`);

--
-- Filtros para la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD CONSTRAINT `vacuna_ibfk_1` FOREIGN KEY (`idLaboratorio`) REFERENCES `laboratorio` (`idLaboratorio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

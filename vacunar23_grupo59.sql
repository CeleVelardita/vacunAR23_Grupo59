-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-10-2023 a las 02:45:01
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
  `fechaHoraColoca` date NOT NULL,
  `idVacuna` int(7) NOT NULL
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
  `ambitoTrabajo` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudadano`
--

INSERT INTO `ciudadano` (`idCiudadano`, `dni`, `nombreCompleto`, `email`, `celular`, `patologia`, `ambitoTrabajo`) VALUES
(1, 33444555, 'Pepe Torralba', 'pepetorralba@gmail.com', '11-23456789', 'ninguna', 'salud'),
(3, 22333444, 'Fua Sandra', 'fuasandra@gmail.com', '2901-192134', 'diabetes', 'salud'),
(4, 11222333, 'Bob Esponja', 'bobesponja@gmail.com', '3345-789124', 'ninguna', 'educación'),
(6, 11555666, 'Pepito Pérez', 'pepitoperez@gmail.com', '11-89702345', 'ninguna', 'educación'),
(8, 12345678, 'Juan Perez', 'juanperez@gmail.com', '11-00001111', 'cardíaco', 'textil'),
(9, 22111555, 'Ezequiel Diaz', 'programeze@gmail.com', '11-002234256', 'ninguno', 'profesor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `laboratorio`
--

CREATE TABLE `laboratorio` (
  `idLaboratorio` int(11) NOT NULL,
  `CUIT` bigint(11) NOT NULL,
  `nomLaboratorio` varchar(30) NOT NULL,
  `pais` varchar(20) NOT NULL,
  `domComercial` varchar(30) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `laboratorio`
--

INSERT INTO `laboratorio` (`idLaboratorio`, `CUIT`, `nomLaboratorio`, `pais`, `domComercial`, `estado`) VALUES
(1, 12345678901, 'Pirulito', 'Argentina', 'Avenida Siempreviva 123', 1),
(3, 12345678923, 'Pirulito2', 'Argentina', 'Avenida Siempreviva 123', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacuna`
--

CREATE TABLE `vacuna` (
  `idVacuna` int(7) NOT NULL,
  `nroSerieDosis` int(6) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `medida` double NOT NULL,
  `fechaCaduca` date NOT NULL,
  `colocada` tinyint(1) NOT NULL,
  `nombreLab` varchar(40) NOT NULL,
  `idLaboratorio` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vacuna`
--

INSERT INTO `vacuna` (`idVacuna`, `nroSerieDosis`, `marca`, `medida`, `fechaCaduca`, `colocada`, `nombreLab`, `idLaboratorio`) VALUES
(1, 112233, 'Sputnik V', 0.5, '2030-08-20', 0, '', 1),
(14, 11111, 'Pfitzer', 0.3, '2025-11-20', 0, 'Pirulito', 1),
(15, 2222, 'Pfitzer', 0.3, '2025-11-20', 0, 'Pirulito', 3),
(16, 123, 'Probando', 0.3, '2024-10-04', 0, 'Pirulito', 1),
(17, 456, 'Otra Prueba', 0.9, '2026-10-04', 0, 'Pirulito2', 3);

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
  ADD UNIQUE KEY `CUIT` (`CUIT`) USING BTREE;

--
-- Indices de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD PRIMARY KEY (`idVacuna`),
  ADD UNIQUE KEY `idVacuna` (`idVacuna`),
  ADD UNIQUE KEY `nroSerieDosis` (`nroSerieDosis`),
  ADD KEY `idLaboratorio` (`idLaboratorio`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  MODIFY `idCiudadano` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  MODIFY `idLaboratorio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  MODIFY `idVacuna` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

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

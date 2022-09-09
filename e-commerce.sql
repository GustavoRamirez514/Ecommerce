-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 15, 2022 at 05:45 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `e-commerce`
--

-- --------------------------------------------------------

--
-- Table structure for table `facturas`
--

CREATE TABLE `facturas` (
  `Id_Factura` int(11) NOT NULL,
  `Identificacion` varchar(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Direccion` varchar(20) NOT NULL,
  `Telefono` varchar(13) NOT NULL,
  `Fecha` date NOT NULL,
  `Envio` varchar(50) NOT NULL,
  `Total` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `facturas`
--

INSERT INTO `facturas` (`Id_Factura`, `Identificacion`, `Nombre`, `Direccion`, `Telefono`, `Fecha`, `Envio`, `Total`) VALUES
(3, 'as', 'as', 'asas', 'as', '2022-06-15', 'El envio tiene un costo de: 1250', 'El total de su compra es: 13750'),
(4, '1005866602', 'gus', 'cra1b1#70-26', '313131313', '2022-06-15', 'El envio tiene un costo de: 2550', 'El total de su compra es: 28050');

-- --------------------------------------------------------

--
-- Table structure for table `productos`
--

CREATE TABLE `productos` (
  `Identificador` int(50) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Precio` varchar(50) NOT NULL,
  `Descripcion` varchar(500) NOT NULL,
  `Estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `productos`
--

INSERT INTO `productos` (`Identificador`, `Nombre`, `Precio`, `Descripcion`, `Estado`) VALUES
(1, 'Spaguetis', '2000', '500 G', 'Activo'),
(2, 'Pendientes Falsos', '4000', 'pendientes magnéticos falsos no perforantes Accesorios de moda para mujeres y hombres, Solo 1.', 'Activa'),
(3, 'Soporte de mentón para casco de motocicleta', '12000', 'Soporte de mentón para casco de motocicleta Soporte de montaje para cámara deportiva Accesorio de soporte de cara completa', 'Activa'),
(4, 'Llevaro de los siete pecados capitales', '8000', 'LLavero de los siete pecados capitales, hacha de escarno rittha', 'Activa'),
(5, 'Guantes para moto', '200000', 'Protege tus manos del viento y la lluvia, además, el tratamiento artificial especial mantiene tus manos cómodas. Es un guante de protección profesional para motociclistas', 'Eliminado'),
(6, 'Funda de teléfono a prueba de golpes', '13000', 'Funda de teléfono a prueba de golpes con protección de lente para Samsung Galaxy S21 Ultra con soporte de anillo magnético de Metal', 'Eliminado'),
(7, 'Pato Amarillo', '2500', 'Pequeño Pato Amarillo, perfecto para acomparte en la ducha.', 'Activa'),
(8, 'Cable cargador de teléfono', '2000', 'Cable cargador de teléfono de nailon. Cable de carga Micro USB tipo C', 'Activa'),
(9, 'Collar', '2500', 'Collar colgante de cruz vintage. Collar de acero inoxidable ', 'Activa'),
(10, 'Ratón óptico inalámbrico', '16500', 'Ratón óptico inalámbrico de 2,4 GHz para juegos para PC, ordenador portátil, receptor USB', 'Activa'),
(11, 'Audifonos', '10500', 'Audifonos inalambricos.', 'Activo');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `Identificador` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `Documento` varchar(11) NOT NULL,
  `Telefono` varchar(11) NOT NULL,
  `Correo` varchar(60) NOT NULL,
  `TipoDeUsuario` varchar(30) NOT NULL,
  `Contraseña` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`Identificador`, `Nombre`, `Apellido`, `Documento`, `Telefono`, `Correo`, `TipoDeUsuario`, `Contraseña`) VALUES
(2, 'Wilson David ', 'Gomez Gomez ', '1193399254', '3053764625', 'wilson.david.gomez@correounivalle.edu.co ', 'Administrador', '321654'),
(3, 'Jose', 'Vanegas', '1005588866', '4879411', 'jose.vanegas@yahoo.com', 'Cliente', 'jose123'),
(5, 'Jose Marin', 'Lopez Lopez', '1122334455', '313313313', 'joselopez@yahoo.com', 'Administrador ', 'jose'),
(8, 'Dennis', 'Ibarguen', '1120568969', '3152374841 ', 'denns18@hotmail.com', 'Cliente', 'denns'),
(9, 'Pedro', 'Quiñones', '1089543105', '3218730425', 'pq@misena.edu.co', 'Cliente', 'pq'),
(11, 'Rudy', 'Hurtado', '19374368', '3215261009 ', 'silguzti@gmail.com', 'Cliente', 'silguzti'),
(12, 'William', 'Londoño', '91259152', '3156779985', 'wilonra@hotmail.com', 'Cliente', 'wilonra'),
(13, 'Ivan', 'Velasquez', '80050872', '3208259077', 'ivanvr80@hotmail.com', 'Cliente', 'ivanvr80'),
(14, 'Moises', 'Rojas', '79708726', '3102151448', 'mrojazar@gmail.com', 'Cliente', 'mrojazar');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `facturas`
--
ALTER TABLE `facturas`
  ADD PRIMARY KEY (`Id_Factura`);

--
-- Indexes for table `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`Identificador`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Identificador`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `facturas`
--
ALTER TABLE `facturas`
  MODIFY `Id_Factura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `productos`
--
ALTER TABLE `productos`
  MODIFY `Identificador` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `Identificador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

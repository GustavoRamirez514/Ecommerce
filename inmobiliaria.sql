-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-11-2021 a las 00:26:15
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inmobiliaria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `Identificador` int(50) NOT NULL,
  `IdInmueble` int(50) NOT NULL,
  `Cliente` varchar(50) NOT NULL,
  `Agente` varchar(50) NOT NULL,
  `Estado` varchar(50) NOT NULL,
  `Fecha` varchar(50) NOT NULL,
  `Observaciones` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`Identificador`, `IdInmueble`, `Cliente`, `Agente`, `Estado`, `Fecha`, `Observaciones`) VALUES
(1, 3, 'Dennis Ibarguen', 'Alex Reyes', 'En Proceso', 'Thu Nov 25 18:02:15 COT 2021', 'Punto de Encuentro: Direccion del inmueble\nHora: 10 am\nTelefono:318875326\nOtros:'),
(2, 16, 'Moises Rojas', 'Alex Reyes', 'Activa', 'Sat Dec 25 18:02:57 COT 2021', 'Punto de Encuentro: no acordado\nHora: 2pm\nTelefono: 3102151448\nOtros:'),
(3, 16, 'Lana Rhoades', 'John Sins1', 'Terminada', 'Sun Nov 14 16:12:26 COT 2021', 'Punto de Encuentro: inmueble \nHora: 10:15pm\nTelefono: 314314314\nOtros: Iran otras dos personas mas'),
(4, 29, 'Ivan Velasquez', 'Lucy Ramirez', 'Activa', 'Mon Feb 28 18:03:59 COT 2022', 'Punto de Encuentro: centro comercial centenario entrada principal\nHora: 8 pm\nTelefono: 3208259077\nOtros: llevar la documentacion necesaria para realizar la compra del inmueble'),
(5, 21, 'Jose Vanegas', 'Lucy Ramirez', 'Activa', 'Sat Nov 27 17:57:41 COT 2021', 'Punto de Encuentro: Direccion del inmueble\nHora: 7:30 am\nTelefono: 4879411\nOtros: Compra inmediata');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inmuebles`
--

CREATE TABLE `inmuebles` (
  `Identificador` int(50) NOT NULL,
  `TipoDeInmueble` varchar(50) NOT NULL,
  `Area` varchar(50) NOT NULL,
  `CantidadDeHabitaciones` varchar(50) NOT NULL,
  `CantidadDeBaños` varchar(50) NOT NULL,
  `CantidadDePisos` varchar(50) NOT NULL,
  `Direccion` varchar(50) NOT NULL,
  `TipoDeProceso` varchar(50) NOT NULL,
  `Precio` varchar(50) NOT NULL,
  `Estado` varchar(50) NOT NULL,
  `Fecha` varchar(50) NOT NULL,
  `AgenteEncargado` varchar(50) NOT NULL,
  `Descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `inmuebles`
--

INSERT INTO `inmuebles` (`Identificador`, `TipoDeInmueble`, `Area`, `CantidadDeHabitaciones`, `CantidadDeBaños`, `CantidadDePisos`, `Direccion`, `TipoDeProceso`, `Precio`, `Estado`, `Fecha`, `AgenteEncargado`, `Descripcion`) VALUES
(3, 'Casa', '12', '5', '7', '6', 'VILLA CAMPESTRE', 'Venta', '$2.450.000.000', 'Activo', 'Fri Nov 05 16:49:38 COT 2021', 'Alex Reyes', 'GARAJE,PISCINA, GARAJE, AIRE ACONDICIONADO, \nAMPLIAS TERRAZAS Y JARDINES'),
(16, 'Apartamento', '90 m2', '3', '2', '2', 'Av. Cr 9 y la Cll 147', 'Alquiler', '$1.800.000', 'Activo', 'Tue Nov 02 16:45:58 COT 2021', 'Alex Reyes', 'el apartamento se ubica en piso 9 en conjunto cerrado, donde tendrás a tu \ndisposición vigilancia 24hrs, piscina, gimnasio, zonas húmedas, terraza \ncon zona BBQ, zona infantil etc.. su excelente ubicación'),
(18, 'Apartamento', '25 m2', '5', '1', '3', ' carrera 4, calle 19', 'Alquiler', '$850.000', 'Activo', 'Wed Nov 03 16:45:04 COT 2021', 'Junior', 'con ascensor de acceso, cuenta con gran área para ubicación de cubículos\n o concepto de oficina'),
(19, 'Lote', '150', '0', '0', '0', 'cra 79-56', 'Venta', '300000', 'Eliminado', 'Tue Nov 30 18:34:05 COT 2021', 'Jorge', 'Lo vendo por motivos personales'),
(20, 'Finca', '170', '6', '4', '2', 'Cl 30 #1615', 'Alquiler', '50000', 'Eliminado', 'Tue Nov 16 15:49:40 COT 2021', 'Wilmar', 'Se alquila finca grande para pasar fines de semana, tiene piscina, mini campo \nde futbol y jacuzzi.'),
(21, 'Apartamento', '72 m2', '2', '2', '1', 'sobre vía ppal Cra 56', 'Venta', '$230.000.000', 'Activo', 'Mon Nov 01 16:45:43 COT 2021', 'Lucy Ramirez', 'SE VENDE Apto cómodo, ventilado e iluminado naturalmente, en excelente \nubicación, ubicado en el edificio Sottomonte en el 2 piso con ascensor'),
(22, 'Apartamento', '50 m2', '3', '1', '1', 'conjunto avellana', 'Venta', '$145.000.000', 'Activo', 'Thu Nov 04 16:41:34 COT 2021', 'Lucy Ramirez', ' el conjunto cuenta con salón comunal, gym, zonas verdes, parques, portería, \nel sector es muy tranquilo'),
(23, 'Casa', '92 m2', '3', '3', '2', 'RIVERA DEL VALLE', 'Venta', '$300.000.000', 'Activo', 'Sat Nov 06 16:53:49 COT 2021', 'Junior', 'En el primer piso consta de cocina integral, sala comedor, zona de oficios, \npatio y parqueadero cubierto, en el segundo piso tres alcobas, cada una \ncon closets, la principal con baño, baño auxiliar y estudio'),
(24, 'Lote', '87 m2', '0', '0', '0', 'MIRAMANGA', 'Venta', '$45.000.000', 'Activo', 'Sun Nov 07 16:57:28 COT 2021', 'Lucy Ramirez', ' IDEAL PARA VIVIENDA'),
(25, 'Finca', '8.183 m2', '10', '8', '1', 'Pance', 'Alquiler', '$12.000.000', 'Activo', 'Mon Nov 08 16:59:35 COT 2021', 'Alex Reyes', 'Si eres amante de la tranquilidad la naturaleza y vivir lejos del ruido de la \nciudad esta Hermosa finca es para ti.  Se alquila hermosa finca capacidad \npara parqueo de 15 carros'),
(26, 'Finca', '3.000 m2', '6', '5', '1', 'pance', 'Alquiler', '$8.600.000', 'Activo', 'Tue Nov 09 17:06:36 COT 2021', 'Junior', 'jacuzzi con excelente vista, amplio baño, Vestier, sala comedor, sala de estar, \ncocina amplia y ventilada con barra salones con sillas capacidad para 118\n personas con baño y parqueadero para mas de 20 vehículos'),
(27, 'Local', '45 m2', '0', '1', '1', 'centro', 'Alquiler', '$1.600.000', 'Activo', 'Wed Nov 10 17:11:43 COT 2021', 'Junior', 'buena iluminación, piso de cerámica,  excelente historial comercial. \nsituada estratégicamente'),
(28, 'Local', '297 m2', '0', '1', '1', 'Pontevedra', 'Alquiler', '$30.000.000', 'Activo', 'Thu Nov 11 17:14:36 COT 2021', 'Alex Reyes', 'pisos de alta resistencia, zona de parqueo frente del local, con ventanales \nen vidrios de alta seguridad, para exhibir vehículos como carros motos'),
(29, 'Local', '211 m2', '1', '2', '2', 'centro Comercial Centenario', 'Venta', '$3.550.000.000', 'Activo', 'Fri Nov 12 17:22:10 COT 2021', 'Lucy Ramirez', 'Conformado por 5 locales en segundo piso, acabados modernos , con mezanine,\nplazoleta de comidas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
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
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Identificador`, `Nombre`, `Apellido`, `Documento`, `Telefono`, `Correo`, `TipoDeUsuario`, `Contraseña`) VALUES
(1, 'Gustavo Adolfo ', 'Ramirez Aponte', '1005866602', '3133158734', 'tavo200079.gr@gmail.com ', 'Agente', '123456'),
(2, 'Wilson David ', 'Gomez Gomez ', '1193399254', '3053764625', 'wilson.david.gomez@correounivalle.edu.co ', 'Administrador', '321654'),
(3, 'Jose', 'Vanegas', '1005588866', '4879411', 'jose.vanegas@yahoo.com', 'Cliente', 'jose123'),
(5, 'Jose Marin', 'Lopez Lopez', '1122334455', '313313313', 'joselopez@yahoo.com', 'Administrador ', 'jose'),
(6, 'Lucy', 'Ramirez', '1116789125', '3188753268 ', 'cide183@gmail.com', 'Agente', 'cide'),
(7, 'Alex', 'Reyes', '1064488437', '3215261009 ', 'kimya@hotmail.com', 'Agente', 'kimya'),
(8, 'Dennis', 'Ibarguen', '1120568969', '3152374841 ', 'denns18@hotmail.com', 'Cliente', 'denns'),
(9, 'Pedro', 'Quiñones', '1089543105', '3218730425', 'pq@misena.edu.co', 'Cliente', 'pq'),
(10, 'Junior ', 'Uribe', '1116789236 ', '3188753268', 'hv71@yahoo.com', 'Agente', 'hv71'),
(11, 'Rudy', 'Hurtado', '19374368', '3215261009 ', 'silguzti@gmail.com', 'Cliente', 'silguzti'),
(12, 'William', 'Londoño', '91259152', '3156779985', 'wilonra@hotmail.com', 'Cliente', 'wilonra'),
(13, 'Ivan', 'Velasquez', '80050872', '3208259077', 'ivanvr80@hotmail.com', 'Cliente', 'ivanvr80'),
(14, 'Moises', 'Rojas', '79708726', '3102151448', 'mrojazar@gmail.com', 'Cliente', 'mrojazar');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`Identificador`);

--
-- Indices de la tabla `inmuebles`
--
ALTER TABLE `inmuebles`
  ADD PRIMARY KEY (`Identificador`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Identificador`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `Identificador` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `inmuebles`
--
ALTER TABLE `inmuebles`
  MODIFY `Identificador` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `Identificador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

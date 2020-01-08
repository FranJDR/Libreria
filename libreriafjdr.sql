-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-12-2019 a las 00:06:48
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `libreriafjdr`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarEditorial` (IN `editorial` VARCHAR(50))  NO SQL
BEGIN
DELETE FROM editorial WHERE editorial.nombre = editorial;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarLibro` (IN `isbn` VARCHAR(13))  NO SQL
BEGIN

DELETE FROM libro WHERE libro.isbn = isbn;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarTema` (IN `tema` VARCHAR(50))  NO SQL
BEGIN
DELETE FROM tema WHERE tema.nombre = tema;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarEditorial` (IN `editorial` VARCHAR(50))  NO SQL
BEGIN
INSERT INTO editorial (editorial.nombre) VALUES (editorial);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarLibro` (IN `isbn` VARCHAR(13), IN `titulo` VARCHAR(50), IN `autor` VARCHAR(50), IN `paginas` VARCHAR(50), IN `idTema` INT(50), IN `idEditorial` INT(50), IN `precio` VARCHAR(50), IN `formato` VARCHAR(50), IN `estado` VARCHAR(50), IN `cantidad` VARCHAR(50))  NO SQL
BEGIN

INSERT INTO libro

(libro.isbn, libro.titulo, libro.autor, libro.paginas, libro.idTema, libro.idEditorial, libro.precio, libro.formato, libro.estado, libro.cantidad) 

VALUES (isbn, titulo, autor, paginas, idTema, idEditorial, precio, formato, estado, cantidad);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarTema` (IN `tema` VARCHAR(50))  NO SQL
BEGIN
INSERT INTO tema (tema.nombre) VALUES (tema);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarCantidad` (IN `isbn` VARCHAR(13), IN `cantidad` INT)  NO SQL
BEGIN

UPDATE libro SET libro.cantidad = cantidad WHERE libro.isbn = isbn;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarPrecio` (IN `isbn` VARCHAR(13), IN `precio` VARCHAR(50))  NO SQL
BEGIN

UPDATE libro SET libro.precio = precio WHERE libro.isbn = isbn;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerTablaHistorico` (OUT `retorno` VARCHAR(10000))  NO SQL
BEGIN
declare isbn VARCHAR(13) default '';
declare operacion VARCHAR(50) default '';
declare fecha timestamp;

DECLARE cursor_format CURSOR FOR SELECT * FROM historico WHERE  1;

DECLARE CONTINUE HANDLER FOR NOT FOUND SET @finCursor = false;

set retorno = '';
open cursor_format;

set @finCursor = true;
FETCH cursor_format INTO isbn, operacion, fecha;

while @finCursor DO
    set retorno = concat(retorno, "/", isbn, ",", operacion, ",", fecha );
    FETCH cursor_format INTO isbn, operacion, fecha;
END WHILE;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editorial`
--

CREATE TABLE `editorial` (
  `idEditorial` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `editorial`
--

INSERT INTO `editorial` (`idEditorial`, `nombre`) VALUES
(1, 'Blackie Books'),
(2, 'Impedimenta'),
(3, 'Malpaso'),
(4, 'Nordica'),
(5, 'La Señora Dalloway'),
(6, 'Austral'),
(7, 'Santillana');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historico`
--

CREATE TABLE `historico` (
  `isbn` varchar(13) COLLATE utf8_spanish_ci NOT NULL,
  `operacion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `historico`
--

INSERT INTO `historico` (`isbn`, `operacion`, `fecha`) VALUES
('2362562456462', 'Se registro este libro', '2019-12-13 07:38:08'),
('2362562456462', 'Se modifico el libro', '2019-12-13 07:41:21'),
('2362562456462', 'Se elimino es libro', '2019-12-13 07:44:04'),
('2409568034956', 'Se elimino es libro', '2019-12-13 11:55:12'),
('1456456342522', 'Se modifico el libro', '2019-12-13 12:26:59'),
('1456456342522', 'Se modifico el libro', '2019-12-13 12:27:03'),
('1456456342522', 'Se modifico el libro', '2019-12-13 12:31:14'),
('1456456342522', 'Se modifico el libro', '2019-12-13 12:31:45'),
('1456456342522', 'Se modifico el libro', '2019-12-13 12:33:20'),
('1456456342522', 'Se modifico el libro', '2019-12-13 12:35:58'),
('1456456342522', 'Se modifico el libro', '2019-12-13 12:36:04'),
('4563235425634', 'Se modifico el libro', '2019-12-13 12:37:59'),
('3598674851245', 'Se modifico el libro', '2019-12-13 12:40:51'),
('3598674851245', 'Se modifico el libro', '2019-12-13 12:40:58'),
('2037503425723', 'Se registro este libro', '2019-12-17 12:46:52'),
('2037503425723', 'Se elimino es libro', '2019-12-17 12:50:55');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `isbn` varchar(13) COLLATE utf8_spanish_ci NOT NULL,
  `titulo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `autor` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `paginas` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `idTema` int(100) NOT NULL,
  `idEditorial` int(11) NOT NULL,
  `precio` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `formato` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `cantidad` varchar(11) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`isbn`, `titulo`, `autor`, `paginas`, `idTema`, `idEditorial`, `precio`, `formato`, `estado`, `cantidad`) VALUES
('1456456342522', 'La sospecha de Sofia', 'Paloma Sanchez', '334', 9, 6, '50', 'Novedad', 'Rustica', '85'),
('2485754744135', 'Diario de Ana Frank', 'Anna Frank', '217', 5, 1, '60', 'Digital', 'Reedicion', '65'),
('3485724695845', 'Harry Potter', 'J.K. Rowling', '3665', 3, 7, '25', 'Rustica', 'Novedad', '40'),
('3598674851245', 'El alquimista', 'Paulo Coelho', '500', 3, 2, '13', 'Digital', 'Novedad', '30'),
('4563235425634', 'El latido de la tierra', 'Luz Gabas', '448', 8, 4, '20', 'Reedicion', 'Cartone', '50'),
('5487316958246', 'El Señor de los Anillos', 'J.R.R. Tolkien', '1368', 2, 5, '32', 'Rustica', 'Reedicion', '25'),
('7168582554968', 'Lo que el viento se llevó', 'Margaret Mitchell', '1037', 3, 3, '24', 'Cartone', 'Reedicion', '25'),
('9758428167354', 'El código Da Vinci', 'Dan Brown', '1200', 9, 3, '18', 'Cartone', 'Reedicion', '35'),
('9848914561651', 'Vigilancia permanente', 'Edward Snowden', '448', 7, 5, '100', 'Novedad', 'Rustica', '50');

--
-- Disparadores `libro`
--
DELIMITER $$
CREATE TRIGGER `libroAI` AFTER INSERT ON `libro` FOR EACH ROW BEGIN

INSERT INTO historico (historico.isbn, historico.operacion) 
VALUES (new.isbn, "Se registro este libro");

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `libroAU` AFTER UPDATE ON `libro` FOR EACH ROW BEGIN

INSERT INTO historico (historico.isbn , historico.operacion) 
VALUES (old.isbn, "Se modifico el libro");

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `libroBD` BEFORE DELETE ON `libro` FOR EACH ROW BEGIN

INSERT INTO historico (historico.isbn, historico.operacion) 
VALUES (old.isbn , "Se elimino es libro");

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tema`
--

CREATE TABLE `tema` (
  `idTema` int(11) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tema`
--

INSERT INTO `tema` (`idTema`, `nombre`) VALUES
(1, 'Ciencia'),
(2, 'Economia'),
(3, 'Fantasia'),
(4, 'Ficcion'),
(5, 'Historia'),
(6, 'Misterio'),
(7, 'Novela'),
(8, 'Poesia'),
(9, 'Psicologia'),
(10, 'Autobiografía'),
(11, 'Comedia');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `editorial`
--
ALTER TABLE `editorial`
  ADD PRIMARY KEY (`idEditorial`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`isbn`),
  ADD KEY `idTema` (`idTema`),
  ADD KEY `idEditorial` (`idEditorial`);

--
-- Indices de la tabla `tema`
--
ALTER TABLE `tema`
  ADD PRIMARY KEY (`idTema`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `editorial`
--
ALTER TABLE `editorial`
  MODIFY `idEditorial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tema`
--
ALTER TABLE `tema`
  MODIFY `idTema` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`idTema`) REFERENCES `tema` (`idTema`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `libro_ibfk_2` FOREIGN KEY (`idEditorial`) REFERENCES `editorial` (`idEditorial`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

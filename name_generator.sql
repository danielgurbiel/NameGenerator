-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 09 Mar 2018, 21:15
-- Wersja serwera: 10.1.21-MariaDB
-- Wersja PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `name_generator`
--

-- --------------------------------------------------------

--
-- Zastąpiona struktura widoku `men`
-- (See below for the actual view)
--
CREATE TABLE `men` (
`name` varchar(25)
);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `names`
--

CREATE TABLE `names` (
  `id` int(11) NOT NULL,
  `name` varchar(25) COLLATE cp1250_polish_ci NOT NULL,
  `sex` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_polish_ci;

--
-- Zrzut danych tabeli `names`
--

INSERT INTO `names` (`id`, `name`, `sex`) VALUES
(1, 'Daniel', 1),
(2, 'Donata', 0),
(3, 'Maciej', 1),
(4, 'Klaudia', 0),
(5, 'Dominik', 1),
(6, 'Filip', 1),
(7, 'Iwona', 0),
(8, 'Lech', 1),
(9, 'Brygida', 0),
(10, 'Robert', 1),
(11, 'Mateusz', 1),
(12, 'Adrian', 1),
(13, 'Krystian', 1),
(14, 'Daniel', 1),
(15, 'Klaudiusz', 1),
(22, 'Monika', 0),
(23, 'Jan', 1),
(24, 'Krzysztof', 1),
(25, 'Krystyna', 0),
(26, 'Bogdan', 1),
(28, 'Joanna', 0),
(29, 'Franciszek', 1),
(30, 'Karolina', 0),
(31, 'Anna', 0),
(32, 'Nikodem', 1),
(33, 'Edward', 1),
(34, 'Narcyz', 1),
(35, 'Kamil', 1),
(36, 'Robert', 1),
(37, 'Marian', 1),
(40, 'Grzegorz', 1),
(41, 'Norbert', 1),
(42, 'Klaudia', 0);

-- --------------------------------------------------------

--
-- Zastąpiona struktura widoku `women`
-- (See below for the actual view)
--
CREATE TABLE `women` (
`name` varchar(25)
);

-- --------------------------------------------------------

--
-- Zastąpiona struktura widoku `_all`
-- (See below for the actual view)
--
CREATE TABLE `_all` (
`name` varchar(25)
);

-- --------------------------------------------------------

--
-- Struktura widoku `men`
--
DROP TABLE IF EXISTS `men`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `men`  AS  select distinct `names`.`name` AS `name` from `names` where (`names`.`sex` = 1) ;

-- --------------------------------------------------------

--
-- Struktura widoku `women`
--
DROP TABLE IF EXISTS `women`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `women`  AS  select distinct `names`.`name` AS `name` from `names` where (`names`.`sex` = 0) ;

-- --------------------------------------------------------

--
-- Struktura widoku `_all`
--
DROP TABLE IF EXISTS `_all`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `_all`  AS  select distinct `names`.`name` AS `name` from `names` ;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `names`
--
ALTER TABLE `names`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `names`
--
ALTER TABLE `names`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Wrz 06, 2023 at 03:44 PM
-- Wersja serwera: 10.4.28-MariaDB
-- Wersja PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `saper`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ranking`
--

CREATE TABLE `ranking` (
  `ID` int(11) NOT NULL,
  `nick` text NOT NULL,
  `wynik` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ranking`
--

INSERT INTO `ranking` (`ID`, `nick`, `wynik`) VALUES
(1, 'Janek', 123),
(2, 'Liniasty', 31),
(3, 'Trololak', 32),
(4, 'Karol', 17),
(5, 'Kuba', 17),
(6, 'Antoni', 20);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `ranking`
--
ALTER TABLE `ranking`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `nick` (`nick`) USING HASH;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ranking`
--
ALTER TABLE `ranking`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

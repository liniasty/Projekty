-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 27 Mar 2023, 18:41
-- Wersja serwera: 10.4.27-MariaDB
-- Wersja PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `04_blaszczyk`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `sportowcy`
--

CREATE TABLE `sportowcy` (
  `id` int(11) NOT NULL,
  `imie` text NOT NULL,
  `nazwisko` text NOT NULL,
  `typSportu` text NOT NULL,
  `Sport` text NOT NULL,
  `wygrane` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `sportowcy`
--

INSERT INTO `sportowcy` (`id`, `imie`, `nazwisko`, `typSportu`, `Sport`, `wygrane`) VALUES
(1, 'Marcin', 'Lewandowski', 'A', 'Lekkoatletyka', 5),
(2, 'Kamil', 'Stoch', 'B', 'Skoki narciarskie', 3),
(3, 'Krzysztof', 'Włodarczyk', 'C', 'Boks', 16),
(4, 'Michał', 'Kwiatkowski', 'A', 'Kolarstwo', 7),
(5, 'Robert', 'Kubica', 'C', 'Rajdy', 25),
(6, 'Agnieszka', 'Radwańska', 'A', 'Tenis', 8),
(7, 'Bartosz', 'Kurek', 'C', 'Siatkówka', 2),
(8, 'Robert', 'Lewandowski', 'A', 'Piłka nożna', 12),
(9, 'Piotr ', 'Żyła', 'B', 'Skoki Narciaskie', 6),
(10, 'Anita', 'Włodarczyk', 'A', 'Rzut Młotem', 10),
(11, 'Jan', 'Kowalski', 'C', 'Piłka nożna', 14),
(12, 'Jan', 'Maleszka', 'A', 'golf', 15);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `typysportu`
--

CREATE TABLE `typysportu` (
  `idSportu` char(1) NOT NULL,
  `typ` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `typysportu`
--

INSERT INTO `typysportu` (`idSportu`, `typ`) VALUES
('A', 'Letni'),
('B', 'Zimowy'),
('C', 'całorczny');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `sportowcy`
--
ALTER TABLE `sportowcy`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `sportowcy`
--
ALTER TABLE `sportowcy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

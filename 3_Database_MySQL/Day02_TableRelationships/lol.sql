-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 14, 2022 at 01:55 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lol`
--

-- --------------------------------------------------------

--
-- Table structure for table `costume_line`
--

CREATE TABLE `costume_line` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `create_at` date NOT NULL,
  `day_buy` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `costume_line`
--

INSERT INTO `costume_line` (`id`, `name`, `create_at`, `day_buy`) VALUES
(1, 'Line 1', '2022-09-01', '2022-09-15'),
(2, 'Line 2', '2022-09-02', '2022-09-15'),
(3, 'Line 3', '2022-09-03', '2022-09-14'),
(4, 'Line 4', '2022-09-04', '2022-09-15');

-- --------------------------------------------------------

--
-- Table structure for table `costume_line_fingure`
--

CREATE TABLE `costume_line_fingure` (
  `id` int(11) NOT NULL,
  `costume_line_id` int(11) DEFAULT NULL,
  `fingure_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `costume_line_fingure`
--

INSERT INTO `costume_line_fingure` (`id`, `costume_line_id`, `fingure_id`) VALUES
(1, 1, 3),
(2, 1, 1),
(3, 2, 2),
(4, 2, 4);

-- --------------------------------------------------------

--
-- Table structure for table `fingure`
--

CREATE TABLE `fingure` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `Combo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fingure`
--

INSERT INTO `fingure` (`id`, `name`, `Combo`) VALUES
(1, 'Yasua', 'Flash + Ctrl 6'),
(2, 'Kathur', 'Die + R'),
(3, 'Yone', ' Q + Q + W'),
(4, 'Teemo', 'Only R');

-- --------------------------------------------------------

--
-- Table structure for table `skin`
--

CREATE TABLE `skin` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `limited` tinyint(1) NOT NULL,
  `type_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `skin`
--

INSERT INTO `skin` (`id`, `name`, `price`, `limited`, `type_id`) VALUES
(1, 'Yasua ma kiem', 599, 0, 1),
(2, 'Yone ba vuong hv chien binh', 369, 0, 1),
(3, 'lux vu khi toi thuong', 999, 1, 3),
(4, 'Kathur than chet', 120, 0, 4),
(5, 'Teemo sieu nhan', 180, 0, 2);

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE `type` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `color` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`id`, `name`, `color`) VALUES
(1, 'Huyen thoai', 'Red'),
(2, 'Su thi', 'Blue'),
(3, 'Toi thuong', 'Yellow'),
(4, 'Normal', 'Silver');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `costume_line`
--
ALTER TABLE `costume_line`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `costume_line_fingure`
--
ALTER TABLE `costume_line_fingure`
  ADD PRIMARY KEY (`id`),
  ADD KEY `costume_line_id` (`costume_line_id`),
  ADD KEY `fingure_id` (`fingure_id`);

--
-- Indexes for table `fingure`
--
ALTER TABLE `fingure`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `skin`
--
ALTER TABLE `skin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `skin_type_id_fk` (`type_id`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `costume_line`
--
ALTER TABLE `costume_line`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `costume_line_fingure`
--
ALTER TABLE `costume_line_fingure`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `fingure`
--
ALTER TABLE `fingure`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `skin`
--
ALTER TABLE `skin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `costume_line_fingure`
--
ALTER TABLE `costume_line_fingure`
  ADD CONSTRAINT `costume_line_fingure_ibfk_1` FOREIGN KEY (`costume_line_id`) REFERENCES `costume_line` (`id`),
  ADD CONSTRAINT `costume_line_fingure_ibfk_2` FOREIGN KEY (`fingure_id`) REFERENCES `fingure` (`id`);

--
-- Constraints for table `skin`
--
ALTER TABLE `skin`
  ADD CONSTRAINT `skin_type_id_fk` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

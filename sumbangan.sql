-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 07, 2020 at 08:26 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sumbangan`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_duka`
--

CREATE TABLE `data_duka` (
  `cabang` varchar(4) NOT NULL,
  `nik` int(10) NOT NULL,
  `nama` varchar(36) NOT NULL,
  `jc` varchar(2) NOT NULL,
  `norek` int(10) NOT NULL,
  `jml` int(6) NOT NULL,
  `tgl_meninggal` date NOT NULL,
  `tgl_dibuat` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_duka`
--

INSERT INTO `data_duka` (`cabang`, `nik`, `nama`, `jc`, `norek`, `jml`, `tgl_meninggal`, `tgl_dibuat`) VALUES
('KRW', 2015023155, 'CONTOH', 'B3', 1234567899, 750000, '2020-10-08', '2020-10-09');

-- --------------------------------------------------------

--
-- Table structure for table `data_nikah`
--

CREATE TABLE `data_nikah` (
  `cabang` varchar(4) NOT NULL,
  `nik` int(10) NOT NULL,
  `nama` varchar(36) NOT NULL,
  `jc` varchar(2) NOT NULL,
  `norek` int(10) NOT NULL,
  `jml` int(6) NOT NULL,
  `tgl_nikah` date DEFAULT NULL,
  `tgl_dibuat` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_nikah`
--

INSERT INTO `data_nikah` (`cabang`, `nik`, `nama`, `jc`, `norek`, `jml`, `tgl_nikah`, `tgl_dibuat`) VALUES
('KMY', 2015023150, 'SIGIT MAULANA', 'B3', 1234567899, 750000, '2020-10-01', '2020-10-20'),
('TGR', 2015023153, 'SIGIT MAULANA', 'B1', 1234567899, 750000, '2020-10-01', '2020-10-02');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_duka`
--
ALTER TABLE `data_duka`
  ADD PRIMARY KEY (`nik`);

--
-- Indexes for table `data_nikah`
--
ALTER TABLE `data_nikah`
  ADD PRIMARY KEY (`nik`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

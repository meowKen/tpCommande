-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 08 mai 2018 à 18:41
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tpcomm`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `id_art` int(11) NOT NULL AUTO_INCREMENT,
  `ref_art` varchar(50) NOT NULL,
  `nom_art` varchar(50) NOT NULL,
  `prix_art` float NOT NULL,
  `qte_art` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_art`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`id_art`, `ref_art`, `nom_art`, `prix_art`, `qte_art`) VALUES
(1, 'ref12mbonACL', 'jambon', 1.89, NULL),
(2, 'ref24settesACL', 'noisettes', 4.7, NULL),
(3, 'ref252apeauACL', 'chapeau', 25.5, NULL),
(4, 'ref00ommeACL', 'pomme', 0.97, NULL),
(5, 'ref02ainACL', 'pain', 1.23, NULL),
(6, 'ref02396visionTVACL', 'televisionTV', 1198.99, NULL),
(7, 'ref0130ussureACL', 'chaussure', 65, NULL),
(8, 'ref0134000teauACL', 'bateau', 67000, NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

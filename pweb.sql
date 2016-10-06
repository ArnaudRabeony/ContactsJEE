-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Ven 07 Octobre 2016 à 00:10
-- Version du serveur :  5.7.15-0ubuntu0.16.04.1
-- Version de PHP :  7.0.8-0ubuntu0.16.04.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pweb`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `idAdresse` int(11) NOT NULL,
  `rue` varchar(60) NOT NULL,
  `ville` varchar(30) NOT NULL,
  `codePostal` varchar(10) NOT NULL,
  `pays` varchar(30) NOT NULL,
  `idContact` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `adresse`
--

INSERT INTO `adresse` (`idAdresse`, `rue`, `ville`, `codePostal`, `pays`, `idContact`) VALUES
(3, '32 Avenue Maurice Noguès', 'Athis-Mons', '91200', 'France', 10),
(4, '422 Avenue PoincarÃ©', 'Vlr', '94290', 'France', 10),
(5, 'ok ok', 'ok', 'ok', 'ok', 11),
(6, 'nouvelleAdresse eara', 'eaze', 'zaea', 'ezaeaz', 10);

-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

CREATE TABLE `contact` (
  `idContact` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `idGroupe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `contact`
--

INSERT INTO `contact` (`idContact`, `nom`, `prenom`, `email`, `idGroupe`) VALUES
(5, 'testNomm', 'testPrenomm', 'testEmailll', 10),
(6, 'Fring', 'Gustavo', 'gustavo@g.c', 0),
(10, 'White', 'Walter', 'teste', 11),
(11, 'Pinkman', 'Jesse', 'ok', 11);

-- --------------------------------------------------------

--
-- Structure de la table `contacts`
--

CREATE TABLE `contacts` (
  `ID_CONTACT` bigint(20) NOT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `LASTNAME` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `contacts`
--

INSERT INTO `contacts` (`ID_CONTACT`, `FIRSTNAME`, `LASTNAME`, `EMAIL`) VALUES
(1, 'Rabeony', 'Arnaud', 'ar_rabeony@hotmail.fr');

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

CREATE TABLE `groupe` (
  `idGroupe` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `groupe`
--

INSERT INTO `groupe` (`idGroupe`, `nom`) VALUES
(10, 'Nouveau groupe'),
(11, 'z');

-- --------------------------------------------------------

--
-- Structure de la table `telephone`
--

CREATE TABLE `telephone` (
  `idTelephone` int(11) NOT NULL,
  `type` varchar(20) NOT NULL,
  `numero` varchar(20) NOT NULL,
  `idContact` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `telephone`
--

INSERT INTO `telephone` (`idTelephone`, `type`, `numero`, `idContact`) VALUES
(3, 'pro', '0456124789', 0),
(4, 'perso', '0123456789', 10),
(5, 'pro', '06123456789', 10);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`idAdresse`);

--
-- Index pour la table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`idContact`),
  ADD UNIQUE KEY `id` (`idContact`);

--
-- Index pour la table `contacts`
--
ALTER TABLE `contacts`
  ADD PRIMARY KEY (`ID_CONTACT`);

--
-- Index pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD PRIMARY KEY (`idGroupe`);

--
-- Index pour la table `telephone`
--
ALTER TABLE `telephone`
  ADD PRIMARY KEY (`idTelephone`),
  ADD KEY `fk_contact_id` (`idContact`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `adresse`
--
ALTER TABLE `adresse`
  MODIFY `idAdresse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `contact`
--
ALTER TABLE `contact`
  MODIFY `idContact` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT pour la table `contacts`
--
ALTER TABLE `contacts`
  MODIFY `ID_CONTACT` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `groupe`
--
ALTER TABLE `groupe`
  MODIFY `idGroupe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT pour la table `telephone`
--
ALTER TABLE `telephone`
  MODIFY `idTelephone` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

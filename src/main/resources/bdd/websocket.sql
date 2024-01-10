-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 10 jan. 2024 à 13:36
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `websocket`
--
CREATE DATABASE IF NOT EXISTS `websocket` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `websocket`;

-- --------------------------------------------------------

--
-- Structure de la table `temperatures`
--

CREATE TABLE `temperatures` (
  `id` int(11) NOT NULL,
  `horodatage` datetime NOT NULL DEFAULT current_timestamp(),
  `temp` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `valeurs`
--

CREATE TABLE `valeurs` (
  `id` int(11) NOT NULL,
  `valeur1` int(11) NOT NULL DEFAULT 0,
  `valeur2` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `valeurs`
--

INSERT INTO `valeurs` (`id`, `valeur1`, `valeur2`) VALUES
(1, 1, 15),
(2, 2, 22),
(3, 3, 33);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `temperatures`
--
ALTER TABLE `temperatures`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `valeurs`
--
ALTER TABLE `valeurs`
  ADD KEY `Index 1` (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `temperatures`
--
ALTER TABLE `temperatures`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `valeurs`
--
ALTER TABLE `valeurs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

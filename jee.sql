-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 17 mars 2020 à 14:46
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `jee`
--

-- --------------------------------------------------------

--
-- Structure de la table `document`
--

DROP TABLE IF EXISTS `document`;
CREATE TABLE IF NOT EXISTS `document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(64) NOT NULL,
  `auteur` varchar(30) NOT NULL,
  `disponible` int(1) NOT NULL DEFAULT '0',
  `couverture` varchar(256) NOT NULL,
  `statut` varchar(20) NOT NULL,
  `pseudo` varchar(30) NOT NULL DEFAULT 'default',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `document`
--

INSERT INTO `document` (`id`, `titre`, `auteur`, `disponible`, `couverture`, `statut`, `pseudo`) VALUES
(2, 'Harry Potter à l école des Sorciers', 'J.K. Rowling', 0, 'https://static.fnac-static.com/multimedia/Images/FR/NR/ba/d8/1d/1956026/1507-1/tsp20180921093018/Harry-Potter-a-l-ecole-des-sorciers.jpg', 'Livre', 'default'),
(3, 'Harry Potter et la Chambre des Secrets', 'J.K. Rowling', 0, 'https://images-na.ssl-images-amazon.com/images/I/91OSvPibmJL.jpg', 'Livre', 'default'),
(4, 'Harry Potter et le Prisonnier d\'Azkhaban', 'J.K. Rowling', 0, 'https://images-na.ssl-images-amazon.com/images/I/51oBllyxx%2BL._SX342_BO1,204,203,200_.jpg', 'Livre', 'default'),
(5, 'Harry Potter et la Coupe de Feu', 'J.K. Rowling', 0, 'https://images.epagine.fr/553/9782070624553_1_75.jpg', 'Livre', 'default'),
(6, 'Harry Potter et l\\\'Ordre du Phoenix', 'J.K. Rowling', 0, 'https://m.media-amazon.com/images/I/61AP-3Mx0ZL._SL500_.jpg', 'Livre', 'default'),
(7, 'Harry Potter et le Prince de Sang-mêlé', 'J.K. Rowling', 0, 'https://m.media-amazon.com/images/I/61aAhrzQOxL._SL500_.jpg', 'Livre', 'default'),
(8, 'Harry Potter et les Reliques de la Mort', 'J.K. Rowling', 0, 'https://images-na.ssl-images-amazon.com/images/I/A15l3gP3RDL.jpg', 'Livre', 'default'),
(9, 'Inglorious Basterds', 'Quentin Tarentino', 0, 'https://fr.web.img2.acsta.net/medias/nmedia/18/70/45/22/19123474.jpg', 'DVD', 'default'),
(10, 'Joker', 'Todd Phillips', 0, 'https://legrandcontinent.eu/fr/wp-content/uploads/sites/2/2019/10/MV5BNGVjNWI4ZGUtNzE0MS00YTJmLWE0ZDctN2ZiYTk2YmI3NTYyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg', 'DVD', 'default'),
(11, 'The Dark Knight', 'Christopher Nolan', 0, 'https://img01.mgo-images.com/image/thumbnail/v2/content/1MV3625835fdea89978e1a59cd33bc357e9.jpeg', 'DVD', 'default'),
(12, 'Inception', 'Christopher Nolan', 0, 'https://img.over-blog-kiwi.com/0/66/79/72/20150125/ob_2485e6_inception-7205.jpg', 'DVD', 'default'),
(13, '1917', 'Sam Mendes', 0, 'https://www.cinechronicle.com/wp-content/uploads/2020/01/1917-affiche.jpg', 'DVD', 'default'),
(14, 'Very Bad Trip 3', 'Todd Phillips', 0, 'https://fr.web.img6.acsta.net/pictures/210/080/21008070_20130524113929346.jpg', 'DVD', 'default'),
(15, 'OSS 117 : Rio ne répond plus', 'Michel Hazanavicus', 0, 'https://fr.web.img4.acsta.net/medias/nmedia/18/67/41/85/19057747.jpg', 'DVD', 'default');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `pseudo` varchar(30) NOT NULL,
  `motdepasse` varchar(64) NOT NULL,
  `statut` varchar(30) NOT NULL,
  PRIMARY KEY (`pseudo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`pseudo`, `motdepasse`, `statut`) VALUES
('victor', 'truong', 'abonne'),
('cusin', 'cusin', 'abonne'),
('oui', 'non', 'bibliothecaire'),
('default', 'default', 'default');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

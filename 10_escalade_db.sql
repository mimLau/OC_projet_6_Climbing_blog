CREATE DATABASE  IF NOT EXISTS `escalade_db` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `escalade_db`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: escalade_db
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `id` bigint(20) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `topo_id` bigint(20) DEFAULT NULL,
  `userRequest_userId` bigint(20) DEFAULT NULL,
  `userLender_userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK33e2qqvwsqrjkbjdj2ccaj7pu` (`topo_id`),
  KEY `FKbpmegm44xqi9gs947kjvgqc5r` (`userRequest_userId`),
  KEY `FKk0wyoe32iusa8bbifmrhqc9fw` (`userLender_userId`),
  CONSTRAINT `FK33e2qqvwsqrjkbjdj2ccaj7pu` FOREIGN KEY (`topo_id`) REFERENCES `topos` (`id`),
  CONSTRAINT `FKbpmegm44xqi9gs947kjvgqc5r` FOREIGN KEY (`userRequest_userId`) REFERENCES `users` (`userId`),
  CONSTRAINT `FKk0wyoe32iusa8bbifmrhqc9fw` FOREIGN KEY (`userLender_userId`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contents` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `user_fk` bigint(20) DEFAULT NULL,
  `site_fk` bigint(20) DEFAULT NULL,
  `answer_comment_fk` bigint(20) DEFAULT NULL,
  `edited` bit(1) NOT NULL,
  `editedDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK75oyim5armik76ayyoarahwdd` (`user_fk`),
  KEY `FK166fstimqfa44pw2cqs5a6gjt` (`site_fk`),
  KEY `FKrc6woccq4usmcaafqnh3t5pnh` (`answer_comment_fk`),
  CONSTRAINT `FK166fstimqfa44pw2cqs5a6gjt` FOREIGN KEY (`site_fk`) REFERENCES `sites` (`id`),
  CONSTRAINT `FK75oyim5armik76ayyoarahwdd` FOREIGN KEY (`user_fk`) REFERENCES `users` (`userId`),
  CONSTRAINT `FKrc6woccq4usmcaafqnh3t5pnh` FOREIGN KEY (`answer_comment_fk`) REFERENCES `comments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lengths`
--

DROP TABLE IF EXISTS `lengths`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lengths` (
  `id` bigint(20) NOT NULL,
  `length` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rating` varchar(255) DEFAULT NULL,
  `way_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `places`
--

DROP TABLE IF EXISTS `places`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `places` (
  `id` bigint(20) NOT NULL,
  `country` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sectors`
--

DROP TABLE IF EXISTS `sectors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sectors` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nbOfWays` int(11) NOT NULL,
  `site_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrsvrm484ii8xhmhxi2wieqv90` (`site_fk`),
  CONSTRAINT `FKrsvrm484ii8xhmhxi2wieqv90` FOREIGN KEY (`site_fk`) REFERENCES `sites` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sites`
--

DROP TABLE IF EXISTS `sites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sites` (
  `id` bigint(20) NOT NULL,
  `description` text,
  `tagged` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nbOfSectors` int(11) NOT NULL,
  `place_fk` bigint(20) DEFAULT NULL,
  `user_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlrfgc3gsfboomy3i60kipbw4u` (`place_fk`),
  KEY `FK44maunek6nsf2o0xagsh05d22` (`user_fk`),
  CONSTRAINT `FK44maunek6nsf2o0xagsh05d22` FOREIGN KEY (`user_fk`) REFERENCES `users` (`userId`),
  CONSTRAINT `FKlrfgc3gsfboomy3i60kipbw4u` FOREIGN KEY (`place_fk`) REFERENCES `places` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `topos`
--

DROP TABLE IF EXISTS `topos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topos` (
  `id` bigint(20) NOT NULL,
  `borrowed` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `releaseDate` varchar(255) DEFAULT NULL,
  `user_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqdcux988ykp5rojyw07o5a19c` (`user_fk`),
  CONSTRAINT `FKqdcux988ykp5rojyw07o5a19c` FOREIGN KEY (`user_fk`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `userId` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `nbOfConnections` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ways`
--

DROP TABLE IF EXISTS `ways`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ways` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `length` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nbOfLengths` int(11) NOT NULL,
  `sector_fk` int(11) DEFAULT NULL,
  `rating` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkkd1u0xv18yif1xfrihrq8hb6` (`sector_fk`),
  CONSTRAINT `FKkkd1u0xv18yif1xfrihrq8hb6` FOREIGN KEY (`sector_fk`) REFERENCES `sectors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'escalade_db'
--

--
-- Dumping routines for database 'escalade_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-14 22:45:06

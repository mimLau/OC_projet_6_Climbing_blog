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
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (83,'EXPIRED',67,1,2),(84,'EXPIRED',67,3,2),(85,'EXPIRED',68,2,1),(86,'EXPIRED',68,3,1),(88,'EXPIRED',68,87,1),(89,'ACCEPTED',70,1,3),(95,'EXPIRED',69,1,2),(115,'IN_PROGRESS',68,2,1),(119,'IN_PROGRESS',67,1,2);
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (49,'test','19 déc. 2019 à 20:32:43',1,31,NULL,_binary '\0',NULL),(50,'df','19 déc. 2019 à 20:35:32',1,31,NULL,_binary '\0',NULL),(51,' as\r\n\r\nTest edition','19 déc. 2019 à 21:47:34',1,18,NULL,_binary '','7 janv. 2020 à 14:20:38'),(65,' edit\r\nrajout','23 déc.2019 à 17:20:41',1,17,NULL,_binary '','24 déc. 2020 à 16:16:28'),(71,'Test commentaire','24 déc. 2019 à 16:14:21',3,17,NULL,_binary '\0',NULL),(114,'Commentaire','6 janv. 2020 à 23:54:00',2,31,NULL,_binary '\0',NULL),(117,'Je laisse ce commentaire pour informer que j\'ai dÃ©couvert ce site depuis peu et j\'en suis ravie!','7 janv. 2020 à 10:10:14',3,18,NULL,_binary '\0',NULL),(118,'Comm','7 janv. 2020 à 17:26:29',1,116,NULL,_binary '\0',NULL);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (121),(121),(121),(121),(121);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `lengths`
--

LOCK TABLES `lengths` WRITE;
/*!40000 ALTER TABLE `lengths` DISABLE KEYS */;
INSERT INTO `lengths` VALUES (25,234,'Accrue','3a',1),(26,34,'Brute','7b',1),(93,234,'Rocheuse rouge','3',92),(94,45,'Kipp le large','4a',55),(98,45,'Test ','5c',97);
/*!40000 ALTER TABLE `lengths` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `places`
--

LOCK TABLES `places` WRITE;
/*!40000 ALTER TABLE `places` DISABLE KEYS */;
INSERT INTO `places` VALUES (12,'France','Alsace'),(13,'France','Vosges'),(14,'Allemagne','Palatinat'),(15,'Suisse','Jura'),(16,'Suisse','Alpes');
/*!40000 ALTER TABLE `places` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sectors`
--

LOCK TABLES `sectors` WRITE;
/*!40000 ALTER TABLE `sectors` DISABLE KEYS */;
INSERT INTO `sectors` VALUES (20,'La rocheuse',1,17),(21,'Optimal',0,18),(22,'Simple',2,18),(23,'Court',0,18),(29,'Roche de grès',0,17),(54,'Kipp n1',1,30),(90,'Kipp n2',2,30),(96,'Test',1,31);
/*!40000 ALTER TABLE `sectors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sites`
--

LOCK TABLES `sites` WRITE;
/*!40000 ALTER TABLE `sites` DISABLE KEYS */;
INSERT INTO `sites` VALUES (17,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur et facilisis elit, nec viverra eros. Nunc placerat in leo in ullamcorper. Phasellus eu feugiat orci. Donec vitae consequat ante. Cras mattis mauris non nisl sollicitudin, ac aliquet magna finibus. Vestibulum a dui eget elit pulvinar ultricies. Phasellus scelerisque nisi vel dolor scelerisque, vitae sagittis nisl facilisis. Curabitur bibendum justo at libero consequat, nec maximus odio molestie. Nunc auctor gravida mauris id ornare. Nunc quam erat, fringilla vel nisi eu, dignissim luctus est.',_binary '','Pierre de la roche',2,13,1),(18,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur et facilisis elit, nec viverra eros. Nunc placerat in leo in ullamcorper. Phasellus eu feugiat orci. Donec vitae consequat ante. Cras mattis mauris non nisl sollicitudin, ac aliquet magna finibus. Vestibulum a dui eget elit pulvinar ultricies. Phasellus scelerisque nisi vel dolor scelerisque, vitae sagittis nisl facilisis. Curabitur bibendum justo at libero consequat, nec maximus odio molestie. Nunc auctor gravida mauris id ornare. Nunc quam erat, fringilla vel nisi eu, dignissim luctus est.',_binary '','H.A.B',3,13,87),(30,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur et facilisis elit, nec viverra eros. Nunc placerat in leo in ullamcorper. Phasellus eu feugiat orci. Donec vitae consequat ante. Cras mattis mauris non nisl sollicitudin, ac aliquet magna finibus. Vestibulum a dui eget elit pulvinar ultricies. Phasellus scelerisque nisi vel dolor scelerisque, vitae sagittis nisl facilisis. Curabitur bibendum justo at libero consequat, nec maximus odio molestie. Nunc auctor gravida mauris id ornare. Nunc quam erat, fringilla vel nisi eu, dignissim luctus est.',_binary '\0','Kippkopffelsen',2,14,3),(31,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur et facilisis elit, nec viverra eros. Nunc placerat in leo in ullamcorper. Phasellus eu feugiat orci. Donec vitae consequat ante. Cras mattis mauris non nisl sollicitudin, ac aliquet magna finibus. Vestibulum a dui eget elit pulvinar ultricies. Phasellus scelerisque nisi vel dolor scelerisque, vitae sagittis nisl facilisis. Curabitur bibendum justo at libero consequat, nec maximus odio molestie. Nunc auctor gravida mauris id ornare. Nunc quam erat, fringilla vel nisi eu, dignissim luctus est.',_binary '','Test',1,13,1),(116,'Nullam pretium turpis sit amet ultricies pretium. Integer scelerisque diam eu rutrum ullamcorper. Suspendisse pellentesque diam sit amet feugiat bibendum. Etiam ullamcorper elementum sapien vel pharetra. Fusce vitae nisi faucibus, sodales ex eu, convallis mi. Aenean porttitor sapien ut massa congue, at porttitor dui facilisis. Integer tellus velit, iaculis ac massa rhoncus, placerat tincidunt mi. Integer quis arcu purus. Donec non ligula eu neque luctus sagittis et sed sem. Etiam at justo lectus. Nulla facilisi.',_binary '\0','Lames de la Sot',0,15,2);
/*!40000 ALTER TABLE `sites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `topos`
--

LOCK TABLES `topos` WRITE;
/*!40000 ALTER TABLE `topos` DISABLE KEYS */;
INSERT INTO `topos` VALUES (66,1,'ce topo est cool!','Topo de Mimi n1','05/12/2017',1),(67,0,'Ce topo est nouveau!','Topo de Tata n1','12/09/2018',2),(68,0,'Topo extra!','Topo de Mimi n2','04/11/2015',1),(69,0,'Un nouveau topo!','Topo de Tata n2','22/12/2016',2),(70,1,'Ce topo est top!','Topo de Toto n1','07/07/2018',3),(72,0,'Topo de Tata est merveilleux!','topo de Tata n3','09/08/2018',2),(112,0,'C\'est mon topo n°3','Topo de mimi n3','13/12/2017',1);
/*!40000 ALTER TABLE `topos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'mimi@mimi.com','mimi','mimi',0,'c6b438b0c071b0875f3579207f8391b6a60e1319b25832a0ad3fe4bc0a5ae7ea','ADMIN','mimi'),(2,'tata@tata.com','tata','tata',0,'d1c7c99c6e2e7b311f51dd9d19161a5832625fb21f35131fba6da62513f0c099','MEMBRE','tata'),(3,'toto@gmail.com','toto','toto',0,'31f7a65e315586ac198bd798b6629ce4903d0899476d5741a9f32e2e521b6a66','INVITE','toto'),(87,'titi@titi.com','titi','titi',0,'cce66316b4c1c59df94a35afb80cecd82d1a8d91b554022557e115f5c275f515','MEMBRE','titi'),(120,'momo@gmail.com','momo','momo',0,'3100486406b39efc3f3d3565bc97cc3b9e2d7b6e3427b194f4442ef4beb05b41','INVITE','momo');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ways`
--

LOCK TABLES `ways` WRITE;
/*!40000 ALTER TABLE `ways` DISABLE KEYS */;
INSERT INTO `ways` VALUES (1,500,'La voie lactée',2,22,'4a'),(2,500,'Test',0,22,'4a'),(55,23,'Kipp 1 1',1,54,'3'),(91,345,'Kipp 2 1',0,90,'4a'),(92,34,'Roch',1,20,'4a'),(97,2345,'Test',1,96,'6c'),(99,3456,'Kiipp 2 2',0,90,'4a');
/*!40000 ALTER TABLE `ways` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2020-01-14 22:43:19

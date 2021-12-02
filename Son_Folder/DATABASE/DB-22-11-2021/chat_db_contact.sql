-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: chat_db
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `friend_id` bigint DEFAULT NULL,
  `account_id` bigint DEFAULT NULL,
  `accept` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FKik3y2av4uju4i638x36kogv80` (`friend_id`),
  KEY `FK3ctagodg5h629t8ltnam39l5w` (`account_id`),
  CONSTRAINT `FK3ctagodg5h629t8ltnam39l5w` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FKik3y2av4uju4i638x36kogv80` FOREIGN KEY (`friend_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (84,'Ramesh','2021-11-08 23:54:54.921000','Ramesh','2021-11-08 23:54:54.921000',42,43,1),(85,'Ramesh','2021-11-08 23:54:54.950000','Ramesh','2021-11-08 23:54:54.950000',43,42,1),(86,'Ramesh','2021-11-09 12:40:00.564000','Ramesh','2021-11-09 12:40:00.564000',45,44,1),(87,'Ramesh','2021-11-09 12:40:00.623000','Ramesh','2021-11-09 12:40:00.623000',44,45,1),(88,'Ramesh','2021-11-10 17:35:26.345000','Ramesh','2021-11-10 17:35:26.345000',42,51,1),(89,'Ramesh','2021-11-10 17:35:26.470000','Ramesh','2021-11-10 17:35:26.470000',51,42,1),(90,'Ramesh','2021-11-10 17:35:57.379000','Ramesh','2021-11-10 17:35:57.379000',42,52,1),(91,'Ramesh','2021-11-10 17:35:57.417000','Ramesh','2021-11-10 17:35:57.417000',52,42,1),(92,'Ramesh','2021-11-11 10:13:41.154000','Ramesh','2021-11-11 10:13:41.154000',43,52,1),(93,'Ramesh','2021-11-11 10:13:41.501000','Ramesh','2021-11-11 10:13:41.501000',52,43,1);
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-22 20:39:20

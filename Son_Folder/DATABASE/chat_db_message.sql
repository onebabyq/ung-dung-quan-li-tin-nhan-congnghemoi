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
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `content_type` varchar(255) DEFAULT NULL,
  `read_status` varchar(255) DEFAULT NULL,
  `from_id` bigint DEFAULT NULL,
  `room_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3cx7oup1ydcbl5id2brjr0htd` (`from_id`),
  KEY `FKl1kg5a2471cv6pkew0gdgjrmo` (`room_id`),
  CONSTRAINT `FK3cx7oup1ydcbl5id2brjr0htd` FOREIGN KEY (`from_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FKl1kg5a2471cv6pkew0gdgjrmo` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (4,'Ramesh','2021-11-06 18:28:49.979000','Ramesh','2021-11-06 18:28:49.979000','rồi','text','Đã xem',1,1),(5,'Ramesh','2021-11-06 18:30:08.322000','Ramesh','2021-11-06 18:30:08.322000','rồi sao tui nè','text','Đã xem',2,1),(6,'Ramesh','2021-11-06 18:30:13.522000','Ramesh','2021-11-06 18:30:13.522000','uh tui pk mà','text','Đã xem',1,1),(7,'Ramesh','2021-11-06 18:30:25.692000','Ramesh','2021-11-06 18:30:25.692000','à ừm','text','Đã xem',2,1),(8,'Ramesh','2021-11-06 18:34:26.567000','Ramesh','2021-11-06 18:34:26.567000','là sao','text','Đã xem',1,1),(9,'Ramesh','2021-11-06 18:34:51.351000','Ramesh','2021-11-06 18:34:51.351000','ý bạn là sao','text','Đã xem',1,1),(10,'Ramesh','2021-11-06 18:35:06.457000','Ramesh','2021-11-06 18:35:06.457000','là vậy đó :V','text','Đã xem',2,1),(11,'Ramesh','2021-11-06 19:05:06.599000','Ramesh','2021-11-06 19:05:06.599000','hi','text','Đã xem',1,1),(12,'Ramesh','2021-11-06 19:05:27.931000','Ramesh','2021-11-06 19:05:27.931000','ok','text','Đã xem',1,1),(13,'Ramesh','2021-11-06 19:23:30.529000','Ramesh','2021-11-06 19:23:30.529000','dcm','text','Đã xem',1,1),(14,'Ramesh','2021-11-06 19:24:50.165000','Ramesh','2021-11-06 19:24:50.165000','alooo','text','Đã xem',1,1),(15,'Ramesh','2021-11-06 19:24:57.269000','Ramesh','2021-11-06 19:24:57.269000','bạn ơi','text','Đã xem',1,1),(16,'Ramesh','2021-11-06 19:25:18.571000','Ramesh','2021-11-06 19:25:18.571000','Vãi','text','Đã xem',1,2);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-07  8:28:04

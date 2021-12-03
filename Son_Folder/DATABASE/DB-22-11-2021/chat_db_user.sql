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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  `password` varchar(255) DEFAULT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  `account_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_nrrhhb0bsexvi8ch6wnon9uog` (`account_id`),
  CONSTRAINT `FKc3b4xfbq6rbkkrddsdum8t5f0` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (42,'Ramesh','2021-11-08 23:53:58.210000','Ramesh','2021-11-08 23:53:58.210000',1,'12345','0123456789',42),(43,'Ramesh','2021-11-08 23:54:35.069000','Ramesh','2021-11-08 23:54:35.069000',1,'$2a$10$GUyIt8AGc73qg1cMYOSNzucMh.zKEPdzpHdrKYy2gtnEBotn1FYz6','0123123123',43),(44,'Ramesh','2021-11-09 12:38:39.980000','Ramesh','2021-11-09 12:38:39.980000',1,'$2a$10$DCHrk798hdJcLgwu1YcuMOUn.UIMIWAa96dERM.r7Zr6A/i69uRpC','0968900475',44),(45,'Ramesh','2021-11-09 12:39:26.984000','Ramesh','2021-11-09 12:39:26.984000',1,'$2a$10$VSMZeKnaEh9FS/KT9hZVtOnSNFN9FI7UViXUp0ef3ub1eD.ik9K8y','01232577913',45),(48,'Ramesh','2021-11-10 14:10:37.073000','Ramesh','2021-11-10 14:10:37.073000',1,'123','11112222',50),(49,'Ramesh','2021-11-10 17:35:15.092000','Ramesh','2021-11-10 17:35:15.092000',1,'$2a$10$Da95HNx2QLAimSAQHL4suOl4zCrgPCE1MeL2nDTmyrAYoj5C0BceK','034343434',51),(50,'Ramesh','2021-11-10 17:35:47.801000','Ramesh','2021-11-10 17:35:47.801000',1,'$2a$10$HCaz/vhu4Y5lyEnmbPSRUePWGLR.cVDByhMY47AICoMfm8jp738my','014141414',52),(51,'Ramesh','2021-11-22 20:35:56.539000','Ramesh','2021-11-22 20:35:56.539000',1,'12345','0128738245',53);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-22 20:39:21
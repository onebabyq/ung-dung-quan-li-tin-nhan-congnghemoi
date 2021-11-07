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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,NULL,NULL,NULL,1,'$2a$10$cr38sL9ULRK5AlHFLawIbu.Jx1YJxTXtrgzQFy6rbr0B4GB2PKqge','123456781',1),(2,NULL,NULL,NULL,NULL,1,'$2a$10$cr38sL9ULRK5AlHFLawIbu.Jx1YJxTXtrgzQFy6rbr0B4GB2PKqge','1234567123',2),(5,NULL,NULL,NULL,NULL,1,'$2a$10$cr38sL9ULRK5AlHFLawIbu.Jx1YJxTXtrgzQFy6rbr0B4GB2PKqge','1234567289',5),(6,NULL,NULL,NULL,NULL,1,'$2a$10$cr38sL9ULRK5AlHFLawIbu.Jx1YJxTXtrgzQFy6rbr0B4GB2PKqge','1234567891',6),(7,NULL,NULL,NULL,NULL,1,'$2a$10$cr38sL9ULRK5AlHFLawIbu.Jx1YJxTXtrgzQFy6rbr0B4GB2PKqge','12345678911',7),(8,NULL,NULL,NULL,NULL,1,'$2a$10$cr38sL9ULRK5AlHFLawIbu.Jx1YJxTXtrgzQFy6rbr0B4GB2PKqge','123124324',8),(9,NULL,NULL,NULL,NULL,1,'$2a$10$cr38sL9ULRK5AlHFLawIbu.Jx1YJxTXtrgzQFy6rbr0B4GB2PKqge','123456788',9),(10,NULL,NULL,NULL,NULL,1,'$2a$10$cr38sL9ULRK5AlHFLawIbu.Jx1YJxTXtrgzQFy6rbr0B4GB2PKqge','1234567544',10),(11,NULL,NULL,NULL,NULL,1,'$2a$10$cr38sL9ULRK5AlHFLawIbu.Jx1YJxTXtrgzQFy6rbr0B4GB2PKqge','0123456789',11),(12,NULL,NULL,NULL,NULL,1,'$2a$10$cr38sL9ULRK5AlHFLawIbu.Jx1YJxTXtrgzQFy6rbr0B4GB2PKqge','1234567',12),(13,NULL,NULL,NULL,NULL,1,'$2a$10$cr38sL9ULRK5AlHFLawIbu.Jx1YJxTXtrgzQFy6rbr0B4GB2PKqge','5555555555',13),(14,NULL,NULL,NULL,NULL,1,'$2a$10$cr38sL9ULRK5AlHFLawIbu.Jx1YJxTXtrgzQFy6rbr0B4GB2PKqge','1111111',14),(15,'Ramesh','2021-11-06 17:11:17.795000','Ramesh','2021-11-06 17:11:17.795000',1,'$2a$10$plGpYn0AGuFa.CgtOxFExerWh/wYsXPZFC3QOqDq0pEqR83rYur5e','12345123431',15);
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

-- Dump completed on 2021-11-07  8:28:03

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
) ENGINE=InnoDB AUTO_INCREMENT=281 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (190,'Ramesh','2021-11-08 23:55:04.851000','Ramesh','2021-11-08 23:55:04.851000','Chào hưng','TEXT','Đã xem',42,37),(191,'Ramesh','2021-11-08 23:55:14.979000','Ramesh','2021-11-08 23:55:14.979000','alo em oi','TEXT','Đã xem',43,37),(192,'Ramesh','2021-11-08 23:55:19.816000','Ramesh','2021-11-08 23:55:19.816000','qưewqe','TEXT','Đã xem',42,37),(193,'Ramesh','2021-11-08 23:55:24.127000','Ramesh','2021-11-08 23:55:24.127000','rewrwerewr','TEXT','Đã xem',43,37),(194,'Ramesh','2021-11-08 23:55:34.925000','Ramesh','2021-11-08 23:55:34.925000','http://localhost:8080/files/TomandJerryTitleCardc.jpg','IMAGE','Đã xem',42,37),(195,'Ramesh','2021-11-08 23:55:43.847000','Ramesh','2021-11-08 23:55:43.847000','đã gửi hình','TEXT','Đã xem',43,37),(196,'Ramesh','2021-11-08 23:55:48.858000','Ramesh','2021-11-08 23:55:48.858000','tiếp thoe là video','TEXT','Đã xem',43,37),(197,'Ramesh','2021-11-08 23:56:04.288000','Ramesh','2021-11-08 23:56:04.288000','http://localhost:8080/files/video-test.mp4','VIDEO','Đã xem',43,37),(198,'Ramesh','2021-11-08 23:56:15.836000','Ramesh','2021-11-08 23:56:15.836000','cuối cùng là tệp','TEXT','Đã xem',42,37),(199,'Ramesh','2021-11-08 23:56:23.983000','Ramesh','2021-11-08 23:56:23.983000','http://localhost:8080/files/muahang.xlsx','FILE','Đã xem',43,37),(200,'Ramesh','2021-11-09 12:32:58.585000','Ramesh','2021-11-09 12:32:58.585000','hi','TEXT','Đã xem',43,37),(201,'Ramesh','2021-11-09 12:33:02.778000','Ramesh','2021-11-09 12:33:02.778000','chaof nha','TEXT','Đã xem',42,37),(202,'Ramesh','2021-11-09 12:40:20.062000','Ramesh','2021-11-09 12:40:20.062000','alo','TEXT','Đã xem',45,38),(203,'Ramesh','2021-11-09 12:40:36.326000','Ramesh','2021-11-09 12:40:36.326000','chao ban','TEXT','Đã xem',44,38),(204,'Ramesh','2021-11-09 12:40:42.528000','Ramesh','2021-11-09 12:40:42.528000','quaasdsad','TEXT','Đã xem',45,38),(205,'Ramesh','2021-11-09 12:40:45.927000','Ramesh','2021-11-09 12:40:45.927000','qwqwewqe','TEXT','Đã xem',44,38),(206,'Ramesh','2021-11-09 12:40:54.647000','Ramesh','2021-11-09 12:40:54.647000','gui hinh anh','TEXT','Đã xem',45,38),(207,'Ramesh','2021-11-09 12:41:01.084000','Ramesh','2021-11-09 12:41:01.084000','http://localhost:8080/files/TomandJerryTitleCardc.jpg','IMAGE','Đã xem',45,38),(208,'Ramesh','2021-11-09 12:41:06.870000','Ramesh','2021-11-09 12:41:06.870000','gui video','TEXT','Đã xem',44,38),(209,'Ramesh','2021-11-09 12:41:16.050000','Ramesh','2021-11-09 12:41:16.050000','http://localhost:8080/files/video-test.mp4','VIDEO','Đã xem',44,38),(210,'Ramesh','2021-11-09 12:41:32.632000','Ramesh','2021-11-09 12:41:32.632000','gui tep','TEXT','Đã xem',44,38),(211,'Ramesh','2021-11-09 12:41:40.497000','Ramesh','2021-11-09 12:41:40.497000','http://localhost:8080/files/MODULE _ALL.pdf','FILE','Đã xem',44,38),(212,'Ramesh','2021-11-09 12:41:48.513000','Ramesh','2021-11-09 12:41:48.513000','http://localhost:8080/files/muahang.xlsx','FILE','Đã xem',44,38),(213,'Ramesh','2021-11-10 19:05:34.694000','Ramesh','2021-11-10 19:05:34.694000','xin chào bạn','TEXT','Đã xem',42,40),(214,'Ramesh','2021-11-10 19:05:42.395000','Ramesh','2021-11-10 19:05:42.395000','Tôi tên sơn và tôi năm nay 20 tuổi','TEXT','Đã xem',42,40),(215,'Ramesh','2021-11-10 19:05:58.834000','Ramesh','2021-11-10 19:05:58.834000','Tôi cồn muốn biết rằng tô có rất nhiều thứ phải hoàn tất trong hom nay','TEXT','Đã xem',42,40),(216,'Ramesh','2021-11-10 19:05:58.834000','Ramesh','2021-11-10 19:05:58.834000','vãi chưởng','TEXT','Đã xem',42,40),(217,'Ramesh','2021-11-10 19:05:58.834000','Ramesh','2021-11-10 19:05:58.834000','haha','TEXT','Đã xem',42,40),(218,'Ramesh','2021-11-10 19:05:58.834000','Ramesh','2021-11-10 19:05:58.834000','Chào bạn nha, tôi có thể giúp gì không','TEXT','Đã xem',52,40),(219,'Ramesh','2021-11-10 19:05:58.834000','Ramesh','2021-11-10 19:05:58.834000','Chào bạn gái','TEXT','Đã xem',52,40),(232,'Ramesh','2021-11-11 00:24:50.932000','Ramesh','2021-11-11 00:24:50.932000','tôi tên sơn','TEXT','Đã xem',42,40),(233,'Ramesh','2021-11-11 00:34:27.042000','Ramesh','2021-11-11 00:34:27.042000','tôi tên là sơn','TEXT','Đã xem',42,40),(234,'Ramesh','2021-11-11 00:34:32.493000','Ramesh','2021-11-11 00:34:32.493000','haha','TEXT','Đã xem',42,40),(235,'Ramesh','2021-11-11 00:49:14.358000','Ramesh','2021-11-11 00:49:14.358000','hello bạn','TEXT','Đã xem',52,40),(236,'Ramesh','2021-11-11 00:49:21.224000','Ramesh','2021-11-11 00:49:21.224000','helo','TEXT','Đã xem',42,40),(237,'Ramesh','2021-11-11 00:49:58.258000','Ramesh','2021-11-11 00:49:58.258000','tôi rất chào bạn','TEXT','Đã xem',52,40),(238,'Ramesh','2021-11-11 00:50:56.304000','Ramesh','2021-11-11 00:50:56.304000','ok','TEXT','Đã xem',42,40),(239,'Ramesh','2021-11-11 00:56:32.170000','Ramesh','2021-11-11 00:56:32.170000','nè','TEXT','Đã xem',52,40),(240,'Ramesh','2021-11-11 00:59:07.700000','Ramesh','2021-11-11 00:59:07.700000','hmm','TEXT','Đã xem',52,40),(241,'Ramesh','2021-11-11 01:07:20.427000','Ramesh','2021-11-11 01:07:20.427000','chào yến','TEXT','Đã xem',52,40),(242,'Ramesh','2021-11-11 08:12:59.133000','Ramesh','2021-11-11 08:12:59.133000','kkk','TEXT','Đã xem',42,40),(243,'Ramesh','2021-11-11 08:13:03.480000','Ramesh','2021-11-11 08:13:03.480000','chào','TEXT','Đã xem',52,40),(244,'Ramesh','2021-11-11 08:30:19.394000','Ramesh','2021-11-11 08:30:19.394000','k','TEXT','Đã xem',42,40),(245,'Ramesh','2021-11-11 08:30:27.224000','Ramesh','2021-11-11 08:30:27.224000','kk','TEXT','Đã xem',42,40),(246,'Ramesh','2021-11-11 08:30:41.713000','Ramesh','2021-11-11 08:30:41.713000','haha','TEXT','Đã xem',42,40),(247,'Ramesh','2021-11-11 08:31:01.151000','Ramesh','2021-11-11 08:31:01.151000','hello','TEXT','Đã xem',52,40),(248,'Ramesh','2021-11-11 08:31:06.829000','Ramesh','2021-11-11 08:31:06.829000','chào','TEXT','Đã xem',52,40),(249,'Ramesh','2021-11-11 08:31:30.340000','Ramesh','2021-11-11 08:31:30.340000','vãi cả chữn','TEXT','Đã xem',42,40),(250,'Ramesh','2021-11-11 08:31:36.157000','Ramesh','2021-11-11 08:31:36.157000','kkk','TEXT','Đã xem',52,40),(251,'Ramesh','2021-11-11 08:32:38.601000','Ramesh','2021-11-11 08:32:38.601000','vậy à','TEXT','Đã xem',42,40),(252,'Ramesh','2021-11-11 09:49:41.460000','Ramesh','2021-11-11 09:49:41.460000','abc','TEXT','Đã xem',42,40),(253,'Ramesh','2021-11-11 09:51:02.560000','Ramesh','2021-11-11 09:51:02.560000','chào chú','TEXT','Đã xem',52,40),(254,'Ramesh','2021-11-11 09:53:04.948000','Ramesh','2021-11-11 09:53:04.948000','chào cô ạ','TEXT','Đã xem',52,40),(255,'Ramesh','2021-11-11 09:54:51.293000','Ramesh','2021-11-11 09:54:51.293000','bạn ơi','TEXT','Đã xem',52,40),(256,'Ramesh','2021-11-11 10:10:08.486000','Ramesh','2021-11-11 10:10:08.486000','chào nhé','TEXT','Đã xem',52,40),(257,'Ramesh','2021-11-11 10:11:26.404000','Ramesh','2021-11-11 10:11:26.404000','uhm','TEXT','Đã xem',42,40),(258,'Ramesh','2021-11-11 10:11:32.546000','Ramesh','2021-11-11 10:11:32.546000','yh','TEXT','Đã xem',42,40),(259,'Ramesh','2021-11-11 10:11:40.851000','Ramesh','2021-11-11 10:11:40.851000','fhhggdhh','TEXT','Đã xem',42,40),(260,'Ramesh','2021-11-11 10:11:43.029000','Ramesh','2021-11-11 10:11:43.029000','hdhdghdhehs','TEXT','Đã xem',42,40),(261,'Ramesh','2021-11-11 10:11:49.196000','Ramesh','2021-11-11 10:11:49.196000','dketjstfajafj','TEXT','Đã xem',42,40),(262,'Ramesh','2021-11-11 10:11:55.529000','Ramesh','2021-11-11 10:11:55.529000','stjsgjjsg','TEXT','Đã xem',42,40),(263,'Ramesh','2021-11-11 10:11:58.450000','Ramesh','2021-11-11 10:11:58.450000','avavav','TEXT','Đã xem',52,40),(264,'Ramesh','2021-11-11 10:12:11.965000','Ramesh','2021-11-11 10:12:11.965000','àdafadfdaf','TEXT','Đã xem',52,40),(265,'Ramesh','2021-11-11 10:12:29.002000','Ramesh','2021-11-11 10:12:29.002000','gegwgwgg','TEXT','Đã xem',42,40),(266,'Ramesh','2021-11-11 10:12:33.512000','Ramesh','2021-11-11 10:12:33.512000','rưertertteyty','TEXT','Đã xem',52,40),(267,'Ramesh','2021-11-11 10:12:39.470000','Ramesh','2021-11-11 10:12:39.470000','dsgsgdsd','TEXT','Đã xem',52,40),(268,'Ramesh','2021-11-11 10:13:51.157000','Ramesh','2021-11-11 10:13:51.157000','ah','TEXT','Đã xem',52,41),(269,'Ramesh','2021-11-11 10:13:56.746000','Ramesh','2021-11-11 10:13:56.746000','yhm','TEXT','Đã xem',43,41),(270,'Ramesh','2021-11-11 10:20:04.606000','Ramesh','2021-11-11 10:20:04.606000','hhh','TEXT','Đã xem',42,40),(271,'Ramesh','2021-11-11 10:20:10.534000','Ramesh','2021-11-11 10:20:10.534000','hh','TEXT','Đã xem',42,40),(272,'Ramesh','2021-11-11 10:20:14.508000','Ramesh','2021-11-11 10:20:14.508000','vcc','TEXT','Đã xem',52,40),(273,'Ramesh','2021-11-11 11:31:15.659000','Ramesh','2021-11-11 11:31:15.659000','ê','TEXT','Đã xem',52,40),(274,'Ramesh','2021-11-11 11:31:22.664000','Ramesh','2021-11-11 11:31:22.664000','nghe nè','TEXT','Đã xem',42,40),(275,'Ramesh','2021-11-11 11:31:25.931000','Ramesh','2021-11-11 11:31:25.931000','haha','TEXT','Đã xem',52,40),(276,'Ramesh','2021-11-11 11:33:03.473000','Ramesh','2021-11-11 11:33:03.473000','chào','TEXT','Đã xem',52,40),(277,'Ramesh','2021-11-11 11:33:07.812000','Ramesh','2021-11-11 11:33:07.812000','hêlo','TEXT','Đã xem',42,40),(278,'Ramesh','2021-11-11 11:33:58.738000','Ramesh','2021-11-11 11:33:58.738000','chào hehe','TEXT','Đã xem',52,40),(279,'Ramesh','2021-11-11 11:34:03.000000','Ramesh','2021-11-11 11:34:03.000000','đc nha','TEXT','Đã xem',42,40),(280,'Ramesh','2021-11-11 11:34:52.897000','Ramesh','2021-11-11 11:34:52.897000','http://localhost:8080/files/TomandJerryTitleCardc.jpg','IMAGE','Đã xem',52,40);
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

-- Dump completed on 2021-11-22 20:39:19

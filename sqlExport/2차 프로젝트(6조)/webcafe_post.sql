-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: webcafe
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `po_num` int NOT NULL AUTO_INCREMENT,
  `po_title` varchar(30) NOT NULL,
  `po_content` text NOT NULL,
  `po_date` datetime NOT NULL,
  `po_views` int NOT NULL DEFAULT '0',
  `po_bo_num` int NOT NULL,
  `po_me_id` varchar(8) NOT NULL,
  PRIMARY KEY (`po_num`),
  KEY `FK_board_TO_post_1` (`po_bo_num`),
  KEY `FK_member_TO_post_1` (`po_me_id`),
  CONSTRAINT `FK_board_TO_post_1` FOREIGN KEY (`po_bo_num`) REFERENCES `board` (`bo_num`),
  CONSTRAINT `FK_member_TO_post_1` FOREIGN KEY (`po_me_id`) REFERENCES `member` (`me_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'공지사항 입니다.','클린 내용 올려주세요.','2024-03-14 00:00:00',3,1,'admin123'),(2,'카리나','카리나','2024-03-14 00:00:00',0,2,'asdf1234'),(3,'닝닝','닝닝','2024-03-14 00:00:00',0,2,'asdf1234'),(4,'닝닝 조아','닝닝 조아','2024-03-14 00:00:00',0,2,'qwer1234'),(5,'쿠페 얼마하나요','쿠페 얼마하나요','2024-03-14 00:00:00',0,4,'qwer1234'),(6,'쿠페 이뻐','쿠페 이뻐','2024-03-14 00:00:00',1,4,'qwer1234'),(7,'현진','현진','2024-03-14 00:00:00',0,3,'qwer1234'),(8,'필릭스','필릭스','2024-03-14 00:00:00',0,3,'qwer1234'),(9,'쿠쿠쿠히','쿠쿠쿠히','2024-03-14 09:12:34',1,2,'qwer1234');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-15 17:29:33

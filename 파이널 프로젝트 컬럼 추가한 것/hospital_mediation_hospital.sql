-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital_mediation
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
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospital` (
  `ho_id` varchar(13) NOT NULL,
  `ho_ms_state` varchar(20) NOT NULL,
  `ho_hs_num` int NOT NULL,
  `ho_pw` varchar(255) NOT NULL,
  `ho_name` varchar(50) NOT NULL,
  `ho_ceo` varchar(5) NOT NULL,
  `ho_num` char(10) NOT NULL,
  `ho_address` varchar(100) NOT NULL,
  `ho_phone` char(11) NOT NULL,
  `ho_authority` varchar(10) NOT NULL,
  `ho_cookie` varchar(255) DEFAULT NULL,
  `ho_cookie_limit` datetime DEFAULT NULL,
  `ho_email` varchar(100) NOT NULL,
  `ho_report_count` int DEFAULT '0',
  PRIMARY KEY (`ho_id`),
  KEY `FK_member_state_TO_hospital_1` (`ho_ms_state`),
  KEY `FK_hospital_subject_TO_hospital_1` (`ho_hs_num`),
  CONSTRAINT `FK_hospital_subject_TO_hospital_1` FOREIGN KEY (`ho_hs_num`) REFERENCES `hospital_subject` (`hs_num`),
  CONSTRAINT `FK_member_state_TO_hospital_1` FOREIGN KEY (`ho_ms_state`) REFERENCES `member_state` (`ms_state`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-12  1:35:42

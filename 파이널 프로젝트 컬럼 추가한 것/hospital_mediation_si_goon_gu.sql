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
-- Table structure for table `si_goon_gu`
--

DROP TABLE IF EXISTS `si_goon_gu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `si_goon_gu` (
  `sgg_num` int NOT NULL AUTO_INCREMENT,
  `sgg_name` varchar(255) NOT NULL,
  `sgg_sd_num` int NOT NULL,
  PRIMARY KEY (`sgg_num`),
  KEY `FK_si_do_TO_si_goon_gu_1` (`sgg_sd_num`),
  CONSTRAINT `FK_si_do_TO_si_goon_gu_1` FOREIGN KEY (`sgg_sd_num`) REFERENCES `si_do` (`sd_num`)
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `si_goon_gu`
--

LOCK TABLES `si_goon_gu` WRITE;
/*!40000 ALTER TABLE `si_goon_gu` DISABLE KEYS */;
INSERT INTO `si_goon_gu` VALUES (1,'종로구',1),(2,'중구',1),(3,'용산구',1),(4,'성동구',1),(5,'광진구',1),(6,'동대문구',1),(7,'중랑구',1),(8,'성북구',1),(9,'강북구',1),(10,'도봉구',1),(11,'노원구',1),(12,'은평구',1),(13,'서대문구',1),(14,'마포구',1),(15,'양천구',1),(16,'강서구',1),(17,'구로구',1),(18,'금천구',1),(19,'영등포구',1),(20,'동작구',1),(21,'관악구',1),(22,'서초구',1),(23,'강남구',1),(24,'송파구',1),(25,'강동구',1),(26,'중구',2),(27,'서구',2),(28,'동구',2),(29,'영도구',2),(30,'부산진구',2),(31,'동래구',2),(32,'남구',2),(33,'북구',2),(34,'해운대구',2),(35,'사하구',2),(36,'금정구',2),(37,'강서구',2),(38,'연제구',2),(39,'수영구',2),(40,'사상구',2),(41,'기장군',2),(42,'중구',3),(43,'동구',3),(44,'서구',3),(45,'남구',3),(46,'북구',3),(47,'수성구',3),(48,'달서구',3),(49,'달성군',3),(50,'중구',4),(51,'동구',4),(52,'미추홀구',4),(53,'연수구',4),(54,'남동구',4),(55,'부평구',4),(57,'서구',4),(58,'강화군',4),(59,'옹진군',4),(60,'동구',5),(61,'서구',5),(62,'남구',5),(63,'북구',5),(64,'광산구',5),(65,'동구',6),(66,'중구',6),(67,'서구',6),(68,'유성구',6),(69,'대덕구',6),(70,'중구',7),(71,'남구',7),(72,'동구',7),(73,'북구',7),(74,'울주군',7),(75,'세종특별자치시',8),(76,'수원시 장안구',9),(77,'수원시 권선구',9),(79,'수원시 영통구',9),(80,'성남시 수정구',9),(81,'성남시 중원구',9),(82,'성남시 분당구',9),(83,'의정부시',9),(84,'안양시 만안구',9),(85,'안양시 동안구',9),(86,'부천시',9),(87,'광명시',9),(88,'평택시',9),(89,'동두천시',9),(90,'안산시 상록구',9),(91,'안산시 단원구',9),(92,'고양시 덕양구',9),(93,'고양시 일산동구',9),(94,'고양시 일산서구',9),(95,'과천시',9),(96,'구리시',9),(97,'남양주시',9),(98,'오산시',9),(99,'시흥시',9),(100,'군포시',9),(101,'의왕시',9),(102,'하남시',9),(103,'용인시 처인구',9),(104,'용인시 기흥구',9),(105,'용인시 수지구',9),(106,'파주시',9),(107,'이천시',9),(108,'안성시',9),(109,'김포시',9),(110,'화성시',9),(111,'광주시',9),(112,'양주시',9),(113,'포천시',9),(114,'여주시',9),(115,'연천군',9),(116,'가평군',9),(117,'양평군',9),(118,'춘천시',10),(119,'원주시',10),(120,'강릉시',10),(121,'동해시',10),(122,'태백시',10),(123,'속초시',10),(124,'삼척시',10),(125,'홍천군',10),(126,'횡성군',10),(127,'영월군',10),(128,'평창군',10),(129,'정선군',10),(130,'철원군',10),(131,'화천군',10),(132,'양구군',10),(133,'인제군',10),(134,'고성군',10),(135,'양양군',10),(136,'청주시 상당구',11),(137,'청주시 서원구',11),(138,'청주시 흥덕구',11),(139,'청주시 청원구',11),(140,'충주시',11),(141,'제천시',11),(142,'보은군',11),(143,'옥천군',11),(144,'영동군',11),(145,'증평군',11),(146,'진천군',11),(147,'괴산군',11),(148,'음성군',11),(149,'단양군',11),(150,'천안시 동남구',12),(151,'천안시 서북구',12),(152,'공주시',12),(153,'보령시',12),(154,'아산시',12),(155,'서산시',12),(156,'논산시',12),(157,'계룡시',12),(158,'당진시',12),(159,'금산군',12),(160,'부여군',12),(161,'서천군',12),(162,'청양군',12),(163,'홍성군',12),(164,'예산군',12),(165,'태안군',12),(166,'전주시 완산구',13),(167,'전주시 덕진구',13),(168,'군산시',13),(169,'익산시',13),(170,'정읍시',13),(171,'남원시',13),(172,'김제시',13),(173,'완주군',13),(174,'진안군',13),(175,'무주군',13),(176,'장수군',13),(177,'임실군',13),(178,'순창군',13),(179,'고창군',13),(180,'부안군',13),(181,'목포시',14),(182,'여수시',14),(183,'순천시',14),(184,'나주시',14),(185,'광양시',14),(186,'담양군',14),(187,'곡성군',14),(188,'구례군',14),(189,'고흥군',14),(190,'보성군',14),(191,'화순군',14),(192,'장흥군',14),(193,'강진군',14),(194,'해남군',14),(195,'영암군',14),(196,'무안군',14),(197,'함평군',14),(198,'영광군',14),(199,'장성군',14),(200,'완도군',14),(201,'진도군',14),(202,'신안군',14),(203,'포항시 남구',15),(204,'포항시 북구',15),(205,'경주시',15),(206,'김천시',15),(207,'안동시',15),(208,'구미시',15),(209,'영주시',15),(210,'영천시',15),(211,'상주시',15),(212,'문경시',15),(213,'경산시',15),(214,'군위군',15),(215,'의성군',15),(216,'청송군',15),(217,'영양군',15),(218,'영덕군',15),(219,'청도군',15),(220,'고령군',15),(221,'성주군',15),(222,'칠곡군',15),(223,'예천군',15),(224,'봉화군',15),(225,'울진군',15),(226,'울릉군',15),(227,'창원시 의창구',16),(228,'창원시 성산구',16),(229,'창원시 마산합포구',16),(230,'창원시 마산회원구',16),(231,'창원시 진해구',16),(232,'진주시',16),(233,'통영시',16),(234,'사천시',16),(235,'김해시',16),(236,'밀양시',16),(237,'거제시',16),(238,'양산시',16),(239,'의령군',16),(240,'함안군',16),(241,'창녕군',16),(242,'고성군',16),(243,'남해군',16),(244,'하동군',16),(245,'산청군',16),(246,'함양군',16),(247,'거창군',16),(248,'합천군',16),(249,'제주시',17),(250,'서귀포시',17);
/*!40000 ALTER TABLE `si_goon_gu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-12  1:35:44

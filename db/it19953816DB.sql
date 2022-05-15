-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: electrogrid_meterprofile
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `meterprofile`
--

DROP TABLE IF EXISTS `meterprofile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meterprofile` (
  `id` varchar(5) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `connection_type` varchar(45) DEFAULT NULL,
  `estimated_power_consumptionl` varchar(45) DEFAULT NULL,
  `owner` varchar(45) DEFAULT NULL,
  `initialized_date` date DEFAULT NULL,
  `initialized_emp` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `request_delete` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meterprofile`
--

LOCK TABLES `meterprofile` WRITE;
/*!40000 ALTER TABLE `meterprofile` DISABLE KEYS */;
INSERT INTO `meterprofile` VALUES ('001','sweet_home','single phase ','230','wijae','2022-04-01',NULL,'123, gotagogama,galle face',NULL),('002','lali gedra','single phase','230','kaputas','2022-04-02',NULL,NULL,NULL),('004','GotaGoGama','three phase','440','Gota','2022-04-20','sawendra','',NULL),('005','GotaGoGama','three phase','440','Gota','2022-04-19','sawendra','elsewhere',NULL),('006','GotaGoGama','three phase','440','Gota','2022-04-24','sawendra','anywhere',NULL),('007','test_getConnection','single phase','230','tester3','2022-04-04','annoymous ','somewhere',NULL),('008','ela laga gedra','three phase','440','shantha ','2022-04-01','emp','somewhere',NULL),('009','change the name','three phase','440','upul','2022-04-13','EMP_2','anywhere',NULL),('010','niwasa','single phase','230','kaputas','2022-04-18','anoymous ','nowhere',NULL),('011','','single phase','230','tester','2022-04-04','amarabandu rupasingha','somewhere',NULL),('013','nice home ','single phase','230','namal baby','2022-04-16','amare ','nowhere',NULL),('014','bangole','three phase','440','kaputas','2022-04-17','lokuge','anywhere',NULL),('015','hotel for beginners','three phase','440','tester','2022-04-04','namal baby','901, Rail crossing street, Rabukkana',NULL),('016','palu gedr','single phase','230','basil','2022-04-17','emp','somewhere',NULL),('017','','single phase','230','tester','2022-04-04','basil','34,paper works, Uganda',NULL),('021','tester',NULL,'230','kumara','2022-04-04','someone','45,Kaleni Wihara Street, Nagaloke','1'),('025','is_lander3','single phase','230','tester3','2022-04-07','gota','somewhere','1'),('030','home101','single phase','230','anoymous','2022-04-01','Mahinda ','12, meloy street, north east, somewhere',NULL);
/*!40000 ALTER TABLE `meterprofile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-24 20:46:59

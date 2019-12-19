-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: webshop
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `korisnik` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `korisnicko_ime` varchar(45) NOT NULL,
  `lozinka` varchar(45) NOT NULL,
  `ime` varchar(45) DEFAULT NULL,
  `prezime` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefon` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `korisnicko_ime_UNIQUE` (`korisnicko_ime`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
INSERT INTO `korisnik` VALUES (2,'pera','pera123','Petar','Petrovic','',NULL),(3,'steva','steva123','Stevan','Stevic','',NULL),(16,'rade','rade123','Radoslav','Strbac','',NULL),(17,'aki','aki','Andrija','Ilic','aki@pcoffice.rs','061/60-70-777'),(18,'igor','igor','Igor','Strbac','igor@pcoffice.rs',NULL),(19,'ivanka','iva','Ivanka','Strbac','ivanka@pcoffice.rs',NULL),(20,'rade1','rade1','Radoslav','Strbac','direktor@pcoffice.rs','063/403-878'),(21,'aleks','aleks','Aleksandra','Strbac','alex@pcoffice.rs','060/0100096');
/*!40000 ALTER TABLE `korisnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kupovina`
--

DROP TABLE IF EXISTS `kupovina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `kupovina` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_korisnik` int(11) NOT NULL,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) DEFAULT NULL,
  `broj_kartice` varchar(45) NOT NULL,
  `cena` int(11) NOT NULL DEFAULT '0',
  `telefon` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_kupovina_korisnik_idx` (`id_korisnik`),
  CONSTRAINT `fk_kupovina_korisnik` FOREIGN KEY (`id_korisnik`) REFERENCES `korisnik` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kupovina`
--

LOCK TABLES `kupovina` WRITE;
/*!40000 ALTER TABLE `kupovina` DISABLE KEYS */;
INSERT INTO `kupovina` VALUES (10,17,'Andrija','Ilic','203940239',192000,NULL),(11,17,'Andrija','Ilic','klkl',3200,NULL),(12,17,'Andrija','Ilic','klkl',174000,NULL),(13,17,'Andrija','Ilic','23r',3200,NULL),(14,17,'Andrija','Ilic','iuh',3500,NULL),(15,17,'Andrija','Ilic','2342',175000,NULL),(16,17,'Andrija','Ilic','lkjlkj',45500,NULL),(17,17,'Andrija','Ilic','lkjlkj',261000,NULL),(18,17,'Andrija','Ilic','iojio',10500,NULL),(19,17,'Andrija','Ilic','ioji',3500,NULL),(20,19,'Ivanka','Strbac','ljljo',93400,NULL),(21,20,'Radoslav','Strbac','oijoijo',6400,NULL),(22,21,'Aleksandra','Strbac','oijoijijo',6400,NULL),(23,17,'Andrija','Ilic','4056756756486452',3200,NULL),(24,17,'Andrija','Ilic','4056756756486452',9600,NULL),(25,17,'Andrija','Ilic','4444444444444444',261000,NULL),(26,17,'Andrija','Ilic','4841878710724927',3200,NULL),(27,17,'Andrija','Ilic','4313746600889879',3200,NULL),(28,17,'Andrija','Ilic','4313746600889879',3200,NULL),(29,17,'Andrija','Ilic','4313746600889879',225000,NULL),(30,17,'Andrija','Ilic','4313746600889879',19200,NULL),(31,17,'Andrija','Ilic','4313746600889879',85500,NULL),(32,17,'Andrija','Ilic','4313746600889879',247500,NULL),(33,17,'Andrija','Ilic','',122000,NULL),(34,17,'Andrija','Ilic','',116700,NULL),(35,17,'Andrija','Ilic','',270600,NULL),(36,17,'Andrija','Ilic','',3500,NULL),(37,17,'Andrija','Ilic','',90500,NULL),(38,17,'Andrija','Ilic','',90200,NULL),(39,17,'Andrija','Ilic','',90200,NULL),(40,17,'Andrija','Ilic','4313746600889879',272000,NULL),(41,17,'Andrija','Ilic','4313746600889879',122000,NULL),(42,17,'Andrija','Ilic','',94000,NULL),(43,17,'Andrija','Ilic','4313746600889879',339500,NULL),(44,17,'Andrija','Ilic','4313746600889879',270500,NULL),(45,16,'Radoslav','Strbac','4313746600889879',41700,NULL),(46,17,'Andrija','Ilic','4313746600889879',166600,NULL),(47,17,'Andrija','Ilic','4313746600889879',3200,'061/60-70-777'),(48,17,'Andrija','Ilic','4313746600889879',73200,NULL),(49,17,'Andrija','Ilic','4313746600889879',79800,'061/60-70-777'),(50,17,'Andrija','Ilic','4313746600889879',55600,'061/60-70-777'),(51,17,'Andrija','Ilic','4313746600889879',91300,'061/60-70-777'),(52,17,'Andrija','Ilic','4313746600889879',39900,'061/60-70-777'),(53,17,'Andrija','Ilic','4313746600889879',39900,'061/60-70-777'),(54,17,'Andrija','Ilic','4313746600889879',75800,'061/60-70-777'),(55,17,'Andrija','Ilic','4313746600889879',169200,'061/60-70-777'),(56,17,'Andrija','Ilic','4313746600889879',91900,'061/60-70-777'),(57,17,'Andrija','Ilic','4313746600889879',71600,'061/60-70-777'),(58,17,'Andrija','Ilic','4313746600889879',16700,'061/60-70-777');
/*!40000 ALTER TABLE `kupovina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kupovina_proizvodi`
--

DROP TABLE IF EXISTS `kupovina_proizvodi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `kupovina_proizvodi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proizvod_id` int(11) NOT NULL,
  `kolicina` int(11) NOT NULL DEFAULT '1',
  `kupovina_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_kp_kupovina_idx` (`kupovina_id`),
  KEY `fk_kp_proizvod_idx` (`proizvod_id`),
  CONSTRAINT `fk_kp_kupovina` FOREIGN KEY (`kupovina_id`) REFERENCES `kupovina` (`id`),
  CONSTRAINT `fk_kp_proizvod` FOREIGN KEY (`proizvod_id`) REFERENCES `proizvod` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kupovina_proizvodi`
--

LOCK TABLES `kupovina_proizvodi` WRITE;
/*!40000 ALTER TABLE `kupovina_proizvodi` DISABLE KEYS */;
INSERT INTO `kupovina_proizvodi` VALUES (18,2,3,10),(19,4,1,10),(20,5,1,11),(21,4,2,12),(22,5,1,13),(23,3,1,14),(24,2,5,15),(25,3,3,16),(26,2,1,16),(27,4,3,17),(28,3,3,18),(29,3,1,19),(30,4,1,20),(31,5,2,20),(32,5,2,21),(33,5,2,22),(34,5,1,23),(35,5,3,24),(36,4,3,25),(37,5,1,26),(38,5,1,27),(39,5,1,28),(40,1,3,29),(41,5,6,30),(42,1,1,31),(43,3,3,31),(44,3,1,32),(45,4,2,32),(46,2,2,32),(47,4,1,33),(48,2,1,33),(49,2,1,34),(50,3,1,34),(51,1,1,34),(52,5,1,34),(53,5,3,35),(54,4,3,35),(55,3,1,36),(56,4,1,37),(57,3,1,37),(58,4,1,38),(59,5,1,38),(60,5,1,39),(61,4,1,39),(62,4,1,40),(63,2,1,40),(64,1,2,40),(65,2,1,41),(66,4,1,41),(67,4,1,42),(68,3,2,42),(69,1,1,43),(70,4,3,43),(71,3,1,43),(72,4,1,44),(73,3,1,44),(74,2,3,44),(75,1,1,44),(76,5,1,45),(77,3,1,45),(78,2,1,45),(79,4,1,46),(80,2,2,46),(81,5,3,46),(82,5,1,47),(83,8,3,48),(84,10,2,49),(85,2,2,50),(86,5,1,50),(87,9,1,51),(88,4,1,51),(89,5,1,51),(90,6,1,51),(91,10,1,52),(92,10,1,53),(93,5,2,54),(94,7,2,54),(95,6,3,55),(96,9,3,55),(97,7,1,56),(98,8,3,56),(99,6,1,57),(100,3,3,57),(101,1,1,58);
/*!40000 ALTER TABLE `kupovina_proizvodi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proizvod`
--

DROP TABLE IF EXISTS `proizvod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `proizvod` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) NOT NULL,
  `cena` int(11) NOT NULL DEFAULT '1000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proizvod`
--

LOCK TABLES `proizvod` WRITE;
/*!40000 ALTER TABLE `proizvod` DISABLE KEYS */;
INSERT INTO `proizvod` VALUES (1,'Cubot KING-KONG IP68',16700),(2,'NOMU S30 4.7\" ( BLACK + SPACE GREY ) 4G EU',18200),(3,'M-HORSE PURE 1',16300),(4,'Blackview BV4000 IP68',15700),(5,'Blackview BV5800 IP68',19200),(6,'Blackview BV6000 IP68',22700),(7,'Blackview BV7000 IP68',18700),(8,'Blackview BV7000 Pro IP68',24400),(9,'Blackview BV8000 Pro IP68',33700),(10,'Blackview BV9000 Pro Ice IP68',39900);
/*!40000 ALTER TABLE `proizvod` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-14 19:38:03

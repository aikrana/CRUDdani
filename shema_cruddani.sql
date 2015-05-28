CREATE DATABASE  IF NOT EXISTS `cruddani` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cruddani`;
-- MySQL dump 10.13  Distrib 5.5.43, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: CRUDdani
-- ------------------------------------------------------
-- Server version	5.5.43-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `libros`
--

DROP TABLE IF EXISTS `libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) DEFAULT NULL,
  `autor` varchar(45) DEFAULT NULL,
  `editorial` varchar(45) DEFAULT NULL,
  `isbn` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libros`
--

LOCK TABLES `libros` WRITE;
/*!40000 ALTER TABLE `libros` DISABLE KEYS */;
INSERT INTO `libros` VALUES (1,'Cien años de soledad','Gabriel Garcia Márquez','Sudamericana','546654259'),(2,'Harry Potter','J.K. Rowling','Salamandra','147268176'),(3,'El Señor de los Anillos','J.R.R. Tolkien','Minotauro','456258951'),(4,'Los Pilares de la Tierra','Ken Follet','Debolsillo','456987123'),(5,'Don Quijote de la Mancha','Miguel de Cervantes','Algar','456825641'),(6,'El Perfume','Patrick Süskind','Barral','782156548'),(7,'Crepusculo','Stephenie Meyer','Planeta','456825894'),(8,'El Código Da Vinci','Dan Brown','Umbriel','456785321'),(9,'Romeo y Julieta','William Shakespeare','Teatro','743245654'),(10,'El Nombre de la Rosa','Umberto Eco','Debolsillo','784321365'),(11,'El Hobbit','J.R.R. Tolkien','Minotauro','564651823'),(12,'El Alquimista','Paulo Coelho','Circulo','788412189'),(13,'La Sombra del Viento','Carlos Ruiz Zafón','Planeta','564621898'),(14,'La Historia Interminable','Michael Ende','Salamandra','548822198'),(15,'La Odisea','Homero','Planeta','743241684'),(16,'La Casa de los Espiritus','Isabel Allende','Debolsillo','543984613'),(17,'La Metamorfosis','Franz Kafka','Gargola','454698436');
/*!40000 ALTER TABLE `libros` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-21 12:21:10

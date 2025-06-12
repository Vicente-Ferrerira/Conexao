-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: mysql-37dd114c-diegofrra083-641f.c.aivencloud.com    Database: cdz_Cavaleiros_Reencarnados
-- ------------------------------------------------------
-- Server version	8.0.35

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'd59f337c-46eb-11f0-b5a8-862ccfb002b8:1-45';

--
-- Table structure for table `REENCARNACOES`
--

DROP TABLE IF EXISTS `REENCARNACOES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `REENCARNACOES` (
  `id_reencarnacao` int NOT NULL AUTO_INCREMENT,
  `id_cavaleiro` int DEFAULT NULL,
  `id_era` int DEFAULT NULL,
  `nome_reencarnado` varchar(100) NOT NULL,
  `personalidade` text,
  `evento_marcante` text,
  PRIMARY KEY (`id_reencarnacao`),
  KEY `id_cavaleiro` (`id_cavaleiro`),
  KEY `id_era` (`id_era`),
  CONSTRAINT `REENCARNACOES_ibfk_1` FOREIGN KEY (`id_cavaleiro`) REFERENCES `CAVALEIROS` (`id_cavaleiro`),
  CONSTRAINT `REENCARNACOES_ibfk_2` FOREIGN KEY (`id_era`) REFERENCES `ERAS` (`id_era`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REENCARNACOES`
--

LOCK TABLES `REENCARNACOES` WRITE;
/*!40000 ALTER TABLE `REENCARNACOES` DISABLE KEYS */;
INSERT INTO `REENCARNACOES` VALUES (1,1,1,'Tenma','Corajoso e impulsivo','Participou da primeira luta contra Hades'),(2,2,2,'Jun','Gentil e protetor','Protegeu aldeões durante a guerra'),(3,3,2,'Long','Disciplinado e sábio','Desafiou um deus pelo bem de Atena'),(4,4,3,'Kristoff','Frio e estratégico','Lutou contra cavaleiros traidores'),(5,5,4,'Ragna','Solitário e forte','Defendeu sozinho um templo de Poseidon');
/*!40000 ALTER TABLE `REENCARNACOES` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-11 21:05:44

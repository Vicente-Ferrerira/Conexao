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
-- Table structure for table `ARMADURAS`
--

DROP TABLE IF EXISTS `ARMADURAS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ARMADURAS` (
  `id_armadura` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `tipo` varchar(30) DEFAULT NULL,
  `material` varchar(50) DEFAULT NULL,
  `poder_base` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_armadura`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ARMADURAS`
--

LOCK TABLES `ARMADURAS` WRITE;
/*!40000 ALTER TABLE `ARMADURAS` DISABLE KEYS */;
INSERT INTO `ARMADURAS` VALUES (1,'Armadura de Pégaso','Bronze','Oricalco e Pó Estelar','Meteoros de Pégaso'),(2,'Armadura de Andrômeda','Bronze','Oricalco e Pó Estelar','Corrente de Andrômeda'),(3,'Armadura de Dragão','Bronze','Oricalco e Pó Estelar','Escudo do Dragão'),(4,'Armadura de Cisne','Bronze','Oricalco e Pó Estelar','Pó de Diamante'),(5,'Armadura de Fênix','Bronze','Oricalco e Pó Estelar','Asas Flamejantes'),(6,'Armadura de Leão','Ouro','Oricalco Divino','Rugido do Leão'),(7,'Armadura de Virgem','Ouro','Oricalco Divino','Tesouro do Céu'),(8,'Armadura de Aquário','Ouro','Oricalco Divino','Execução Aurora'),(9,'Armadura de Capricórnio','Ouro','Oricalco Divino','Excalibur'),(11,'ArmaduraJava','Demoniaca','Aço Infernal','8000');
/*!40000 ALTER TABLE `ARMADURAS` ENABLE KEYS */;
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

-- Dump completed on 2025-06-11 21:05:09

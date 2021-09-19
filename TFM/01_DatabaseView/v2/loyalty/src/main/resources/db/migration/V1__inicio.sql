-- MySQL dump 10.13  Distrib 8.0.19,
--
-- Host: 127.0.0.1    Database: test
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aeropuerto`
--

DROP TABLE IF EXISTS `aeropuerto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aeropuerto` (
                              `id` bigint NOT NULL,
                              `ciudad` varchar(255) DEFAULT NULL,
                              `codigo` varchar(255) DEFAULT NULL,
                              `nombre` varchar(255) DEFAULT NULL,
                              `pais` varchar(255) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aeropuerto`
--

LOCK TABLES `aeropuerto` WRITE;
/*!40000 ALTER TABLE `aeropuerto` DISABLE KEYS */;
INSERT INTO `aeropuerto` VALUES (6,'Madrid','MAD','Adolfo Suárez Madrid Barajas','España'),(7,'Barcelona','BCN','El Plat','España'),(8,'Dublin','DUB','Aeropuerto Dublin','Irlanda'),(9,'Sevilla','SVQ','Aeropuerto Sevilla','España'),(10,'Lavacolla','SCQ','Aeropuerto Santiago','España');
/*!40000 ALTER TABLE `aeropuerto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avion`
--

DROP TABLE IF EXISTS `avion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avion` (
                         `id` bigint NOT NULL,
                         `fabricante` varchar(255) DEFAULT NULL,
                         `horas_vuelo` bigint NOT NULL,
                         `matricula` varchar(255) DEFAULT NULL,
                         `modelo` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avion`
--

LOCK TABLES `avion` WRITE;
/*!40000 ALTER TABLE `avion` DISABLE KEYS */;
INSERT INTO `avion` VALUES (1,'Airbus',5000,'1111','A320'),(2,'Airbus',10000,'2222','A330'),(3,'Airbus',15000,'3333','A380'),(4,'Boeing',20000,'4444','737'),(5,'Boeing',50000,'5555','747');
/*!40000 ALTER TABLE `avion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (28),(28),(28),(28),(28),(28);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mecanico`
--

DROP TABLE IF EXISTS `mecanico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mecanico` (
                            `id` bigint NOT NULL,
                            `apellidos` varchar(255) DEFAULT NULL,
                            `codigo` varchar(255) DEFAULT NULL,
                            `nombre` varchar(255) DEFAULT NULL,
                            `anio` int NOT NULL,
                            `empresa` varchar(255) DEFAULT NULL,
                            `formacion` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mecanico`
--

LOCK TABLES `mecanico` WRITE;
/*!40000 ALTER TABLE `mecanico` DISABLE KEYS */;
INSERT INTO `mecanico` VALUES (19,'Ramos','1000','Alexis',2005,'Empresa 1','FP'),(20,'Marquez','2000','Rafa',2015,'Empresa 2','Ninguna'),(21,'Pérez','3000','María',2010,'Empresa 3','Ingeniería'),(22,'López','4000','Adela',2019,'Empresa 1','FP'),(23,'Ronda','5000','Ramón',2005,'Empresa 2','FP');
/*!40000 ALTER TABLE `mecanico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revision`
--

DROP TABLE IF EXISTS `revision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `revision` (
                            `id` bigint NOT NULL,
                            `descripcion` varchar(255) DEFAULT NULL,
                            `fecha_fin` datetime(6) DEFAULT NULL,
                            `fecha_inicio` datetime(6) DEFAULT NULL,
                            `horas_mecanico` double NOT NULL,
                            `tipo_revision` varchar(255) DEFAULT NULL,
                            `aeropuerto_id` bigint DEFAULT NULL,
                            `avion_id` bigint DEFAULT NULL,
                            `mecanico_encargado_id` bigint DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            KEY `FK5clx7t15sygeqxsqfxl57rpme` (`aeropuerto_id`),
                            KEY `FKepufjqvypljnk6si1dhtdcn3r` (`avion_id`),
                            KEY `FKnfdf2dp63kmvi73mvdd1tfa95` (`mecanico_encargado_id`),
                            CONSTRAINT `FK5clx7t15sygeqxsqfxl57rpme` FOREIGN KEY (`aeropuerto_id`) REFERENCES `aeropuerto` (`id`),
                            CONSTRAINT `FKepufjqvypljnk6si1dhtdcn3r` FOREIGN KEY (`avion_id`) REFERENCES `avion` (`id`),
                            CONSTRAINT `FKnfdf2dp63kmvi73mvdd1tfa95` FOREIGN KEY (`mecanico_encargado_id`) REFERENCES `mecanico` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revision`
--

LOCK TABLES `revision` WRITE;
/*!40000 ALTER TABLE `revision` DISABLE KEYS */;
INSERT INTO `revision` VALUES (24,'Descripción 1','2019-04-30 00:00:00.000000','2019-04-29 00:00:00.000000',150,'Revisión',6,1,19),(25,'Descripción 2','2020-11-15 00:00:00.000000','2020-10-12 00:00:00.000000',500,'Avería',6,2,19),(26,'Descripción 3','2015-03-01 00:00:00.000000','2015-02-01 00:00:00.000000',200,'Revisión',7,5,20),(27,'Descripción 4','2019-05-01 00:00:00.000000','2019-04-01 00:00:00.000000',600,'Revisión',7,5,21);
/*!40000 ALTER TABLE `revision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tripulante`
--

DROP TABLE IF EXISTS `tripulante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tripulante` (
                              `id` bigint NOT NULL,
                              `apellidos` varchar(255) DEFAULT NULL,
                              `codigo` varchar(255) DEFAULT NULL,
                              `nombre` varchar(255) DEFAULT NULL,
                              `compania` varchar(255) DEFAULT NULL,
                              `puesto` varchar(255) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tripulante`
--

LOCK TABLES `tripulante` WRITE;
/*!40000 ALTER TABLE `tripulante` DISABLE KEYS */;
INSERT INTO `tripulante` VALUES (12,'García','00001','Pedro','Iberia','Auxiliar'),(13,'Pérez','00002','María','Iberia','Piloto'),(15,'López','00003','Ana','Iberia','Comandante'),(17,'Blas','00004','Juan','Vueling','Piloto'),(18,'Martínez','00005','Andrés','Vueling','Auxiliar');
/*!40000 ALTER TABLE `tripulante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tripulante_vuelo`
--

DROP TABLE IF EXISTS `tripulante_vuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tripulante_vuelo` (
                                    `tripulante_id` bigint NOT NULL,
                                    `vuelo_id` bigint NOT NULL,
                                    PRIMARY KEY (`tripulante_id`,`vuelo_id`),
                                    KEY `FKdw8cu1wvtrl2kqslg4ey1pph5` (`vuelo_id`),
                                    CONSTRAINT `FK72ul3w9a15i2swg4kea9ku1jc` FOREIGN KEY (`tripulante_id`) REFERENCES `tripulante` (`id`),
                                    CONSTRAINT `FKdw8cu1wvtrl2kqslg4ey1pph5` FOREIGN KEY (`vuelo_id`) REFERENCES `vuelo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tripulante_vuelo`
--

LOCK TABLES `tripulante_vuelo` WRITE;
/*!40000 ALTER TABLE `tripulante_vuelo` DISABLE KEYS */;
INSERT INTO `tripulante_vuelo` VALUES (12,11),(13,11),(13,14),(15,14),(17,16),(18,16);
/*!40000 ALTER TABLE `tripulante_vuelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vuelo`
--

DROP TABLE IF EXISTS `vuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vuelo` (
                         `id` bigint NOT NULL,
                         `codigo` varchar(255) DEFAULT NULL,
                         `compania` varchar(255) DEFAULT NULL,
                         `duracion` double DEFAULT NULL,
                         `fecha_salida` datetime(6) DEFAULT NULL,
                         `avion_id` bigint NOT NULL,
                         `destino_id` bigint NOT NULL,
                         `origen_id` bigint NOT NULL,
                         PRIMARY KEY (`id`),
                         KEY `FK8j5widj67y5mcf830eqkvth2p` (`avion_id`),
                         KEY `FKnvtlv125kssq8a3dt0bdrm1lm` (`destino_id`),
                         KEY `FKkbrspynyr16o6kreury553afl` (`origen_id`),
                         CONSTRAINT `FK8j5widj67y5mcf830eqkvth2p` FOREIGN KEY (`avion_id`) REFERENCES `avion` (`id`),
                         CONSTRAINT `FKkbrspynyr16o6kreury553afl` FOREIGN KEY (`origen_id`) REFERENCES `aeropuerto` (`id`),
                         CONSTRAINT `FKnvtlv125kssq8a3dt0bdrm1lm` FOREIGN KEY (`destino_id`) REFERENCES `aeropuerto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vuelo`
--

LOCK TABLES `vuelo` WRITE;
/*!40000 ALTER TABLE `vuelo` DISABLE KEYS */;
INSERT INTO `vuelo` VALUES (11,'IB111','Iberia',0.5,'2020-04-29 00:00:00.000000',1,7,6),(14,'IB222','Iberia',2.5,'2020-12-05 00:00:00.000000',2,9,8),(16,'VU111','Vueling',1.5,'2021-02-05 00:00:00.000000',5,10,9);
/*!40000 ALTER TABLE `vuelo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-10 10:32:29
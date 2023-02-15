-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: demojwt2
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `bookingjournal`
--

DROP TABLE IF EXISTS `bookingjournal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookingjournal` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `room_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeelvxwf9pfafotdcrbvf015u` (`room_id`),
  KEY `FKs7h4v5a6j6nhl17g99r3sbt2` (`user_id`),
  CONSTRAINT `FKeelvxwf9pfafotdcrbvf015u` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  CONSTRAINT `FKs7h4v5a6j6nhl17g99r3sbt2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookingjournal`
--

LOCK TABLES `bookingjournal` WRITE;
/*!40000 ALTER TABLE `bookingjournal` DISABLE KEYS */;
INSERT INTO `bookingjournal` VALUES (26,'2023-01-26','2023-01-28',232,2,2),(39,'2023-01-27','2023-01-31',300,3,1),(41,'2023-01-27','2023-01-31',300,5,9),(44,'2023-01-27','2023-01-31',300,4,7),(45,'2023-01-27','2023-01-31',300,4,7),(46,'2023-01-27','2023-01-31',300,4,7),(47,'2023-01-27','2023-01-31',300,4,7),(48,'2023-01-17','2023-01-18',300,1,1),(49,'2023-02-02','2023-04-06',300,3,2),(59,'2023-01-07','2023-01-31',300,3,1),(60,'2023-01-02','2023-01-18',300,4,5),(61,'2023-01-01','2023-01-09',300,4,43),(62,'2023-02-08','2023-02-21',300,1,1),(63,'2023-01-11','2023-02-28',300,1,1),(64,'2023-02-09','2023-03-09',300,1,1),(65,'2023-02-16','2023-03-01',300,1,1),(66,'2023-02-03','2023-02-16',300,1,1),(67,'2023-02-10','2023-02-14',300,1,1),(68,'2023-02-21','2023-02-23',300,2,1),(69,'2023-02-01','2023-02-09',300,1,1),(70,'2023-02-14','2023-02-21',300,1,1),(71,'2023-02-03','2023-02-07',300,1,1),(72,'2023-02-03','2023-02-07',300,1,1),(73,'2023-02-03','2023-02-07',300,1,1),(74,'2023-02-03','2023-02-09',300,1,1),(75,'2023-02-03','2023-02-09',300,1,1),(76,'2023-02-04','2023-02-28',300,1,1),(77,'2023-02-03','2023-03-04',300,2,1),(78,'2023-01-12','2023-01-17',300,1,1),(79,'2023-03-30','2023-04-11',300,1,1),(80,'2023-03-22','2023-04-18',300,2,1),(81,'2023-02-11','2023-03-02',300,1,1),(82,'2023-02-02','2023-02-21',300,1,1),(83,'2023-02-13','2023-02-22',300,1,1),(84,'2023-01-10','2023-01-18',300,1,1),(85,'2023-02-04','2023-02-14',300,1,1),(86,'2023-02-04','2023-02-14',300,1,1),(87,'2023-02-04','2023-02-14',300,1,1),(88,'2023-02-09','2023-02-22',300,1,1),(89,'2023-02-10','2023-03-08',300,1,1),(90,'2023-02-03','2023-02-16',300,1,1),(95,'2023-02-07','2023-02-09',250,1,1),(96,'2023-02-07','2023-02-09',250,1,1),(97,'2023-02-08','2023-02-28',600,4,1),(98,'2023-02-07','2023-03-08',250,1,1),(107,'2023-02-09','2023-02-12',750,1,1),(108,'2023-02-09','2023-02-12',870,2,1),(109,'2023-02-13','2023-02-18',1450,2,1),(110,'2023-02-09','2023-02-14',15000,19,51),(111,'2023-02-09','2023-02-10',250,1,1);
/*!40000 ALTER TABLE `bookingjournal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_room` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'KINGROOM'),(2,'LUXURYROOM'),(3,'NORMALROOM');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `features`
--

DROP TABLE IF EXISTS `features`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `features` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `feature_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmilvkv0w7f6us56wwclrin8pv` (`feature_id`),
  CONSTRAINT `FKmilvkv0w7f6us56wwclrin8pv` FOREIGN KEY (`feature_id`) REFERENCES `bookingjournal` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `features`
--

LOCK TABLES `features` WRITE;
/*!40000 ALTER TABLE `features` DISABLE KEYS */;
INSERT INTO `features` VALUES (1,'BreakFast',10,NULL),(2,'Lunch',20,NULL),(3,'Dinner',20,NULL);
/*!40000 ALTER TABLE `features` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_USER'),(2,'ROLE_MODERATOR'),(3,'ROLE_ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `available` int NOT NULL,
  `number` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `category_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKllkgnps1iryk3347aokxwbxxm` (`category_id`),
  CONSTRAINT `FKllkgnps1iryk3347aokxwbxxm` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,1,'10 ',250,1),(2,1,'20',290,2),(3,1,'23',300,3),(4,10,'30',600,3),(5,1,'34',700,1),(6,1,'40',1000,1),(11,2,'room-10 ',3000,3),(12,1,'room-10 ',3000,3),(13,1,'room-10 ',3000,2),(18,1,'room-10 ',3000,3),(19,1,'room-10 ',3000,3),(20,1,'room-10 ',3000,3),(21,1,'VuaCuaHaLoi',300,1),(22,1,'Room01',321,2);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK4bakctviobmdk6ddh2nwg08c2` (`username`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'bachmai','az90931@gmail.com','$2a$12$SF3Nff3C2F6WdYX7l4WDMOjgqfrGFp0a5wQdbXBwhJWA8KHuwoWAG','30000000','adiuqea'),(2,'haiphongcity','cacssc@mmaf','az9098312','231412','dungdsd12'),(4,'hanoi','123142@gmai.com','ancucboo','123124','qeanh2'),(5,'hanoi','12314@dasdgmai.com','ancucboo','123124','qeandsadh'),(7,'hanoi','eghj@damai.com','adasddasds','123124','abcd'),(8,'kobietodau','azbc@gmail.com','$2a$10$O1bmYvwqJak4Rcmmx9vjNuYfveOf71/r6GD05RNYiJWOJb4UJ6Eey','12345nham','duxn'),(9,'kobietodau','azbaac@gmail.com','$2a$10$pv/g/QbbI7zpyztP4c1DGOiANw3oPF5C0bZXRyt7osASeMOjNHGf.','12345nham','duxnaa'),(10,'kobietodau','azbaac@agmail.com','$2a$10$/bWAjvzhvdm1ABFHbzohD.qPsoOQdDyFEoFpZz7.NjSD60DL4Q41y','12345nham','duxnaaa'),(11,'kobietodau','azbaaac@agmail.com','$2a$10$uECdgPkilRoTu5xcfRD.aeWvAlN2I6fBPSGPnBj2eYASBSVv.Hxpy','12345nham','duxnaaaa'),(12,'kobietodau','azccaac@agmail.com','$2a$10$4EmcRTlqrRSLIvnQt.S/5Oai5NrMuO5oW6COY8TEgSm09VvLdp4Pu','12345nham','duaccaa'),(13,'kobietodau','azccee@agmail.com','$2a$10$RbXG4FPlhjTnKJ29.UpBwOmI.uOSGhvVVaTHApq0KxZ6y/hiyOPk.','12345nham','dueecaa'),(14,'kobietodau','azccose@agmail.com','$2a$10$g7dT/f04/dk0EXQ5DMW9iusbEWU5vymFE5vL1Dte7iWKZn6CwOhRC','12345nham','dueoecaaa'),(15,'kobietodau','azccose@agmfsil.com','$2a$10$oK3DbfxPa.FMb9S3mUrQ6.obgAgwgU7l3nMBRMyE.NWNa6Lq6HEWO','12345nham','dueoefsaa'),(16,'kobietodau','ose@agmfsil.com','$2a$10$c6ynhx6Oznq3Kq0BT/ZxC.sePBZGenYx0X/aqg8UL6dnBYcWI5dQi','12345nham','oefsaa'),(17,'kobietodau','ose@gmail.com','$2a$10$cHDa3yUFc271lDoQk5Dq7ew6NeWm1/K/G4kvsnODoBjHX/rN2n7/u','12345nham','az9098312'),(18,'kobietodau','ose@ail.com','$2a$10$GK/yzKELOUmGuGFkIrj.ceJGvgVOIEQUvsZe2ZwDAhlZ4YjmO.x9C','12345nham','az909812'),(19,'kobietodau','ose@ail3.com','$2a$10$pH43qgLlmjn/Hdu8MdcxbekcqtS21IJYsS3WDMx0SnabPMBir3Z3i','12345nham','az9098123'),(21,'kobietodau','osses@ail3.com','$2a$10$KVpHxDyfsx2dpiQVsgvEXet.dTSZ3COVd3NnZofZH81rDnFsdhA6i','12345nham','az81223'),(22,'kobietodau','osse2s@ail3.com','$2a$10$gQcy8XEwY5cdInOH1GgxEu4WIVB6gOI.8Fzl.dlBKda2u6.KpdLNe','12345nham','az812223'),(27,'kobietodau','test3@dail3.com','$2a$10$ZsqAuMMzLAcR2bvXOXijE.QYBnZ3hAtR6z7Z7aJFm4FWkdjGoX.k2','12345nham','test3'),(28,'kobietodau','test4@dail3.com','$2a$10$pHiVTCIF8tCU4TFMHjq22udN1MFpNdTk9YGd0lA3dDMZNr0o74SAG','12345nham','test4'),(29,'kobietodau','test5@dail3.com','$2a$10$/fKiNKXBCzZR3ef6nBwoJuPkQnCOiwmAUpZzl4bvIAiMomnd3qRM.','12345nham','test5'),(30,'kobietodau','test6@dail3.com','$2a$10$eERcVjH1Ra3K.SPIlGcfX.Rdzege2jV9JfS74t0q3.6EBkFtb7RiC','12345nham','test6'),(31,'kobietodau','test7@dail3.com','$2a$10$Kq81gE9X4tB2IpoWAnxtX./mmpmv7hvhvJ92MVNO9mf2SYMYgucxa','12345nham','test7'),(32,'kobietodau','test8@dail3.com','$2a$10$9wQzkX4vK3xC6lgKcHGpje8s490F0SKG1vJNRuaVu30T9Y8YVLIrO','12345nham','test8'),(33,'thaibinh','azm@gmail.com','$2a$10$D1jE/z1e1s0/EczAi4gakuAM6qYOAoENF5tm7XwDBpPjCHD/JKg7.','421412','dungdasd1'),(36,'dds','312@fas','$2a$10$/xMNjCU04cz13hiMzMWD6eIKSimJhbns/qvS.RMmrHkklCa4l/s6a','13123','dung16'),(37,'hanoi','az12378@gmail.com','$2a$10$KT3vqR8tGdWi0x.CE5Wxge.HuY9iJjjxMuAqb9NDNjPOA1KosTtei','12345678','dung12378'),(38,'dds','test8@test','$2a$10$TsVjOP1zjMOd/NC1NEAoyuzdtDDZK1j9fuUkiRrPOxRkyEbf3IoK2','13123','test9'),(40,'hanoi','abcxyzxx@gmail.com','$2a$10$CGAyUszhm6gZRjCxUY66y.da8eK20e1bp/i60i4t9XS/K/cbuoN3q','31231231234','sunrang00'),(43,'hanoi','ydsdasz@gmail.com','$2a$10$uHpUt1ZqkpXyDXH3SfQmce8wFbZQVCnUuFxV1F6qjzHwkzLVawRL6','3123123123','sunrang001'),(44,'hanoi','az909312@gmail.com','$2a$10$qRy6zXd0EAX/E0Vs1q.YYOnlWkf2A8E3pQ4jzl3Gv5ehNEUTfVtJW','3123123123','sunrang001dung'),(45,'hanoi','az9093122@gmail.com','$2a$10$lLoaTdy/UeYDqQP5JTUjhO1k60Ta1fxeZ34qE7uOpLuOZ22PzAN3W','3123123123','sunrang001dung3'),(46,'hanoi','abcxyzdsa@gmail.com','$2a$10$xUnqMPtiAfgvUvY1ZtP0wewR2xUVmSjPRuGv3p.StVuAfKLRH6QL6','3123123123','sunrang0032312'),(47,'hanoi','abcxaaxyz@gmail.com','$2a$10$bxJ10nxmBoyGjf8T1ZTxI.MHAUbVOy30ezyFgnv4Y6W5gWsxXbUTW','3123123123','aaaaaaaaaaaa1'),(48,'hanoi','abaacxyzxx@gmail.com','$2a$10$88XgCg/ciSbkXHMaqYPIEO5boCHokIr/t0bSq9yzNuzFceHPoofxO','3123123123','dung163123a'),(49,'hanoi','az909831@dasdasd','$2a$10$GMjREVycb0MlGAeDX6CUtefPgL08PiTtz8zszcKh0u3jvMwJKyylu','3123123123','aaaaaa211231'),(51,'hanoi','abcxydz23@gmail.com','$2a$10$2gfOb8zlAw5zYueb/7b52ug27zigwMnQsmRK/mJhIlX8qlBvLC3wy','3123123123','sunra0032132'),(60,'hanoi','abcxdasfww@gmail.com','$2a$10$diYpX.JnjODxgo6ohMxEVO4272xDhnwGqwOmkS7ApyI5IprZemnTy','3123123123','adiuqea123'),(61,'socson','adc909831@gmail.com','$12$SF3Nff3C2F6WdYX7l4WDMOjgqfrGFp0a5wQdbXBwhJWA8KHuwoWAG','0326593793','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (4,1),(5,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(17,1),(18,1),(19,1),(21,1),(22,1),(27,1),(28,1),(30,1),(31,1),(33,1),(36,1),(37,1),(38,1),(40,1),(43,1),(44,1),(45,1),(46,1),(47,1),(48,1),(49,1),(51,1),(60,1),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(31,2),(32,2),(1,3),(29,3),(30,3),(61,3);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-15 21:47:03

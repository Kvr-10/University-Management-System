CREATE DATABASE  IF NOT EXISTS `universitymanagement` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `universitymanagement`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: universitymanagement
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

--
-- Table structure for table `fee`
--

DROP TABLE IF EXISTS `fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fee` (
  `Semester` varchar(20) DEFAULT NULL,
  `BTech` int DEFAULT NULL,
  `MTech` int DEFAULT NULL,
  `Msc` int DEFAULT NULL,
  `Mca` int DEFAULT NULL,
  `Mcom` int DEFAULT NULL,
  `MA` int DEFAULT NULL,
  `BBA` int DEFAULT NULL,
  `Bsc` int DEFAULT NULL,
  `Bca` int DEFAULT NULL,
  `Bcom` int DEFAULT NULL,
  `BA` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee`
--

LOCK TABLES `fee` WRITE;
/*!40000 ALTER TABLE `fee` DISABLE KEYS */;
INSERT INTO `fee` VALUES ('1st Semester',50000,45000,48000,48000,48000,48000,47000,46000,48000,48000,48000),('2nd Semester',52000,46000,49000,49000,49000,49000,48000,47000,49000,49000,49000),('3rd Semester',54000,47000,50000,50000,50000,50000,49000,48000,50000,50000,50000),('4th Semester',56000,48000,51000,51000,51000,51000,50000,49000,51000,51000,51000),('5th Semester',58000,NULL,NULL,NULL,NULL,NULL,51000,50000,52000,52000,52000),('6th Semester',60000,NULL,NULL,NULL,NULL,NULL,52000,51000,53000,53000,53000),('7th Semester',62000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('8th Semester',64000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `fee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feepaid`
--

DROP TABLE IF EXISTS `feepaid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feepaid` (
  `Name` varchar(30) DEFAULT NULL,
  `Roll_No` bigint DEFAULT NULL,
  `Course` varchar(30) DEFAULT NULL,
  `Branch` varchar(30) DEFAULT NULL,
  `Semester` varchar(20) DEFAULT NULL,
  `Fee_Paid` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feepaid`
--

LOCK TABLES `feepaid` WRITE;
/*!40000 ALTER TABLE `feepaid` DISABLE KEYS */;
INSERT INTO `feepaid` VALUES ('Chaman Sinha',20241111,'BTech','Computer Engg','4th Semester',56000),('Chaman Sinha',20241111,'BTech','Computer Engg','5th Semester',58000),('ads',20243221,'Bcom','Ece','4th Semester',51000);
/*!40000 ALTER TABLE `feepaid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('kvr10','admin');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marks`
--

DROP TABLE IF EXISTS `marks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marks` (
  `Name` varchar(30) DEFAULT NULL,
  `Roll_No` bigint DEFAULT NULL,
  `Semester` varchar(30) DEFAULT NULL,
  `1st_Sub_Marks` int DEFAULT NULL,
  `2nd_Sub_Marks` int DEFAULT NULL,
  `3rd_Sub_Marks` int DEFAULT NULL,
  `4th_Sub_Marks` int DEFAULT NULL,
  `5th_Sub_Marks` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marks`
--

LOCK TABLES `marks` WRITE;
/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
INSERT INTO `marks` VALUES ('Chaman Sinha',20241111,'4th Semester',100,80,90,100,90);
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stdleave`
--

DROP TABLE IF EXISTS `stdleave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stdleave` (
  `Name` varchar(30) DEFAULT NULL,
  `Date` varchar(20) DEFAULT NULL,
  `Duration` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stdleave`
--

LOCK TABLES `stdleave` WRITE;
/*!40000 ALTER TABLE `stdleave` DISABLE KEYS */;
INSERT INTO `stdleave` VALUES ('Chaman Sinha','29-Jul-2024','Full Day'),('Krishna Sinha','15-Aug-2024','Half Day'),('Chaman Sinha','30-Jul-2024','Full Day');
/*!40000 ALTER TABLE `stdleave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `Name` varchar(40) DEFAULT NULL,
  `Fathers_name` varchar(40) DEFAULT NULL,
  `Roll_No` bigint DEFAULT NULL,
  `DOB` varchar(20) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Phone` bigint DEFAULT NULL,
  `Email` varchar(40) DEFAULT NULL,
  `Class_X` int DEFAULT NULL,
  `Class_XII` int DEFAULT NULL,
  `Aadhar_Number` bigint DEFAULT NULL,
  `Course` varchar(40) DEFAULT NULL,
  `Branch` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('Chaman Sinha','KP Sinha',20241111,'09-Jul-2024','C-108,Little Hearts,Pune',7905307832,'Chamansinha9480@gmail.com',89,73,7,'B.Tech','Computer Engg'),('Krishna Sinha','Kameshwar Prasad Sinha',20241533,'01-Mar-2004','C108,Liitle Heart, Pune',8318803241,'krishnas88920@gmail.com',94,91,246824682468,'B.Tech','IT'),('cac','cacas',20245863,'10-Jul-2024','casca',1010101,'acssa@123',32,32,131231,'MVS','Computer Science Engg'),('ads','ads',20243221,'10-Jul-2024','ads',2313,'caaaaaaaaf@',2,13,131,'Msc','Ece');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `Name` varchar(30) DEFAULT NULL,
  `Roll_No` bigint DEFAULT NULL,
  `Semester` varchar(30) DEFAULT NULL,
  `1st_Subject` varchar(40) DEFAULT NULL,
  `2nd_Subject` varchar(40) DEFAULT NULL,
  `3rd_Subject` varchar(40) DEFAULT NULL,
  `4th_Subject` varchar(40) DEFAULT NULL,
  `5th_Subject` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES ('Chaman Sinha',20241111,'4th Semester','P&S','MOC','COS','WC','DBMS');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `Name` varchar(40) DEFAULT NULL,
  `Fathers_name` varchar(40) DEFAULT NULL,
  `ID` bigint DEFAULT NULL,
  `DOB` varchar(20) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Phone` bigint DEFAULT NULL,
  `Email` varchar(40) DEFAULT NULL,
  `Class_X` int DEFAULT NULL,
  `Class_XII` int DEFAULT NULL,
  `Aadhar_Number` bigint DEFAULT NULL,
  `Qualification` varchar(40) DEFAULT NULL,
  `Department` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('Kaviraj','KPS',42021304,'01-Feb-1996','65/4 AFS,Bangalore',8892054768,'kaviraj.10kvr@gmail.com',94,81,363254329807,'M.Tech','Computer Science Engg'),('Kraj','KPS',42022131,'01-Jul-2024','Vimannagar',9482970933,'zanonzn@gmail.com',90,92,1234534654454,'Failed','Entc'),('KP Sinha','L.B.Lal',42025952,'10-Oct-2000','Chandigarh',9482970933,'sinhakp.sinha@gmail.com',98,97,241471278401,'Mca','IT');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacherleave`
--

DROP TABLE IF EXISTS `teacherleave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacherleave` (
  `Name` varchar(30) DEFAULT NULL,
  `Date` varchar(20) DEFAULT NULL,
  `Duration` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacherleave`
--

LOCK TABLES `teacherleave` WRITE;
/*!40000 ALTER TABLE `teacherleave` DISABLE KEYS */;
INSERT INTO `teacherleave` VALUES ('Kaviraj','31-Jul-2024','Full Day'),('Kraj','27-Jul-2024','Full Day'),('KP Sinha','31-Jul-2024','Full Day'),('KP Sinha','31-Jul-2024','Full Day');
/*!40000 ALTER TABLE `teacherleave` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-09  1:02:51

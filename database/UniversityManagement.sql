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
INSERT INTO `feepaid` VALUES ('Chaman Sinha',20241111,'BTech','Computer Engg','4th Semester',56000),('Chaman Sinha',20241111,'BTech','Computer Engg','5th Semester',58000),('ads',20243221,'Bcom','Ece','4th Semester',51000),('Krishna Sinha',20241533,'BTech','IT','2nd Semester',52000),('Nikhil Deshmukh',20240020,'BCA','Data Science','4th Semester',51000);
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
INSERT INTO `student` VALUES ('Chaman Sinha','KP Sinha',20241111,'09-Jul-2024','C-108,Little Hearts,Pune',7905307832,'Chamansinha9480@gmail.com',89,73,7,'BTech','Computer Engg'),('Krishna Sinha','Kameshwar Prasad Sinha',20241533,'01-Mar-2004','C108,Liitle Heart, Pune',8318803241,'krishnas88920@gmail.com',94,91,246824682468,'BTech','IT'),('Sonali','RK Singh',20246452,'18-Aug-2005','Airforce',7997293733,'abc@gmail.com',90,80,101412456723,'BTech','Entc'),('Rahul Sharma','Ajay Sharma',20240001,'2002-01-15','123 Main St, City A',9876543210,'rahul.sharma@example.com',86,88,123456789012,'BTech','CSE'),('Anjali Gupta','Ramesh Gupta',20240002,'2001-05-20','456 Park Ave, City B',9876543211,'anjali.gupta@example.com',90,89,234567890123,'MTech','ECE'),('Saurav Kumar','Vijay Kumar',20240003,'2001-11-12','789 Elm St, City C',9876543212,'saurav.kumar@example.com',82,85,345678901234,'MSc','Mathematics'),('Nidhi Singh','Karan Singh',20240004,'2002-03-05','321 Oak St, City D',9876543213,'nidhi.singh@example.com',88,91,456789012345,'MCA','Software Engineering'),('Amit Verma','Mohan Verma',20240005,'2000-12-10','654 Maple St, City E',9876543214,'amit.verma@example.com',88,86,567890123456,'MCom','Finance'),('Priya Desai','Rajesh Desai',20240006,'2001-07-18','987 Pine St, City F',9876543215,'priya.desai@example.com',91,92,678901234567,'MA','English'),('Arjun Patel','Suresh Patel',20240007,'2000-08-22','432 Cedar St, City G',9876543216,'arjun.patel@example.com',87,89,789012345678,'BBA','Management'),('Megha Chawla','Ravi Chawla',20240008,'2001-09-30','765 Spruce St, City H',9876543217,'megha.chawla@example.com',89,91,890123456789,'BSc','Biology'),('Rohit Mehta','Vikas Mehta',20240009,'2002-04-04','213 Willow St, City I',9876543218,'rohit.mehta@example.com',86,87,901234567890,'BCA','Computer Applications'),('Simran Kaur','Harjit Kaur',20240010,'2001-06-15','678 Birch St, City J',9876543219,'simran.kaur@example.com',92,92,12345678901,'BCom','Commerce'),('Vikram Joshi','Dinesh Joshi',20240011,'2000-02-11','145 Redwood St, City K',9876543220,'vikram.joshi@example.com',87,89,112345678901,'BA','History'),('Sneha Roy','Arun Roy',20240012,'2002-10-28','987 Cedar St, City L',9876543221,'sneha.roy@example.com',91,92,212345678901,'BTech','ECE'),('Rajiv Rathi','Mahesh Rathi',20240013,'2001-12-25','321 Poplar St, City M',9876543222,'rajiv.rathi@example.com',88,90,312345678901,'MTech','Mechanical'),('Alok Jain','Sunil Jain',20240014,'2000-01-02','543 Aspen St, City N',9876543223,'alok.jain@example.com',87,88,412345678901,'MSc','Chemistry'),('Kavita Kapoor','Anil Kapoor',20240015,'2001-04-18','876 Oak St, City O',9876543224,'kavita.kapoor@example.com',92,91,512345678901,'MCA','Networking'),('Gaurav Pandey','Ramesh Pandey',20240016,'2002-11-22','234 Maple St, City P',9876543225,'gaurav.pandey@example.com',85,88,612345678901,'MCom','Accounting'),('Pooja Saxena','Amit Saxena',20240017,'2000-09-09','765 Spruce St, City Q',9876543226,'pooja.saxena@example.com',90,90,712345678901,'BA','Sociology'),('Manish Yadav','Suraj Yadav',20240018,'2002-08-14','876 Willow St, City R',9876543227,'manish.yadav@example.com',87,90,812345678901,'BA','Mechanical'),('Ritika Aggarwal','Vijay Aggarwal',20240019,'2001-07-05','654 Birch St, City S',9876543228,'ritika.aggarwal@example.com',90,92,912345678901,'BSc','Physics'),('Nikhil Deshmukh','Satish Deshmukh',20240020,'2000-03-03','543 Cedar St, City T',9876543229,'nikhil.deshmukh@example.com',88,90,123456789012,'BCA','Data Science');
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
INSERT INTO `teacher` VALUES ('Kaviraj','KPS',42021304,'01-Feb-1996','65/4 AFS,Bangalore',8892054768,'kaviraj.10kvr@gmail.com',94,81,363254329807,'Bca','Computer Science Engg'),('Kraj','KPS',42022131,'01-Jul-2024','Vimannagar',9482970933,'zanonzn@gmail.com',90,92,1234534654454,'MTech','Entc'),('KP Sinha','L.B.Lal',42025952,'10-Oct-2000','Chandigarh',9482970933,'sinhakp.sinha@gmail.com',98,97,241471278401,'Mca','IT'),('Aarav Patel','Ramesh Patel',42020001,'2002-01-15','123 Main St, City A',9876543210,'aarav.patel@example.com',86,88,123456789012,'BTech','CSE'),('Aditi Sharma','Rajesh Sharma',42020002,'2001-05-20','456 Park Ave, City B',9876543211,'aditi.sharma@example.com',90,89,234567890123,'MTech','ECE'),('Arjun Singh','Vijay Singh',42020003,'2001-11-12','789 Elm St, City C',9876543212,'arjun.singh@example.com',82,85,345678901234,'MSc','Mathematics'),('Bhavya Jain','Mohan Jain',42020004,'2002-03-05','321 Oak St, City D',9876543213,'bhavya.jain@example.com',88,91,456789012345,'MCA','Software Engineering'),('Chetan Verma','Suresh Verma',42020005,'2000-12-10','654 Maple St, City E',9876543214,'chetan.verma@example.com',88,86,567890123456,'MCom','Finance'),('Diya Gupta','Amit Gupta',42020006,'2001-07-18','987 Pine St, City F',9876543215,'diya.gupta@example.com',91,92,678901234567,'MA','English'),('Eshan Rao','Ravi Rao',42020007,'2000-08-22','432 Cedar St, City G',9876543216,'eshan.rao@example.com',87,89,789012345678,'BBA','Management'),('Fiona Mehta','Karan Mehta',42020008,'2001-09-30','765 Spruce St, City H',9876543217,'fiona.mehta@example.com',89,91,890123456789,'BSc','Biology'),('Gaurav Desai','Rajesh Desai',42020009,'2002-04-04','213 Willow St, City I',9876543218,'gaurav.desai@example.com',86,87,901234567890,'BCA','Computer Applications'),('Harshita Singh','Sunil Singh',42020010,'2001-06-15','678 Birch St, City J',9876543219,'harshita.singh@example.com',92,92,12345678901,'BCom','Commerce'),('Ishaan Kumar','Vikram Kumar',42020011,'2000-02-11','145 Redwood St, City K',9876543220,'ishaan.kumar@example.com',87,89,112345678901,'BA','History'),('Jia Patel','Arun Patel',42020012,'2002-10-28','987 Cedar St, City L',9876543221,'jia.patel@example.com',91,92,212345678901,'BTech','ECE'),('Karan Joshi','Deepak Joshi',42020013,'2001-12-25','321 Poplar St, City M',9876543222,'karan.joshi@example.com',88,90,312345678901,'MTech','Mechanical'),('Lina Rathi','Mohan Rathi',42020014,'2000-01-02','543 Aspen St, City N',9876543223,'lina.rathi@example.com',87,88,412345678901,'MSc','Chemistry'),('Mohan Kapoor','Ravi Kapoor',42020015,'2001-04-18','876 Oak St, City O',9876543224,'mohan.kapoor@example.com',92,91,512345678901,'MCA','Networking'),('Nina Agarwal','Rajiv Agarwal',42020016,'2002-11-22','234 Maple St, City P',9876543225,'nina.agarwal@example.com',85,88,612345678901,'MCom','Accounting'),('Omar Chauhan','Sanjay Chauhan',42020017,'2000-09-09','765 Spruce St, City Q',9876543226,'omar.chauhan@example.com',90,90,712345678901,'BA','Sociology'),('Pooja Arora','Anil Arora',42020018,'2002-08-14','876 Willow St, City R',9876543227,'pooja.arora@example.com',87,90,812345678901,'BTech','Mechanical'),('Qasim Khan','Faisal Khan',42020019,'2001-07-05','654 Birch St, City S',9876543228,'qasim.khan@example.com',90,92,912345678901,'BSc','Physics'),('Riya Sharma','Vikram Sharma',42020020,'2000-03-03','543 Cedar St, City T',9876543229,'riya.sharma@example.com',88,90,123456789012,'BCA','Data Science');
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

-- Dump completed on 2024-08-14 23:29:38

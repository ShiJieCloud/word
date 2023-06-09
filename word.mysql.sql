/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.28 : Database - word
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`word` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `word`;

/*Table structure for table `tag` */

DROP TABLE IF EXISTS `tag`;

CREATE TABLE `tag` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id，主键',
  `name` varchar(50) DEFAULT NULL COMMENT '标签名',
  `create_time` datetime DEFAULT NULL COMMENT '插入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tag` */

insert  into `tag`(`id`,`name`,`create_time`) values 
(1,'励志','2023-06-09 17:30:48'),
(2,'爱情','2023-06-09 17:30:55');

/*Table structure for table `word` */

DROP TABLE IF EXISTS `word`;

CREATE TABLE `word` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键，id',
  `content` text COMMENT '美句内容',
  `excerpt` varchar(100) DEFAULT NULL COMMENT '节选',
  `create_time` datetime DEFAULT NULL COMMENT '插入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `word` */

insert  into `word`(`id`,`content`,`excerpt`,`create_time`) values 
(1,'人生如一场修行，得意时，”一日看尽长安花”，艰难时，“潦倒新停浊酒杯”。','经典永流传','2023-06-09 17:09:47'),
(2,'金子闪光，然而闪光的并不一定都是金子；美的东西都是出类拔萃的东西，但并非所有出类拔萃的东西都是美的。','经典永流传','2023-06-09 17:09:47'),
(3,'天为盖，地为炉，千古铸剑踏江湖。神作将，仙作兵，万世争雄我为君。','经典永流传','2023-06-09 17:09:47');

/*Table structure for table `word_tag` */

DROP TABLE IF EXISTS `word_tag`;

CREATE TABLE `word_tag` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `word_id` int DEFAULT NULL COMMENT '外键，word id',
  `tag_id` int DEFAULT NULL COMMENT '外键，tag id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `word_tag` */

insert  into `word_tag`(`id`,`word_id`,`tag_id`,`create_time`) values 
(1,1,1,'2023-06-09 17:31:24'),
(2,1,2,'2023-06-09 17:31:30'),
(3,2,1,'2023-06-09 17:31:24'),
(4,3,2,'2023-06-09 17:31:30');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

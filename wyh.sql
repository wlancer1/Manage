/*
SQLyog v10.2 
MySQL - 5.5.30 : Database - shujub
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shujub` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shujub`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` char(20) NOT NULL,
  `password` char(20) DEFAULT NULL,
  `power` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`account`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`account`,`password`,`power`) values (6,'account','7a57a5a743894a0e',1),(7,'123456','c15263e6b2c11344',1),(8,'admin','7a57a5a743894a0e',1);

/*Table structure for table `detailorder` */

DROP TABLE IF EXISTS `detailorder`;

CREATE TABLE `detailorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `onum` int(11) NOT NULL COMMENT '消费记录ID',
  `wareid` int(11) NOT NULL,
  `warenum` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `onum` (`onum`),
  KEY `wareid` (`wareid`),
  CONSTRAINT `detailorder_ibfk_1` FOREIGN KEY (`onum`) REFERENCES `order1` (`onum`),
  CONSTRAINT `detailorder_ibfk_2` FOREIGN KEY (`wareid`) REFERENCES `ware` (`fId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `detailorder` */

insert  into `detailorder`(`id`,`onum`,`wareid`,`warenum`) values (1,1,2,2),(2,1,4,2),(3,2,4,3);

/*Table structure for table `order1` */

DROP TABLE IF EXISTS `order1`;

CREATE TABLE `order1` (
  `onum` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `otime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '订单时间',
  `sid` int(11) NOT NULL COMMENT '商铺id',
  `stime` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '发货时间',
  `oremark` varbinary(80) DEFAULT NULL COMMENT '订单备注',
  `uid` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`onum`),
  KEY `order1_ibfk_3` (`sid`),
  KEY `uid` (`uid`),
  CONSTRAINT `order1_ibfk_3` FOREIGN KEY (`sid`) REFERENCES `shop` (`sid`),
  CONSTRAINT `order1_ibfk_4` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `order1` */

insert  into `order1`(`onum`,`otime`,`sid`,`stime`,`oremark`,`uid`) values (1,'2017-08-15 09:51:59',0,'2017-08-28 09:52:12',NULL,2),(2,'2017-08-08 12:54:24',3,'2017-08-23 12:54:33',NULL,3);

/*Table structure for table `shop` */

DROP TABLE IF EXISTS `shop`;

CREATE TABLE `shop` (
  `sid` int(5) NOT NULL AUTO_INCREMENT,
  `name` char(11) NOT NULL,
  `uid` int(5) NOT NULL,
  PRIMARY KEY (`sid`,`uid`),
  UNIQUE KEY `name` (`name`),
  KEY `uid` (`uid`),
  CONSTRAINT `shop_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `shop` */

insert  into `shop`(`sid`,`name`,`uid`) values (0,'meimei',1),(3,'meimei2',1);

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(8) NOT NULL COMMENT '名字',
  `tremark` varbinary(80) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`typeid`,`type`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `type` */

insert  into `type`(`typeid`,`type`,`tremark`) values (2,'双子类','11'),(3,'叶子类','32'),(4,'水果','1'),(5,'花类','22'),(6,'蕨类','123'),(7,'双子叶',NULL),(15,'双子类2',NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` int(5) NOT NULL AUTO_INCREMENT,
  `username` char(20) NOT NULL,
  `password` char(20) DEFAULT NULL,
  `email` char(20) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `address` char(30) DEFAULT NULL,
  `status` int(2) DEFAULT '0',
  `power` int(2) DEFAULT '0',
  `remark` varbinary(30) DEFAULT NULL,
  `sid` int(11) NOT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uid`,`username`,`password`,`email`,`phone`,`address`,`status`,`power`,`remark`,`sid`) values (1,'michealy2',NULL,'294634047@qq.com',132312324,'ssdsd',0,1,'32eweq',0),(2,'努努2','346993nunu','160063@qq.com',66360691,NULL,0,0,NULL,0),(3,'努努3','142658nunu','219309@qq.com',41572232,NULL,0,0,NULL,0),(4,'努努4','230688nunu','617098@qq.com',3168743,NULL,0,0,NULL,0),(5,'努努5','446250nunu','582528@qq.com',24022563,NULL,0,0,NULL,0),(6,'努努6','541632nunu','833724@qq.com',28935193,NULL,0,0,NULL,0),(7,'努努7','866941nunu','961753@qq.com',1506369,NULL,0,0,NULL,0),(8,'努努8','868281nunu','739888@qq.com',97082709,NULL,0,0,NULL,0),(9,'努努9','606707nunu','524878@qq.com',75741628,NULL,0,0,NULL,0);

/*Table structure for table `ware` */

DROP TABLE IF EXISTS `ware`;

CREATE TABLE `ware` (
  `fId` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜的id',
  `fName` varchar(20) DEFAULT NULL COMMENT '名称',
  `fPrice` float DEFAULT NULL COMMENT '价格',
  `fImg` varchar(800) DEFAULT NULL COMMENT '图片名称',
  `fType` int(8) NOT NULL COMMENT '菜的类别',
  `fRemark` varchar(80) DEFAULT NULL COMMENT '备注',
  `sid` int(5) DEFAULT NULL,
  PRIMARY KEY (`fId`,`fType`),
  KEY `fType` (`fType`),
  KEY `sid` (`sid`),
  CONSTRAINT `ware_ibfk_1` FOREIGN KEY (`fType`) REFERENCES `type` (`typeid`),
  CONSTRAINT `ware_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `shop` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `ware` */

insert  into `ware`(`fId`,`fName`,`fPrice`,`fImg`,`fType`,`fRemark`,`sid`) values (2,'白菜',23.1,'',2,'你知道的',0),(4,'茄子',232,'mn.jpg',2,'2323',0),(5,'we',123,'null',2,'22',0),(9,'水果',15,'',2,'111',0),(10,'ewwqe',55,'null',2,'111',0),(11,'das',123,NULL,2,'dssad',0),(12,'sds',44,NULL,2,'dsd',NULL),(13,'jjj',55,NULL,2,'ss',NULL),(14,'jjj4',55,NULL,2,'ss',NULL),(15,'dasd',55,NULL,2,'sdsd',NULL),(16,'dsas',33,NULL,2,'sds',NULL),(17,'dsd',33,NULL,2,'ss',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

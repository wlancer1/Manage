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

/*Table structure for table `buyer` */

DROP TABLE IF EXISTS `buyer`;

CREATE TABLE `buyer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '买家的id',
  `bname` varbinary(80) DEFAULT NULL COMMENT '姓名',
  `btele` int(30) DEFAULT NULL COMMENT '联系方式',
  `baddress` varbinary(80) DEFAULT NULL COMMENT '地址ID',
  `bremark` varbinary(80) DEFAULT NULL COMMENT '备注',
  `email` varbinary(20) DEFAULT NULL,
  `bemail` varchar(255) DEFAULT NULL,
  `bpassword` varchar(255) DEFAULT NULL,
  `power` int(11) NOT NULL DEFAULT '2',
  `status` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2000004 DEFAULT CHARSET=utf8;

/*Data for the table `buyer` */

insert  into `buyer`(`ID`,`bname`,`btele`,`baddress`,`bremark`,`email`,`bemail`,`bpassword`,`power`,`status`) values (2000001,'(micheal',2147483647,NULL,NULL,'294634047@qq.com','',NULL,2,0),(2000003,'nishi',321321312,NULL,NULL,NULL,'294634047@qq.com',NULL,2,0);

/*Table structure for table `detailorder` */

DROP TABLE IF EXISTS `detailorder`;

CREATE TABLE `detailorder` (
  `onum` int(11) NOT NULL COMMENT '消费记录ID',
  `SCid` int(11) NOT NULL COMMENT '时间',
  `SCnum` int(11) DEFAULT NULL COMMENT '数量',
  `wareid` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `sum` float NOT NULL,
  `warenum` int(11) NOT NULL,
  PRIMARY KEY (`onum`,`SCid`),
  KEY `SCid` (`SCid`),
  CONSTRAINT `detailorder_ibfk_3` FOREIGN KEY (`SCid`) REFERENCES `ware` (`fId`),
  CONSTRAINT `detailorder_ibfk_4` FOREIGN KEY (`onum`) REFERENCES `order1` (`onum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `detailorder` */

/*Table structure for table `order1` */

DROP TABLE IF EXISTS `order1`;

CREATE TABLE `order1` (
  `onum` int(11) NOT NULL COMMENT '订单号',
  `otime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '订单时间',
  `salerID` int(11) DEFAULT NULL COMMENT '卖家ID',
  `Stime` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '发货时间',
  `oremark` varbinary(80) DEFAULT NULL COMMENT '订单备注',
  `buyerID` int(11) DEFAULT NULL COMMENT '买家的ID',
  `userID` int(11) NOT NULL,
  PRIMARY KEY (`onum`),
  KEY `userID` (`salerID`),
  KEY `buyerID` (`buyerID`),
  CONSTRAINT `order1_ibfk_2` FOREIGN KEY (`buyerID`) REFERENCES `buyer` (`ID`),
  CONSTRAINT `order1_ibfk_3` FOREIGN KEY (`salerID`) REFERENCES `saler` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order1` */

/*Table structure for table `saler` */

DROP TABLE IF EXISTS `saler`;

CREATE TABLE `saler` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(80) DEFAULT NULL COMMENT '账号',
  `password` varchar(80) DEFAULT NULL COMMENT '密码',
  `email` varchar(80) DEFAULT NULL COMMENT '邮箱',
  `saddress` varchar(50) DEFAULT NULL,
  `tele` int(30) DEFAULT NULL,
  `power` int(11) NOT NULL DEFAULT '1',
  `status` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1000005 DEFAULT CHARSET=utf8;

/*Data for the table `saler` */

insert  into `saler`(`ID`,`username`,`password`,`email`,`saddress`,`tele`,`power`,`status`) values (1000001,'wyh','123','weqwe','浙江商业职业技术学院',2147483647,1,0),(1000002,'小强','ewe','29444@11.','comewwewewwe',12323232,1,0),(1000003,'(micheal',NULL,'294634047@qq.com',NULL,2147483647,1,0);

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `fType` varchar(8) NOT NULL COMMENT '名字',
  `t-remark` varbinary(80) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`fType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `type` */

insert  into `type`(`fType`,`t-remark`) values ('sdfsd','1'),('双子类','11'),('叶子类','32'),('水果','1'),('花类','22'),('蕨类','123');

/*Table structure for table `ware` */

DROP TABLE IF EXISTS `ware`;

CREATE TABLE `ware` (
  `fId` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜的id',
  `fName` varchar(20) DEFAULT NULL COMMENT '名称',
  `fPrice` float DEFAULT NULL COMMENT '价格',
  `fImg` varchar(800) DEFAULT NULL COMMENT '图片名称',
  `fType` varchar(8) NOT NULL COMMENT '菜的类别',
  `fRemark` varchar(80) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`fId`,`fType`),
  KEY `fType` (`fType`),
  CONSTRAINT `ware_ibfk_1` FOREIGN KEY (`fType`) REFERENCES `type` (`fType`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `ware` */

insert  into `ware`(`fId`,`fName`,`fPrice`,`fImg`,`fType`,`fRemark`) values (2,'白菜',23,'icon_car1.png','花类','你知道的'),(4,'茄子',232,'mn.jpg','花类','2323'),(5,'we',123,'null','sdfsd','22'),(9,'sss',5,'null','sdfsd','111'),(10,'ewwqe',55,'null','sdfsd','111');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

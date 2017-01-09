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
  `account` char(20) NOT NULL,
  `password` char(20) DEFAULT NULL,
  `power` int(11) DEFAULT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`account`,`password`,`power`) values ('admin','admin',0),('micheal','1',1),('王誉皓','1',1);

/*Table structure for table `buyer` */

DROP TABLE IF EXISTS `buyer`;

CREATE TABLE `buyer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '买家的id',
  `bname` varbinary(80) DEFAULT NULL COMMENT '姓名',
  `bpassword` int(11) DEFAULT NULL,
  `btele` int(11) DEFAULT NULL COMMENT '联系方式',
  `baddress` varbinary(80) DEFAULT NULL COMMENT '地址ID',
  `bremark` varbinary(80) DEFAULT NULL COMMENT '备注',
  `email` varbinary(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `buyer` */

insert  into `buyer`(`ID`,`bname`,`bpassword`,`btele`,`baddress`,`bremark`,`email`) values (1,'(micheal',43444,2147483647,'，，，','232131','294634047@qq.com'),(2,'nishi',123232,321321312,'weqweqw','2222','(NULweqweqL)');

/*Table structure for table `detailorder` */

DROP TABLE IF EXISTS `detailorder`;

CREATE TABLE `detailorder` (
  `onum` int(11) NOT NULL COMMENT '消费记录ID',
  `SCid` int(11) NOT NULL COMMENT '时间',
  `SCnum` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`onum`,`SCid`),
  KEY `SCid` (`SCid`),
  CONSTRAINT `detailorder_ibfk_3` FOREIGN KEY (`SCid`) REFERENCES `shucai` (`fId`),
  CONSTRAINT `detailorder_ibfk_4` FOREIGN KEY (`onum`) REFERENCES `order1` (`onum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `detailorder` */

insert  into `detailorder`(`onum`,`SCid`,`SCnum`) values (231231,2,2),(231231,4,3);

/*Table structure for table `order1` */

DROP TABLE IF EXISTS `order1`;

CREATE TABLE `order1` (
  `onum` int(11) NOT NULL COMMENT '订单号',
  `otime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '订单时间',
  `userID` int(11) DEFAULT NULL COMMENT '卖家ID',
  `Stime` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '发货时间',
  `oremark` varbinary(80) DEFAULT NULL COMMENT '订单备注',
  `buyerID` int(11) DEFAULT NULL COMMENT '买家的ID',
  PRIMARY KEY (`onum`),
  KEY `userID` (`userID`),
  KEY `buyerID` (`buyerID`),
  CONSTRAINT `order1_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `saler` (`userID`),
  CONSTRAINT `order1_ibfk_2` FOREIGN KEY (`buyerID`) REFERENCES `buyer` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order1` */

insert  into `order1`(`onum`,`otime`,`userID`,`Stime`,`oremark`,`buyerID`) values (231231,'2015-09-26 11:11:44',1,'2015-09-22 11:11:38','22332',1);

/*Table structure for table `saler` */

DROP TABLE IF EXISTS `saler`;

CREATE TABLE `saler` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(80) DEFAULT NULL COMMENT '账号',
  `password` varchar(80) DEFAULT NULL COMMENT '密码',
  `email` varchar(80) DEFAULT NULL COMMENT '邮箱',
  `saddress` varchar(50) DEFAULT NULL,
  `tele` int(11) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `saler` */

insert  into `saler`(`userID`,`username`,`password`,`email`,`saddress`,`tele`) values (1,'wyh','123','weqwe','浙江商业职业技术学院',2147483647);

/*Table structure for table `shucai` */

DROP TABLE IF EXISTS `shucai`;

CREATE TABLE `shucai` (
  `fId` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜的id',
  `fName` varchar(20) DEFAULT NULL COMMENT '名称',
  `fPrice` float DEFAULT NULL COMMENT '价格',
  `fImg` varchar(800) DEFAULT NULL COMMENT '图片名称',
  `fType` varchar(8) NOT NULL COMMENT '菜的类别',
  `fRemark` varchar(80) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`fId`,`fType`),
  KEY `fType` (`fType`),
  CONSTRAINT `shucai_ibfk_1` FOREIGN KEY (`fType`) REFERENCES `type` (`fType`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `shucai` */

insert  into `shucai`(`fId`,`fName`,`fPrice`,`fImg`,`fType`,`fRemark`) values (2,'白菜',23,'icon_car1.png','花类','你知道的'),(3,'苹果',2,'icon_price.png','水果','陕西产'),(4,'茄子',232,'mn.jpg','花类','2323'),(6,'芹菜',1.45,'0c2cab1cf1884ce4bee83487e98e71c9.jpg','双子类',''),(9,'蔬菜',3.23,'BMA-038.jpg','双子类',''),(10,'大白菜',2.51,'mn.jpg','双子类','');

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `fType` varchar(8) NOT NULL COMMENT '名字',
  `t-remark` varbinary(80) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`fType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `type` */

insert  into `type`(`fType`,`t-remark`) values ('sdfsd','1'),('双子类','11'),('叶子类','32'),('水果','1'),('花类','22'),('蕨类','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

CREATE USER 'myhandicraftdb'@'localhost' IDENTIFIED BY 'Parsianbalast1';

create database if not exists `handicraft`;

GRANT ALL PRIVILEGES ON handicraft.* TO 'myhandicraftdb'@'localhost'  WITH GRANT OPTION;

USE `handicraft`;

SET character_set_client = utf8;

DROP TABLE IF EXISTS `PRODUCT`;

CREATE TABLE `PRODUCT` (
  `ID` int(11) NOT NULL auto_increment,
  `CODE` varchar(10) NOT NULL,
  `NAME` varchar(256) NOT NULL,
  `PRICE` float NOT NULL,
  `CAT_ID` int(11) NOT NULL,
  `DESCRIPTION` varchar(1024) NOT NULL,
  `QUANTITY` int(4) NOT NULL,
  `WEIGHT` float NOT NULL,
  `WEIGHT_UNIT` varchar(5) NOT NULL,
  `IMAGE_REF` varchar(15) NOT NULL,
  
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `PRODUCT_CATEGORY`;

CREATE TABLE `PRODUCT_CATEGORY` (
  `ID` int(11) NOT NULL auto_increment,
  `CODE` varchar(10) NOT NULL,
  `PARENT_CAT` int(11),
  `NAME` varchar(256) NOT NULL,
  `SHORT_DESC` varchar(512) NOT NULL,
  `LONG_DESC` varchar(1024) NOT NULL,
  `IMAGE_REF` varchar(15) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `USERS`;
CREATE TABLE `USERS` (
  `ID` int(11) NOT NULL auto_increment,
  `EMAIL` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `FIRST_NAME` varchar(10) default NULL,
  `LAST_NAME` varchar(30) default NULL,
  `ROLE` varchar(20) default NULL,
  `ADR_LINE_1` varchar(50) default NULL,
  `ADR_LINE_2` varchar(50) default NULL,
  `CITY` varchar(10) default NULL, 
  `STATE` varchar(10) default NULL,
  `POST_CODE` varchar(10) default NULL,
  `COUNTRY` varchar(20) default NULL, 
  `DATE_MODIFIED` date default NULL,
  `IS_ACTIVE` tinyint(1) default NULL,
  `LOGIN_ATTEMPT_COUNT` int(11) default NULL,
  `ACCOUNT_NON_LOCK` tinyint(1) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;

insert into USERS (ID,EMAIL,PASSWORD,FIRST_NAME,LAST_NAME,ROLE) values(-1,'ali@persianhandicraftsonline.com','aliali','ali','gh','ROLE_SUPER_USER');
insert into USERS (ID,EMAIL,PASSWORD,FIRST_NAME,LAST_NAME,ROLE) values(-2,'reza@persianhandicraftsonline.com','rezareza','reza','gh','ROLE_ADMIN');

DROP TABLE IF EXISTS `ORDERS`;
CREATE TABLE `ORDERS` (
  `ID` int(11) NOT NULL auto_increment,
  `NUMBER` varchar(20) NOT NULL,
  `ORDER_DATE` date NOT NULL,
  `STATUS` varchar(20) default NULL,
  `SHORT_DESC` varchar(512) default NULL,
  `TOTAL` double default NULL,
  `PAYMENT_STATUS` varchar(20) default NULL,
  `USER_ID` int(11) default NULL,
   `OPERATOR_ID` int(11) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `NUMBER` (`NUMBER`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;
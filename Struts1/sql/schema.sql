DROP DATABASE IF EXISTS realmedia;
CREATE DATABASE realmedia;
 

USE realmedia;

/*==============================================================*/
/* Table: regions                                               */
/*==============================================================*/
create table regions
(
   region_id     int auto_increment,
   name          varchar(255) not null,
   primary key (region_id)
) engine=InnoDB;

create table city
(
   city_id       int auto_increment,
   city_name     varchar(255) not null,
   region_id     int not null,
   primary key (city_id)
) engine=InnoDB;

create index region_index on city(region_id);

alter table city add constraint ref_region_constraint 
   foreign key (region_id) 
   references regions(region_id);


create table payment
(
   payment_id    int auto_increment,
   payment_type  int,
   amount        decimal,
   card_number   varchar(20),
   cash_desk     varchar(20),
   bank_id       varchar(20),
   primary key (payment_id)
) engine=InnoDB;

create table credit_payment
(
   payment_id    int not null,
   card_number   varchar(20),
   primary key (payment_id)
) engine=InnoDB;

create table cash_payment
(
   payment_id    int not null,
   cash_desk     varchar(20),
   primary key (payment_id)
) engine=InnoDB;

create table cheque_payment
(
   payment_id    int not null,
   bank_id       varchar(20),
   primary key (payment_id)
) engine=InnoDB;


CREATE TABLE `users` (
  `userId` int(10) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB;


INSERT INTO `users` (`userId`, `login`, `password`, `email`) VALUES
  (1, 'user1','user1','user1@mail.ru'),
  (2, 'user2','user2','user2@mail.ru'),
  (3, 'user3','user3','user3@mail.ru');


CREATE TABLE `statuses` (
  `statusId` int(10) NOT NULL AUTO_INCREMENT,
  `statusName` varchar(255) NOT NULL,
  `alias` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`statusId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=cp1251;

#
# Structure for the `appcategories` table : 
#


CREATE TABLE `applications` (
  `applicationId` int(10) NOT NULL AUTO_INCREMENT,
  `applicationName` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `statusId` int(10) NOT NULL,
  PRIMARY KEY (`applicationId`),
  KEY `FKapplicatio317299` (`statusId`),
  CONSTRAINT `FKapplicatio317299` FOREIGN KEY (`statusId`) REFERENCES `statuses` (`statusId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=cp1251;


#
# Structure for the `orders` table : 
#

CREATE TABLE `orders` (
  `orderId` int(10) NOT NULL AUTO_INCREMENT,
  `CPU` float NOT NULL,
  `HDD` float NOT NULL,
  `RAM` float NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `startDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `finishDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `statusId` int(10) NOT NULL,
  PRIMARY KEY (`orderId`),
  KEY `FKorders662052` (`statusId`),
  CONSTRAINT `FKorders662052` FOREIGN KEY (`statusId`) REFERENCES `statuses` (`statusId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=cp1251;

#
# Structure for the `orders_applications` table : 
#

CREATE TABLE `orders_applications` (
  `orderId` int(10) NOT NULL,
  `applicationId` int(10) NOT NULL,
  PRIMARY KEY (`orderId`,`applicationId`),
  KEY `FKorders_app309406` (`orderId`),
  KEY `FKorders_app185221` (`applicationId`),
  CONSTRAINT `FKorders_app185221` FOREIGN KEY (`applicationId`) REFERENCES `applications` (`applicationId`),
  CONSTRAINT `FKorders_app309406` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=cp1251;


INSERT INTO `statuses` (`statusId`, `statusName`, `alias`) VALUES 
  (17,'active','ACTIVE'),
  (18,'inactive','INACTIVE'),
  (19,'submitted','SUBMITTED'),
  (20,'in_progress','IN_PROGRESS'),
  (21,'approved','APPROVED'),
  (22,'deleted','DELETED'),
  (23,'declined','DECLINED'),
  (24,'read','READ'),
  (25,'unread','UNREAD');


#
# Data for the `applications` table  (LIMIT 0,500)
#

INSERT INTO `applications` (`applicationId`, `applicationName`, `description`, `statusId`) VALUES 
  (11,'IDEA','Jet Brains IDE',17),
  (12,'Eclipse','Eclipse IDE. Open Source.',17),
  (13,'MS Office','Microsoft Office',17),
  (14,'Open Office','Open Office',17),
  (15,'AIMP','Music player',17),
  (16,'Photoshop','Graph package',17),
  (17,'Far','Fast file manager',17),
  (18,'Total Commander','File Manager for Windows',17);



#
# Data for the `orders` table  (LIMIT 0,500)
#

INSERT INTO `orders` (`orderId`, `CPU`, `HDD`, `RAM`, `description`, `startDate`, `finishDate`, `statusId`) VALUES 
  (7,0.5,50,0.5,'test','2009-08-04','2009-08-22',20),
  (9,2,200,2,'OmniFind Test Server','2009-08-11 01:06:42','2009-08-29 01:06:45',19),
  (12,3,400,2,'Hi medved!','2009-08-28 03:36:37','2009-08-29 03:36:40',20);


#
# Data for the `orders_applications` table  (LIMIT 0,500)
#

INSERT INTO `orders_applications` (`orderId`, `applicationId`) VALUES 
  (7,15),
  (7,16),
  (9,12),
  (9,16),
  (9,17),
  (12,16);

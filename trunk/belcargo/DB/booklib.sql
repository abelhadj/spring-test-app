SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `booklib`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `booklib`;

#
# Structure for the `role` table : 
#

CREATE TABLE `role` (
  `role_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`role_id`)

)ENGINE=InnoDB
AUTO_INCREMENT=3 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

#
# Structure for the `account` table : 
#

CREATE TABLE `account` (
  `account_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `role_id` BIGINT(20) NOT NULL,
  `login` VARCHAR(32) COLLATE utf8_general_ci DEFAULT NULL,
  `password` VARCHAR(32) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  KEY `role_id_fk` (`role_id`),
  CONSTRAINT `role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)

)ENGINE=InnoDB
AUTO_INCREMENT=3 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

#
# Structure for the `book_category` table : 
#

CREATE TABLE `book_category` (
  `book_category_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`book_category_id`)

)ENGINE=InnoDB
AUTO_INCREMENT=4 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

#
# Structure for the `book` table : 
#

CREATE TABLE `book` (
  `book_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `book_category_id` BIGINT(20) NOT NULL,
  `author` VARCHAR(32) COLLATE utf8_general_ci DEFAULT NULL,
  `name` TEXT COLLATE utf8_general_ci,
  `price` DECIMAL(10,2) DEFAULT NULL,
  `discount_price` DECIMAL(10,2) DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  KEY `bike_category_fk` (`book_category_id`),
  CONSTRAINT `book_fk` FOREIGN KEY (`book_category_id`) REFERENCES `book_category` (`book_category_id`)

)ENGINE=InnoDB
AUTO_INCREMENT=17 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

#
# Data for the `role` table  (LIMIT 0,500)
#

INSERT INTO `role` (`role_id`, `name`) VALUES
  (1,'ROLE_ADMIN'),
  (2,'ROLE_REGISTERED');
COMMIT;

#
# Data for the `account` table  (LIMIT 0,500)
#

INSERT INTO `account` (`account_id`, `role_id`, `login`, `password`) VALUES
  (1,1,'admin','admin'),
  (2,2,'user','user');
COMMIT;

#
# Data for the `book_category` table  (LIMIT 0,500)
#

INSERT INTO `book_category` (`book_category_id`, `name`) VALUES
  (1,'Fiction'),
  (2,'Literary criticism'),
  (3,'Biography');
COMMIT;

#
# Data for the `book` table  (LIMIT 0,500)
#

INSERT INTO `book` (`book_id`, `book_category_id`, `author`, `name`, `price`, `discount_price`) VALUES
  (1,2,'George Orwell','1984',12.00,8.00),
  (2,1,'Jules Verne','From the Earth to the Moon',30.00,NULL),
  (3,3,'William L. Simon ','iCon Steve Jobs: The Greatest Second Act in the History',10.00,NULL),
  (6,1,'Jules Verne','Under the Sea',8.00,NULL),
  (7,1,'Jules Verne','A Journey to the Center of the Earth',12.00,4.00),
  (8,1,'Jules Verne','Around the World in Eighty Days',13.00,7.00),
  (9,1,'Jules Verne','The Mysterious Island',14.00,NULL),
  (13,1,'John Tolkien','The Lord of the rings',14.00,NULL),
  (14,3,'David McCullough','John Adams',24.00,15.00),
  (15,2,'Boethius','The Consolation of Philosophy',34.00,NULL),
  (16,3,'Lac Su','I Love Yous Are for White People: A Memoir',23.00,12.00);
COMMIT;
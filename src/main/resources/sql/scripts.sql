create database exampleBank;

use exampleBank;

CREATE TABLE `users` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `username` VARCHAR(45) NOT NULL,
                         `password` VARCHAR(45) NOT NULL,
                         `enabled` INT NOT NULL,
                         PRIMARY KEY (`id`));

CREATE TABLE `authorities` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `username` varchar(45) NOT NULL,
                               `authority` varchar(45) NOT NULL,
                               PRIMARY KEY (`id`));

INSERT IGNORE INTO `users` VALUES (NULL, 'dev', 'dev', '1');
INSERT IGNORE INTO `authorities` VALUES (NULL, 'dev', 'WRITE');

CREATE TABLE `users_details` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `email` varchar(45) NOT NULL,
                            `pwd` varchar(256) NOT NULL,
                            `role` varchar(45) NOT NULL,
                            PRIMARY KEY (`id`)
);

INSERT INTO `users_details` (`email`, `pwd`, `role`)
VALUES ('johndoe@example.com', 'pass', 'ADMIN');

CREATE TABLE `authority` (
                                `id` int NOT NULL AUTO_INCREMENT,
                                `customer_id` int NOT NULL,
                                `name` varchar(50) NOT NULL,
                                PRIMARY KEY (`id`),
                                KEY `customer_id` (`customer_id`),
                                CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
);

INSERT INTO `authority` (`customer_id`, `name`)
VALUES (1, 'VIEWACCOUNT');

INSERT INTO `authority` (`customer_id`, `name`)
VALUES (1, 'VIEWLOAN');

INSERT INTO `authority` (`customer_id`, `name`)
VALUES (1, 'VIEWCARD');

INSERT INTO `authority` (`customer_id`, `name`)
VALUES (1, 'VIEWBALANCE');


INSERT INTO `authority` (`customer_id`, `name`)
VALUES (1, 'ROLE_ADMIN');

INSERT INTO `authority` (`customer_id`, `name`)
VALUES (1, 'ROLE_USER');
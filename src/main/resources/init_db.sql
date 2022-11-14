CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE `manufacturers` (
                                        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(225) NOT NULL,
                                        `country` VARCHAR(225) NOT NULL,
                                        `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                        PRIMARY KEY (`id`));


CREATE TABLE `taxi_service`.`drivers` (
                                          `id` BIGINT(255) NOT NULL AUTO_INCREMENT,
                                          `name` VARCHAR(50) NOT NULL,
                                          `license_number` VARCHAR(50) NOT NULL,
                                          `is_deleted` TINYINT NULL DEFAULT 0,
                                          PRIMARY KEY (`id`),
                                          UNIQUE INDEX `license_number_UNIQUE` (`license_number` ASC) VISIBLE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;



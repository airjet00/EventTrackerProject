-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema financedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `financedb` ;

-- -----------------------------------------------------
-- Schema financedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `financedb` DEFAULT CHARACTER SET utf8 ;
USE `financedb` ;

-- -----------------------------------------------------
-- Table `manager`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `manager` ;

CREATE TABLE IF NOT EXISTS `manager` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `profile_url` VARCHAR(200) NULL,
  `goal` TEXT NULL,
  `goal_achieved` TINYINT NULL DEFAULT 0,
  `total_available` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `income`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `income` ;

CREATE TABLE IF NOT EXISTS `income` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `manager_id` INT NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `total` VARCHAR(45) NOT NULL,
  `is_passive` TINYINT NULL DEFAULT 0,
  `date_created` VARCHAR(45) NULL,
  `is_active` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_income_manager_idx` (`manager_id` ASC),
  CONSTRAINT `fk_income_manager`
    FOREIGN KEY (`manager_id`)
    REFERENCES `manager` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `investment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `investment` ;

CREATE TABLE IF NOT EXISTS `investment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  `is_active` TINYINT NULL DEFAULT 1,
  `original_investment` INT NOT NULL,
  `amount_invested` INT NULL,
  `is_income` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `expense`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `expense` ;

CREATE TABLE IF NOT EXISTS `expense` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `manager_id` INT NOT NULL,
  `type` VARCHAR(45) NULL,
  `company` VARCHAR(20) NULL,
  `amount` INT NULL,
  `due_date` VARCHAR(45) NULL,
  `is_reacurring` TINYINT NULL DEFAULT 0,
  `note` TEXT NULL,
  `date_created` VARCHAR(45) NULL,
  `is_active` TINYINT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_expense_manager1_idx` (`manager_id` ASC),
  CONSTRAINT `fk_expense_manager1`
    FOREIGN KEY (`manager_id`)
    REFERENCES `manager` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `debt`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `debt` ;

CREATE TABLE IF NOT EXISTS `debt` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `company_name` VARCHAR(45) NULL,
  `intrest_rate` INT NULL,
  `is_paid_off` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS financeuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'financeuser'@'localhost' IDENTIFIED BY 'financeuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'financeuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `manager`
-- -----------------------------------------------------
START TRANSACTION;
USE `financedb`;
INSERT INTO `manager` (`id`, `first_name`, `last_name`, `username`, `password`, `profile_url`, `goal`, `goal_achieved`, `total_available`) VALUES (1, 'Erik', 'Kell', 'admin', 'admin', NULL, 'Make money', 0, NULL);
INSERT INTO `manager` (`id`, `first_name`, `last_name`, `username`, `password`, `profile_url`, `goal`, `goal_achieved`, `total_available`) VALUES (2, 'Bob', 'Dole', 'bobdole', 'bobdole', NULL, 'Save the world', 0, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `income`
-- -----------------------------------------------------
START TRANSACTION;
USE `financedb`;
INSERT INTO `income` (`id`, `manager_id`, `description`, `total`, `is_passive`, `date_created`, `is_active`) VALUES (1, 1, 'Google Income', '10000', 0, '04-02-2021', 1);
INSERT INTO `income` (`id`, `manager_id`, `description`, `total`, `is_passive`, `date_created`, `is_active`) VALUES (2, 1, 'VA Edu', '200', 1, '01-09-2021', 1);
INSERT INTO `income` (`id`, `manager_id`, `description`, `total`, `is_passive`, `date_created`, `is_active`) VALUES (3, 2, 'Gov Retirement', '20000', 1, '01-01-2020', 1);
INSERT INTO `income` (`id`, `manager_id`, `description`, `total`, `is_passive`, `date_created`, `is_active`) VALUES (4, 2, 'Secret Account intrest ', '50000', 1, '10-01-2020', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `expense`
-- -----------------------------------------------------
START TRANSACTION;
USE `financedb`;
INSERT INTO `expense` (`id`, `manager_id`, `type`, `company`, `amount`, `due_date`, `is_reacurring`, `note`, `date_created`, `is_active`) VALUES (1, 1, 'Credit Card', 'U.S. Bank', 100, '04-07-2021', 1, 'Try to pay off this year', '01-01-2020', 1);
INSERT INTO `expense` (`id`, `manager_id`, `type`, `company`, `amount`, `due_date`, `is_reacurring`, `note`, `date_created`, `is_active`) VALUES (2, 2, 'Testing cost', 'WWF ', 9000, '04-01-2021', 0, 'World Wildlife Fund', '03-01-2021', 1);
INSERT INTO `expense` (`id`, `manager_id`, `type`, `company`, `amount`, `due_date`, `is_reacurring`, `note`, `date_created`, `is_active`) VALUES (3, 1, 'Medical', 'NW Medical', 1500, '04-02-2021', 0, 'Overchared medical expense', '03-15-2021', 1);

COMMIT;


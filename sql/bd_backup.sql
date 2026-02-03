-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema springbot
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema springbot
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springbot` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `springbot` ;

-- -----------------------------------------------------
-- Table `springbot`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springbot`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `springbot`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springbot`.`cliente` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(50) NOT NULL,
  `Edad` INT NOT NULL,
  `DNI` INT NOT NULL,
  `activo` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `springbot`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springbot`.`factura` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_cliente` INT NULL DEFAULT NULL,
  `total_pagar` DECIMAL(10,2) NOT NULL,
  `activo` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  INDEX `FK_FACTURA_CLIENTE` (`id_cliente` ASC),
  CONSTRAINT `FK_FACTURA_CLIENTE`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `springbot`.`cliente` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `springbot`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springbot`.`producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  `activo` TINYINT(1) NULL DEFAULT '1',
  `id_categoria` INT NULL DEFAULT NULL,
  `stock` INT NOT NULL,
  `peso` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_CATEGORIA_PRODUCTO` (`id_categoria` ASC),
  CONSTRAINT `FK_CATEGORIA_PRODUCTO`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `springbot`.`categoria` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `springbot`.`detalle_factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springbot`.`detalle_factura` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_factura` INT NULL DEFAULT NULL,
  `id_producto` INT NULL DEFAULT NULL,
  `cantidad` INT NOT NULL,
  `precio_uni` DECIMAL(10,2) NOT NULL,
  `subtotal` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_DETALLE_FACTURA` (`id_factura` ASC),
  INDEX `FK_DETALLE_PRODUCTO` (`id_producto` ASC),
  CONSTRAINT `FK_DETALLE_FACTURA`
    FOREIGN KEY (`id_factura`)
    REFERENCES `springbot`.`factura` (`id`),
  CONSTRAINT `FK_DETALLE_PRODUCTO`
    FOREIGN KEY (`id_producto`)
    REFERENCES `springbot`.`producto` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `ForFood` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `ForFood` ;

-- -----------------------------------------------------
-- Table `ForFood`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ForFood`.`Cliente` (
  `cliCpf` INT NOT NULL,
  `cliNome` VARCHAR(45) NOT NULL,
  `cliFone` INT NOT NULL,
  `cliEndereco` VARCHAR(45) NOT NULL,
  `cliEmail` VARCHAR(45) NOT NULL,
  `cliSenha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cliCpf`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ForFood`.`Prato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ForFood`.`Prato` (
  `praCodigo` INT NOT NULL AUTO_INCREMENT,
  `praNome` VARCHAR(45) NOT NULL,
  `praDescricao` VARCHAR(45) NOT NULL,
  `praTempo` INT NOT NULL,
  `praPreco` FLOAT NOT NULL,
  PRIMARY KEY (`praCodigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ForFood`.`Restaurante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ForFood`.`Restaurante` (
  `resCnpj` INT NOT NULL,
  `resNome` VARCHAR(45) NOT NULL,
  `resEndereco` VARCHAR(45) NOT NULL,
  `resFone` INT NOT NULL,
  `resSenha` VARCHAR(45) NOT NULL,
  `Prato_praCodigo` INT NOT NULL,
  PRIMARY KEY (`resCnpj`, `Prato_praCodigo`),
  CONSTRAINT `fk_Restaurante_Prato`
    FOREIGN KEY (`Prato_praCodigo`)
    REFERENCES `ForFood`.`Prato` (`praCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Restaurante_Prato_idx` ON `ForFood`.`Restaurante` (`Prato_praCodigo` ASC);


-- -----------------------------------------------------
-- Table `ForFood`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ForFood`.`Pedido` (
  `Cilente_cliCpf` INT NOT NULL,
  `Prato_praCodigo` INT NOT NULL,
  `pedCodigo` INT NOT NULL,
  `pedStatus` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Cilente_cliCpf`, `Prato_praCodigo`, `pedCodigo`),
  CONSTRAINT `fk_Cilente_has_Prato_Cilente1`
    FOREIGN KEY (`Cilente_cliCpf`)
    REFERENCES `ForFood`.`Cliente` (`cliCpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cilente_has_Prato_Prato1`
    FOREIGN KEY (`Prato_praCodigo`)
    REFERENCES `ForFood`.`Prato` (`praCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Cilente_has_Prato_Prato1_idx` ON `ForFood`.`Pedido` (`Prato_praCodigo` ASC);

CREATE INDEX `fk_Cilente_has_Prato_Cilente1_idx` ON `ForFood`.`Pedido` (`Cilente_cliCpf` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

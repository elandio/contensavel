SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `bd_contensavel` ;
CREATE SCHEMA IF NOT EXISTS `bd_contensavel` DEFAULT CHARACTER SET latin1 ;
USE `bd_contensavel` ;

-- -----------------------------------------------------
-- Table `bd_contensavel`.`filiais`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_contensavel`.`filiais` ;

CREATE  TABLE IF NOT EXISTS `bd_contensavel`.`filiais` (
  `cod_filial` INT(11) NOT NULL AUTO_INCREMENT ,
  `razao_social` VARCHAR(45) NULL DEFAULT NULL ,
  `cnpj` INT(11) NULL DEFAULT NULL ,
  `rua` VARCHAR(45) NULL DEFAULT NULL ,
  `bairro` VARCHAR(45) NULL DEFAULT NULL ,
  `cidade` VARCHAR(45) NULL DEFAULT NULL ,
  `estado` VARCHAR(45) NULL DEFAULT NULL ,
  `cep` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`cod_filial`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_contensavel`.`funcoes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_contensavel`.`funcoes` ;

CREATE  TABLE IF NOT EXISTS `bd_contensavel`.`funcoes` (
  `cod_funcao` INT(11) NOT NULL AUTO_INCREMENT ,
  `funcao` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`cod_funcao`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_contensavel`.`funcionarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_contensavel`.`funcionarios` ;

CREATE  TABLE IF NOT EXISTS `bd_contensavel`.`funcionarios` (
  `cod_funcionario` INT(11) NOT NULL AUTO_INCREMENT ,
  `cod_funcao` INT(11) NOT NULL ,
  `matricula` INT(11) NULL DEFAULT NULL ,
  `nome` VARCHAR(45) NULL DEFAULT NULL ,
  `rua` VARCHAR(45) NULL DEFAULT NULL ,
  `bairro` VARCHAR(45) NULL DEFAULT NULL ,
  `cidade` VARCHAR(45) NULL DEFAULT NULL ,
  `estado` VARCHAR(45) NULL DEFAULT NULL ,
  `cep` INT(11) NULL DEFAULT NULL ,
  `cpf` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`cod_funcionario`) ,
  INDEX `FK_funcionarios_funcoes1` (`cod_funcao` ASC) ,
  CONSTRAINT `FK_funcionarios_funcoes1`
    FOREIGN KEY (`cod_funcao` )
    REFERENCES `bd_contensavel`.`funcoes` (`cod_funcao` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_contensavel`.`ordens`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_contensavel`.`ordens` ;

CREATE  TABLE IF NOT EXISTS `bd_contensavel`.`ordens` (
  `cod_ordem` INT(11) NOT NULL AUTO_INCREMENT ,
  `cod_filial` INT(11) NOT NULL ,
  `cod_funcionario` INT(11) NOT NULL ,
  `tipo_ordem` VARCHAR(45) NOT NULL ,
  `num_carro` INT(11) NULL DEFAULT NULL ,
  `km` INT(11) NULL DEFAULT NULL ,
  `horario` TIME NULL DEFAULT NULL ,
  `data_lanc` DATE NULL DEFAULT NULL ,
  `origem` VARCHAR(80) NOT NULL ,
  `destino` VARCHAR(80) NOT NULL ,
  PRIMARY KEY (`cod_ordem`) ,
  INDEX `FK_ordens_filiais` (`cod_filial` ASC) ,
  INDEX `FK_ordens_funcionarios1` (`cod_funcionario` ASC) ,
  CONSTRAINT `FK_ordens_filiais`
    FOREIGN KEY (`cod_filial` )
    REFERENCES `bd_contensavel`.`filiais` (`cod_filial` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ordens_funcionarios1`
    FOREIGN KEY (`cod_funcionario` )
    REFERENCES `bd_contensavel`.`funcionarios` (`cod_funcionario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

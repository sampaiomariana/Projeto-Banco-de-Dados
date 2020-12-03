USE `covid`;
DROP procedure IF EXISTS `AdicionarItem`;

DELIMITER $$
USE `covid`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `AdicionarItem`(
	in IdItem int,
	Nome varchar (45),
    Tipodeitem varchar(45),
    Producaohistorica int,
    Producaodoultimomes int
)
BEGIN 
	insert into item(IdItem,Tipodeitem,Producaohistorica,Producaodoultimomes)
    values (IdItem, Tipodeitem,Producaohistorica,Producaodoultimomes);
END$$

DELIMITER ;
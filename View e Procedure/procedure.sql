CREATE DEFINER=`root`@`localhost` PROCEDURE `AdicionarItem`(
	in IdItem int,
	Nome varchar (45),
    Tipodeitem varchar(45),
    Producaohistorica int,
    Producaodoultimomes int
)
BEGIN 
	insert into item(IdItem,Nome,Tipodeitem,Producaohistorica,Producaodoultimomes)
    values (IdItem, Nome,Tipodeitem,Producaohistorica,Producaodoultimomes);
END

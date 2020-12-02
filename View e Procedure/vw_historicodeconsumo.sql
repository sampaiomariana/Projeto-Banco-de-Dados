
create view vw_historicodeconsumo

AS select covid.item.Nome AS Item,
covid.historicodeconsumo.QuantidadeMensal AS QuantidadeMensal
from  item
INNER JOIN covid.historicodeconsumo
ON covid.item.Iditem = covid.historicodeconsumo.IdItem;

SELECT * FROM covid.vw_historicodeconsumo;

create procedure AdicionarItem (
in in Tipodeitem varchar(45),
    Producaohistorica int,
    Producaodoultimomes int
)

BEGIN 
	insert into item(Tipodeitem,Producaohistorica,Producaodoultimomes)
    values (Tipodeitem,Producaohistorica,Producaodoultimomes);
END

call AdicionarItem('Respirador','20000','150');
select * from item;


create view vw_itemlote
AS select covid.item.Tipodeitem AS Item,
covid.lote.Fornecedor AS Lote
from  item
INNER JOIN covid.lote
ON covid.item.Iditem = covid.lote.Idlote;

select item,lote
FROM vw_itemlote
order by lote;

select *
FROM vw_itemlote
order by lote;



create procedure AdicionarItem (
	in Tipodeitem varchar(45),
    Producaohistorica int,
    Producaodoultimomes int
)
BEGIN 
	insert into item(Tipodeitem,Producaohistorica,Producaodoultimomes)
    values (Tipodeitem,Producaohistorica,Producaodoultimomes);
END
//
call AdicionarItem('Respirador 03','5698','123';
select * from item;


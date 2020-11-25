
create view vw_historicodeconsumo

AS select covid.item.Nome AS Item,
covid.historicodeconsumo.QuantidadeMensal AS QuantidadeMensal
from  item
INNER JOIN covid.historicodeconsumo
ON covid.item.Iditem = covid.historicodeconsumo.IdItem;

SELECT * FROM covid.vw_historicodeconsumo;


use covid;

create view vw_pesquisa
AS select covid.pesquisa.TaxadeEficacia AS TaxadeEficacia,
covid.pesquisadorchefe.Nome AS PesquisadorChefe
from  pesquisa
INNER JOIN covid.pesquisadorchefe
ON covid.pesquisa.Pesquisador = covid.pesquisadorchefe.CadastroPesquisador;

select pesquisa,pesquisadorchefe
FROM vw_pesquisa
order by pesquisadorchefe;

select *
FROM vw_pesquisa
order by pesquisadorchefe;


SELECT * FROM covid.vw_pesquisa;
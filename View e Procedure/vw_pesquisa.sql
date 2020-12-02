
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


create procedure NovaPesquisa (
		in NumerodeVoluntarios int,
		TaxadeEficacia float,
		DatadeInicio date,
		DatadeTermino date,
		

)



BEGIN 
	insert into pesquisa( NumerodeVoluntarios,TaxadeEficacia,DatadeInicio,DatadeTermino)
    values ( NumerodeVoluntarios,TaxadeEficacia,DatadeInicio,DatadeTermino)
END

call NovaPesquisa ('2545', '78.4','12/03/2020', '15/10/2020');

select * from pesquisa;

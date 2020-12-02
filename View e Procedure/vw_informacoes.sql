create view vw_informacoes 
AS select lote.idlote, lote.Fornecedor, dadosdaentrega.StatusLote, pesquisa.CNPJ from lote
join dadosdaentrega
on lote.idlote = dadosdaentrega.IdLote
join pesquisa 
on pesquisa.idPesquisa = lote.idlote;
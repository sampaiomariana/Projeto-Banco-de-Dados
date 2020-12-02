select Destino.Nome, Tipodeestabelecimento, Item.idItem, Item.Nome, Mes, QuantidadeMensal
from Item, Destino, HistoricodeConsumo
where Item.idItem = HistoricodeConsumo.idItem AND Destino.CNPJ = "54.203.972/00001-02" AND Item.idItem = "1977";

select Lote.idLote, Fornecedor, StatusLote, DatadeSolicitacao, DatadeEntrega, Valor
from Lote, DadosdaEntrega, Destino
where DadosdaEntrega.idLote = Lote.idLote AND CNPJDestino = CNPJ AND	Lote.idLote IN (select idLote
																						from Lote
																						where Valor IN (select Max(Valor)
																										from Lote
																										Where CNPJDestino = "54.203.972/00001-02"));

select PesquisadorChefe.Nome, CadastroPesquisador, Especialidade, Pesquisa.idPesquisa, Item.idItem, Item.Nome, TaxadeEficacia
from PesquisadorChefe, Pesquisa, Item_has_Pesquisa, Item
where Item.idItem = Item_has_Pesquisa.idItem AND CadastroPesquisador = Pesquisador AND Item_has_Pesquisa.idPesquisa = Pesquisa.idPesquisa 
AND (Item_has_Pesquisa.idItem = "3478" OR Item_has_Pesquisa.idItem = "1977")
order by Item.idItem ASC;

select Localidade.CNPJ, NomedaInstituicao, NumeroTelefone, idPesquisa
from Pesquisa, Localidade, Telefone
where idPesquisa = "2" AND Localidade.CNPJ = Telefone.CNPJ AND Pesquisa.CNPJ = Localidade.CNPJ;

select Lote.idLote, Fornecedor, idItem, Quantidade, StatusLote, DatadeSolicitacao, DatadeEntrega, CNPJDestino, Nome
from Lote, Destino, DadosdaEntrega, Item_has_Lote
where Lote.idLote = DadosdaEntrega.idLote AND CNPJDestino = CNPJ AND Item_has_Lote.idLote = Lote.idLote AND  Quantidade >= "100"
order by Lote.idLote ASC;
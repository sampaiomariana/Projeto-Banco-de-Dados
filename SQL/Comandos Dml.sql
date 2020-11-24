use covid;

INSERT INTO Item (IdItem, Nome, Tipodeitem, Producaohistorica, Producaodoultimomes)
VALUES ('3478', 'Bamlanivimab', 'Medicamento', '108708', '32531');
INSERT INTO Item (IdItem, Nome, Tipodeitem, Producaohistorica, Producaodoultimomes)
VALUES ('725', 'Rendesivir', 'Medicamento', '2978303', '47207');
INSERT INTO Item (IdItem, Nome, Tipodeitem, Producaohistorica, Producaodoultimomes)
VALUES ('12480', 'Respirador KTK', 'Respirador', '8720', '382');
INSERT INTO Item (IdItem, Nome, Tipodeitem, Producaohistorica, Producaodoultimomes)
VALUES ('204', 'AZD12222', 'Vacina', '178540', '39896');
INSERT INTO Item (IdItem, Nome, Tipodeitem, Producaohistorica, Producaodoultimomes)
VALUES ('1977', 'Teste PCR', 'Teste', '360742117', '51449844');


INSERT INTO Destino (CNPJ, Nome, Tipodeestabelecimento, UF, CEP, Numero)
VALUES ('54.203.972/00001-02', 'Hospital São Cristovão', 'Hospital', 'DF', '73369-164', 27);
INSERT INTO Destino (CNPJ, Nome, Tipodeestabelecimento, UF, CEP, Numero)
VALUES ('02.961.029/00001-65', 'UBS n° 14', 'Unidade Basica de Saude', 'DF', '70610-300', 55);
INSERT INTO Destino (CNPJ, Nome, Tipodeestabelecimento, UF, CEP, Numero)
VALUES ('04.723.248/00001-31', 'UPA Recanto Azul', 'Unidade de Pronto Atendimento', 'MT', '78140-130', 4);
INSERT INTO Destino (CNPJ, Nome, Tipodeestabelecimento, UF, CEP, Numero)
VALUES ('77.868.780/00001-10', 'Hospital Cuida Vida', 'Hospital', 'GO', '74923-400', 18);
INSERT INTO Destino (CNPJ, Nome, Tipodeestabelecimento, UF, CEP, Numero)
VALUES ('97.111.835/00001-50', 'Hospital Helena', 'Hospital', 'DF', '72640-405', 29);
INSERT INTO Destino (CNPJ, Nome, Tipodeestabelecimento, UF, CEP, Numero)
VALUES ('31.765.357/00001-94', 'Hospital Cruzeiro Novo', 'Hospital', 'DF', '75911-067', 18);


INSERT INTO Lote (Fornecedor, Valor, CNPJDestino)
VALUES ('Medicamentos INC', '170000', '54.203.972/00001-02');
INSERT INTO Lote (Fornecedor, Valor, CNPJDestino)
VALUES ('Medicamentos INC', '7800', '77.868.780/00001-10');
INSERT INTO Lote (Fornecedor, Valor, CNPJDestino)
VALUES ('Gov. Distrito Federal', '280000', '54.203.972/00001-02');
INSERT INTO Lote (Fornecedor, Valor, CNPJDestino)
VALUES ('Distrimed', '18000', '02.961.029/00001-65');
INSERT INTO Lote (Fornecedor, Valor, CNPJDestino)
VALUES ('UtiLab', '4000', '04.723.248/00001-31');


INSERT INTO Item_has_Lote (IdItem, IdLote, quantidade)
VALUES ('3478', '1', '230');
INSERT INTO Item_has_Lote (IdItem, IdLote, quantidade)
VALUES ('12480', '1', '8');
INSERT INTO Item_has_Lote (IdItem, IdLote, quantidade)
VALUES ('725', '2', '130');
INSERT INTO Item_has_Lote (IdItem, IdLote, quantidade)
VALUES ('12480', '3', '3');
INSERT INTO Item_has_Lote (IdItem, IdLote, quantidade)
VALUES ('204', '3', '4000');
INSERT INTO Item_has_Lote (IdItem, IdLote, quantidade)
VALUES ('1977', '3', '2000');
INSERT INTO Item_has_Lote (IdItem, IdLote, quantidade)
VALUES ('3478', '4', '300');
INSERT INTO Item_has_Lote (IdItem, IdLote, quantidade)
VALUES ('1977', '5', '80');


INSERT INTO Dadosdaentrega (IdLote, StatusLote, DatadeSolicitacao, DatadeEntrega)
VALUES ('1', 'Entregue', '2020-10-02', '2020-10-13');
INSERT INTO Dadosdaentrega (IdLote, StatusLote, DatadeSolicitacao, DatadeEntrega)
VALUES ('2', 'Entregue', '2020-10-16', '2020-10-29');
INSERT INTO Dadosdaentrega (IdLote, StatusLote, DatadeSolicitacao, DatadeEntrega)
VALUES ('3', 'Entregue', '2020-11-11', '2020-11-24');
INSERT INTO Dadosdaentrega (IdLote, StatusLote, DatadeSolicitacao)
VALUES ('4', 'Enviado', '2020-11-19');
INSERT INTO Dadosdaentrega (IdLote, StatusLote, DatadeSolicitacao)
VALUES ('5', 'Solicitado', '2020-11-24');


INSERT INTO CasosCovid (CNPJ, QuantidadeInternados, QuantidadeCurados, QuantidadedeMortes)
VALUES ('54.203.972/00001-02', '38', '321', '17');
INSERT INTO CasosCovid (CNPJ, QuantidadeInternados, QuantidadeCurados, QuantidadedeMortes)
VALUES ('02.961.029/00001-65', '3', '20', '0');
INSERT INTO CasosCovid (CNPJ, QuantidadeInternados, QuantidadeCurados, QuantidadedeMortes)
VALUES ('77.868.780/00001-10', '21', '293', '29');
INSERT INTO CasosCovid (CNPJ, QuantidadeInternados, QuantidadeCurados, QuantidadedeMortes)
VALUES ('97.111.835/00001-50', '19', '403', '53');
INSERT INTO CasosCovid (CNPJ, QuantidadeInternados, QuantidadeCurados, QuantidadedeMortes)
VALUES ('31.765.357/00001-94', '47', '437', '40');


INSERT INTO HistoricodeConsumo (CNPJ, Mes, IdItem, QuantidadeMensal)
VALUES ('54.203.972/00001-02', '8', '3478', '434');
INSERT INTO HistoricodeConsumo (CNPJ, Mes, IdItem, QuantidadeMensal)
VALUES ('54.203.972/00001-02', '8', '725', '120');
INSERT INTO HistoricodeConsumo (CNPJ, Mes, IdItem, QuantidadeMensal)
VALUES ('54.203.972/00001-02', '8', '1977', '3211');
INSERT INTO HistoricodeConsumo (CNPJ, Mes, IdItem, QuantidadeMensal)
VALUES ('54.203.972/00001-02', '9', '3478', '325');
INSERT INTO HistoricodeConsumo (CNPJ, Mes, IdItem, QuantidadeMensal)
VALUES ('54.203.972/00001-02', '9', '725', '91');
INSERT INTO HistoricodeConsumo (CNPJ, Mes, IdItem, QuantidadeMensal)
VALUES ('54.203.972/00001-02', '9', '1977', '3174');
INSERT INTO HistoricodeConsumo (CNPJ, Mes, IdItem, QuantidadeMensal)
VALUES ('54.203.972/00001-02', '10', '3478', '451');
INSERT INTO HistoricodeConsumo (CNPJ, Mes, IdItem, QuantidadeMensal)
VALUES ('54.203.972/00001-02', '10', '725', '144');
INSERT INTO HistoricodeConsumo (CNPJ, Mes, IdItem, QuantidadeMensal)
VALUES ('54.203.972/00001-02', '10', '1977', '3403');
INSERT INTO HistoricodeConsumo (CNPJ, Mes, IdItem, QuantidadeMensal)
VALUES ('54.203.972/00001-02', '10', '204', '22');
INSERT INTO HistoricodeConsumo (CNPJ, Mes, IdItem, QuantidadeMensal)
VALUES ('02.961.029/00001-65', '8', '3478', '47');


INSERT INTO Localidade (CNPJ, NomedaInstituicao, Email, Cep, Numero)
VALUES ('53.467.667/00001-65', 'Instituto Butantan', 'instbutantan@gmail.com.br', '06755-110', '15');
INSERT INTO Localidade (CNPJ, NomedaInstituicao, Email, Cep, Numero)
VALUES ('16.812.244/00001-09', 'Lab. Codro', 'codro@gmail.com', '18052-649', '32');
INSERT INTO Localidade (CNPJ, NomedaInstituicao, Email, Cep, Numero)
VALUES ('69.431.551/00001-06', 'Instituto Medciv', 'medciv@gmail.com.br', '15610-686', '7');
INSERT INTO Localidade (CNPJ, NomedaInstituicao, Email, Cep, Numero)
VALUES ('54.497.459/00001-71', 'Universidade de Brasilia', 'unb@atendimento.unb.br', '72236-547', '19');
INSERT INTO Localidade (CNPJ, NomedaInstituicao, Email, Cep, Numero)
VALUES ('18.814.729/00001-67', 'Universidade Federal do Rio de Janeiro', 'ufrj@atendimento.ufrj.br', '21021-270', '24');
INSERT INTO Localidade (CNPJ, NomedaInstituicao, Email, Cep, Numero)
VALUES ('36.485.366/00001-45', 'Lab. Cenpilineu', 'cenpilineu@gmail.com', '72322-100', '3');

INSERT INTO Telefone (CNPJ, NumeroTelefone)
VALUES ('53.467.667/00001-65', '99771-0634');
INSERT INTO Telefone (CNPJ, NumeroTelefone)
VALUES ('16.812.244/00001-09', '99530-0634');
INSERT INTO Telefone (CNPJ, NumeroTelefone)
VALUES ('69.431.551/00001-06', '98343-0634');
INSERT INTO Telefone (CNPJ, NumeroTelefone)
VALUES ('54.497.459/00001-71', '99200-0010');
INSERT INTO Telefone (CNPJ, NumeroTelefone)
VALUES ('54.497.459/00001-71', '99200-0020');
INSERT INTO Telefone (CNPJ, NumeroTelefone)
VALUES ('18.814.729/00001-67', '99120-0001');
INSERT INTO Telefone (CNPJ, NumeroTelefone)
VALUES ('18.814.729/00001-67', '99120-0002');
INSERT INTO Telefone (CNPJ, NumeroTelefone)
VALUES ('36.485.366/00001-45', '99376-6912');


INSERT INTO PesquisadorChefe (CadastroPesquisador, Nome, Especialidade, Email)
VALUES ('13471', 'Marcus Andrade', 'Pnemologia', 'ma.an@gmail.com');
INSERT INTO PesquisadorChefe (CadastroPesquisador, Nome, Especialidade, Email)
VALUES ('9320', 'Kassius Kleyton', 'Imunologia', 'ka.ke@gmail.com');
INSERT INTO PesquisadorChefe (CadastroPesquisador, Nome, Especialidade, Email)
VALUES ('11210', 'Julia Freitas', 'Infectologia', 'ju.fre@gmail.com');
INSERT INTO PesquisadorChefe (CadastroPesquisador, Nome, Especialidade, Email)
VALUES ('15903', 'Leandro Roque', 'Imonologia', 'le.ro@gmail.com');
INSERT INTO PesquisadorChefe (CadastroPesquisador, Nome, Especialidade, Email)
VALUES ('7329', 'Marcela Santos', 'Pnemologia', 'ma.sa@gmail.com');


INSERT INTO Pesquisa (NumerodeVoluntarios, TaxadeEficacia, DatadeInicio, DatadeTermino, Pesquisador, CNPJ)
VALUES ('300', '74.6', '2020-09-21', '2020-11-22', '13471', '16.812.244/00001-09');
INSERT INTO Pesquisa (NumerodeVoluntarios, TaxadeEficacia, DatadeInicio, DatadeTermino, Pesquisador, CNPJ)
VALUES ('4000', '67', '2020-10-10', '2020-11-23', '9320', '54.497.459/00001-71');
INSERT INTO Pesquisa (NumerodeVoluntarios, TaxadeEficacia, DatadeInicio, DatadeTermino, Pesquisador, CNPJ)
VALUES ('1200', '96', '2020-05-04', '2020-09-09', '9320', '54.497.459/00001-71');
INSERT INTO Pesquisa (NumerodeVoluntarios, TaxadeEficacia, DatadeInicio, DatadeTermino, Pesquisador, CNPJ)
VALUES ('70000', '98.3', '2020-03-06', '2020-03-21', '7329', '53.467.667/00001-65');
INSERT INTO Pesquisa (NumerodeVoluntarios, TaxadeEficacia, DatadeInicio, DatadeTermino, Pesquisador, CNPJ)
VALUES ('30000', '94.7', '2020-06-17', '2020-09-18', '11210', '53.467.667/00001-65');


INSERT INTO Financiamento (CPFouCNPJ, PublicoouPrivado, Valor, DataFinanciamento, IdPesquisa)
VALUES ('082.057.020-63', 'Privado', '350', '2020-10-18', '2');
INSERT INTO Financiamento (CPFouCNPJ, PublicoouPrivado, Valor, DataFinanciamento, IdPesquisa)
VALUES ('930.990.230-27', 'Privado', '1200', '2020-10-29', '1');
INSERT INTO Financiamento (CPFouCNPJ, PublicoouPrivado, Valor, DataFinanciamento, IdPesquisa)
VALUES ('437.214.860-72', 'Privado', '120', '2020-10-22', '1');
INSERT INTO Financiamento (CPFouCNPJ, PublicoouPrivado, Valor, DataFinanciamento, IdPesquisa)
VALUES ('536.756.850-72', 'Privado', '2000', '2020-06-18', '5');
INSERT INTO Financiamento (CPFouCNPJ, PublicoouPrivado, Valor, DataFinanciamento, IdPesquisa)
VALUES ('64853058/0001-60', 'Publico', '80000', '2020-03-06', '4');


INSERT INTO Item_has_Pesquisa (IdItem, IdPesquisa)
VALUES ('3478', '1');
INSERT INTO Item_has_Pesquisa (IdItem, IdPesquisa)
VALUES ('3478', '2');
INSERT INTO Item_has_Pesquisa (IdItem, IdPesquisa)
VALUES ('725', '2');
INSERT INTO Item_has_Pesquisa (IdItem, IdPesquisa)
VALUES ('204', '3');
INSERT INTO Item_has_Pesquisa (IdItem, IdPesquisa)
VALUES ('1977', '4');
INSERT INTO Item_has_Pesquisa (IdItem, IdPesquisa)
VALUES ('204', '5');






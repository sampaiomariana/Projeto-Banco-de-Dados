create database covid
default character set utf8mb4
default collate utf8mb4_general_ci;

use covid;

create table Item (
Iditem int auto_increment not null,
Tipodeitem varchar(45) not null,
Producaohistorica int not null,
Producaodoultimomes int not null,
primary key (Iditem)
) default charset = utf8mb4;

create table Destino (
CNPJ int not null,
Nome varchar(45) not null,
Tipodeestabelecimento varchar(45) not null,
UF varchar (45) not null,
CEP int not null,
Número int not null,
primary key(CNPJ)
)default charset = utf8mb4;

create table Lote (
Idlote int auto_increment not null,
Fornecedor varchar(45) not null,
Valor float not null,
CNPJ int not null references Destino(CNPJ),
primary key(Idlote)
)default charset = utf8mb4; 

create table quantidadeitem (
Iditem int  not null references Item (Iditem),
Idlote int  not null references Lote (Idlote),
quantidade int not null
) default charset = utf8mb4; 

create table Dadosdaentrega(
IdLote int  not null references Lote(IDlote),
StatusLote varchar(45) not null,
DatadeSolicitacao date not null,
DatadeEntrega date not null
)default charset = utf8mb4; 


create table CasosCovid (
CNPJ int not null references Destino (CNPJ),
QuantidadeAtiva int not null,
QuantidadedeMortes int not null
)default charset = utf8mb4; 

create table HistoricodeConsumo (
CNPJ int not null references Destino (CNPJ),
Mes varchar(45) not null,
Iditem int not null references Item (Iditem),
QuantidadeMensal int not null
)default charset = utf8mb4; 

create table Localidade (
CNPJ int not null,
NomedaInstituicao varchar (45) not null,
Email varchar(45) not null,
Cep int not null,
Numero int not null,
primary key (CNPJ)
)default charset = utf8mb4; 

create table telefone (
NumeroTelefone int not null,
CNPJ int not null references Localidade (CNPJ),
primary key (NumeroTelefone)
)default charset = utf8mb4;



create table Pesquisa (
IdPesquisa int auto_increment not null,
NumerodeVoluntatios int not null,
TaxadeEficacia float not null,
DatadeInicio date not null,
DatadeTermino date not null,
CadastroPesquisador int  not null references PesquisadorChefe(CadastroPesquisador),
CNPJ int not null references Localidade(CNPJ),
primary key(IdPesquisa)
)default charset = utf8mb4; 

create table PesquisadorChefe ( 
CadastroPesquisador int auto_increment not null,
Nome varchar(45) not null,
Especialidade varchar(45) not null,
Email varchar(45) not null,
primary key(CadastroPesquisador)
)default charset = utf8mb4; 

create table Financiamento (
IdFinanciamento int auto_increment not null,
CPFouCNPJ int not null,
PublicoouPrivado varchar(45) not null,
Valor int not null,
DataFinanciamento date not null,
IdPesquisa int not null references Pesquisa(IdPesquisa),
primary key(IdFinanciamento)
)default charset = utf8mb4; 


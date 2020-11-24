create database covid
default character set utf8mb4
default collate utf8mb4_general_ci;

use covid;

create table Item (
IdItem int not null,
Nome varchar(45) not null,
Tipodeitem varchar(45) not null,
Producaohistorica int not null,
Producaodoultimomes int not null,
primary key (IdItem)
) default charset = utf8mb4;

create table Destino (
CNPJ varchar(45) not null,
Nome varchar(45) not null,
Tipodeestabelecimento varchar(45) not null,
UF varchar (45) not null,
CEP varchar(45) not null,
Numero int not null,
primary key (CNPJ)
)default charset = utf8mb4;

create table Lote (
IdLote int auto_increment not null,
Fornecedor varchar(45) not null,
Valor float not null,
CNPJDestino varchar(45) not null,
primary key (IdLote),
foreign key (CNPJDestino) references Destino(CNPJ)
)default charset = utf8mb4; 

create table Item_has_Lote (
IdItem int  not null,
IdLote int  not null,
quantidade int not null,
primary key (IdItem, IdLote),
foreign key (IdItem) references Item (IdItem),
foreign key (IdLote) references Lote (IdLote)
) default charset = utf8mb4; 

create table Dadosdaentrega(
IdLote int not null,
StatusLote varchar(45) not null,
DatadeSolicitacao date not null,
DatadeEntrega date,
primary key (IdLote),
foreign key (IdLote) references Lote(IdLote)
)default charset = utf8mb4; 


create table CasosCovid (
CNPJ varchar(45) not null,
QuantidadeInternados int not null,
QuantidadeCurados int not null,
QuantidadedeMortes int not null,
primary key (CNPJ),
foreign key (CNPJ) references Destino (CNPJ)
)default charset = utf8mb4; 

create table HistoricodeConsumo (
CNPJ varchar(45) not null,
Mes int not null,
IdItem int not null,
QuantidadeMensal int not null,
primary key (CNPJ, Mes, Iditem),
foreign key (CNPJ) references Destino (CNPJ),
foreign key (IdItem) references Item (IdItem)
)default charset = utf8mb4; 



create table Localidade (
CNPJ varchar(45) not null,
NomedaInstituicao varchar (45) not null,
Email varchar(45) not null,
Cep varchar(45) not null,
Numero int not null,
primary key (CNPJ)
)default charset = utf8mb4; 

create table Telefone (
CNPJ varchar(45) not null,
NumeroTelefone varchar(45) not null,
primary key (NumeroTelefone),
foreign key (CNPJ) references Localidade (CNPJ)
)default charset = utf8mb4;

create table PesquisadorChefe ( 
CadastroPesquisador int not null,
Nome varchar(45) not null,
Especialidade varchar(45) not null,
Email varchar(45) not null,
primary key(CadastroPesquisador)
)default charset = utf8mb4; 


create table Pesquisa (
IdPesquisa int auto_increment not null,
NumerodeVoluntarios int not null,
TaxadeEficacia float not null,
DatadeInicio date not null,
DatadeTermino date not null,
Pesquisador int  not null,
CNPJ varchar(45) not null,
primary key (IdPesquisa),
foreign key (Pesquisador) references PesquisadorChefe(CadastroPesquisador),
foreign key (CNPJ) references Localidade (CNPJ)
)default charset = utf8mb4; 


create table Financiamento (
IdFinanciamento int auto_increment not null,
CPFouCNPJ varchar(45) not null,
PublicoouPrivado varchar(45) not null,
Valor int not null,
DataFinanciamento date not null,
IdPesquisa int not null,
primary key (IdFinanciamento),
foreign key (IdPesquisa) references Pesquisa(IdPesquisa)
)default charset = utf8mb4; 


create table Item_has_Pesquisa (
IdItem int  not null,
IdPesquisa int not null,
primary key (IdItem, IdPesquisa),
foreign key (IdItem) references Item (IdItem),
foreign key (IdPesquisa) references Pesquisa (IdPesquisa)
) default charset = utf8mb4; 


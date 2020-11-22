create database projetoBD
default character set utf8mb4
default collate utf8mb4_general_ci;
use  projetoBD;

create table Item (
ItemID int auto_increment not null,
ProducaoMensal int not null,
ProducaoHistorica int not null,
primary key (ItemID)
) default charset = utf8mb4;

create table Lote (
LoteID int auto_increment not null,
TipoItem varchar(20) not null,
Quantidade int not null,
Fornecedor varchar(30) not null,
Valor int not null,
primary key (LoteID)
) default charset = utf8mb4;

create table DadosEntrega (
DataSolicitacao date not null,
DataEntrega date not null,
StatusEntrega varchar(20) not null,
ItemID int auto_increment not null references Item (ItemID),
primary key (ItemID)
) default charset = utf8mb4;

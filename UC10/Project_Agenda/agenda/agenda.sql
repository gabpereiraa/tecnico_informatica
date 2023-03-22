/**
 Agenda de contatos
 @author Professor José de Assis
*/

/*** banco de dados ***/
-- exibir os bancos de dados do servidor
show databases;
-- criar um novo banco de dados
create database dbagenda;
-- selecionar o banco de dados
use dbagenda;
-- excluir um banco de dados
drop database dbagenda;

/*** tabela ***/

-- create table (cria uma tabela)
-- int tipo de dados (número inteiro)
-- primary key (PK) "chave primária"
-- auto_increment (numeração automática)
-- varchar(30) tipo de dados String (máximo de caracteres)
-- not null (validação campo obrigatório)
create table contatos ( 
	id int primary key auto_increment,
    nome varchar(30) not null,
    fone varchar(15) not null,
	email varchar(30)
);

-- para verificar as tabelas existentes no banco de dados
show tables;

-- para descrever a tabela usamos o comando describe
describe contatos;

-- alterando o nome de um campo da tabela
alter table contatos change nome contato varchar(30) not null;
alter table contatos change fone telefone varchar(15) not null;

-- adicionando um campo a tabela
alter table contatos add column obs varchar(250);

-- adicionando um campo a tabela em um local específico
alter table contatos add column fone2 varchar(15) after telefone;

-- modificando um atributo (tipo de dados, validação etc)
alter table contatos modify column fone2 varchar(15) not null;
alter table contatos modify column contato varchar(50) not null;

-- apagar um campo da tabela
alter table contatos drop column obs;

-- apagar a tabela inteira
drop table contatos;

/**************** CRUD *****************/
-- CRUD [Create]
insert into contatos (nome,fone,email)
values ('José de Assis','99999-1234','jose@email.com');

insert into contatos (nome,fone)
values ('Bill Gates','99999-2222');

insert into contatos (nome,fone,email)
values ('Bruce Wayne','99999-3333','batman@email.com');

-- exemplo de erro (campo obrigatório)
insert into contatos (nome,email)
values ('Linus torvalds','linus@email.com');

-- exemplo de erro (limite de caracteres)
insert into contatos(nome,fone,email)
values ('Leandro Ramos','(55)(11)99999-8888','leando2email.com');

select * from contatos;







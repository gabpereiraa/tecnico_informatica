/**
 * Radical Motos
 * @author Professor José de Assis
 */

create database dbradicalmotos;
show databases;
use dbradicalmotos;

-- unique não permite valore duplicados
create table usuarios (
	iduser int primary key auto_increment,
	nome varchar(30) not null,
    login varchar(20) not null unique,
    senha varchar(250) not null
);

alter table usuarios add column perfil varchar(5) not null;

describe usuarios;

select * from usuarios;

select * from usuarios where login = 'joseassis';

insert into usuarios(nome,login,senha)
values ('Administrador','admin','admin');

-- md5() gera um hash (criptografia)
insert into usuarios(nome,login,senha)
values ('Paloma Oliveira','paloma',md5('123456'));
insert into usuarios(nome,login,senha)
values ('Kauan Oliveira','k',md5('123456'));

-- gerando um erro relacionado a unique
insert into usuarios(nome,login,senha)
values ('Paloma Duarte','p',md5('123@senac'));

select * from usuarios;

-- autenticar um usuário (logar)
select * from usuarios where login = 'vini' and senha = '123';

-- update
update usuarios set nome='Antony Stark', login='iron',
senha='1234' where iduser=7;

update usuarios set nome='Administrador', login='admin',
senha='admin',perfil='admin' where iduser=1;

update usuarios set perfil='user' where iduser=10;


-- delete
delete from usuarios where iduser=7;


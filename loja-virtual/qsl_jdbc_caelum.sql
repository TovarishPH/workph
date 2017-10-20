create database loja_virtual;

use loja_virtual;

CREATE TABLE Produto (
	id INTEGER AUTO_INCREMENT,
	nome VARCHAR(255),
	descricao VARCHAR(255),
	PRIMARY KEY (ID));

insert into Produto values (1, 'Geladeira', 'Geladeira duas portas');
insert into Produto values (2, 'Ferro de passar', 'Ferro de passar roupa com vaporizador');

select * from Produto;

SHOW PROCESSLIST;

create table Categoria (
	id INTEGER AUTO_INCREMENT,
	nome varchar(255),
	PRIMARY KEY (ID));

insert into Categoria (id,nome) values (1, 'Eletrodoméstico');
insert into Categoria (id,nome) values (2, 'Eletrônico');
insert into Categoria (id,nome) values (3, 'Móvel');

SELECT * FROM Categoria;

select * from Categoria as c join Produto as p on c.id = p.categoria_id;

alter table Produto add column categoria_id integer;

update Produto set categoria_id = 1 where id in(1,2);
update Produto set categoria_id = 2 where id = 3;
update Produto set categoria_id = 3 where id > 3;

select * from Produto where categoria_id = 1;

update Produto set categoria_id=1 where id=(select max(id) from Produto);
select max(id) from Produto;
update Produto set categoria_id=1 where id=15;
select c.id as c_id, c.nome as c_nome, p.id as p_id, p.nome as p_nome, p.descricao as p_descricao from Produto as p join Categoria as c on p.categoria_id = c.id;
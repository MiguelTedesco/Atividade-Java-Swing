SET @@global.time_zone = '-3:00';
CREATE USER acervo@localhost IDENTIFIED BY '';
CREATE DATABASE acervo CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL PRIVILEGES ON acervo.* TO acervo@localhost;

USE acervo;

CREATE TABLE filme(
	idFilme int not null auto_increment,
    titulo varchar(50) not null,
    classificacao int,
    resumo varchar(200),
    duracao float not null,
    primary key (idFilme)
);

insert into filme (titulo,
classificacao,
resumo,
duracao)
values('El Camino',
18,
"filme ...",
2.3);


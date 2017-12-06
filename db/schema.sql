CREATE TABLE IF NOT EXISTS carros (
    codigo int auto_increment primary key,
    marca varchar(50) not null,
    ano int not null,
    modelo int not null,
    fabricante varchar(50) not null,
    nome varchar(50) not null,
    chassi varchar(50) not null
);

CREATE TABLE IF NOT EXISTS herois (
    nome varchar(45) primary key,
    poder varchar(50) not null,
    data_nascimento date not null,
    pais varchar(50) not null
);

CREATE TABLE IF NOT EXISTS titulos (
    titulo varchar(45) primary key,
    data_nascimento date not null,
    diretor varchar(45) not null,
    duracao int not null
);
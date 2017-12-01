CREATE TABLE IF NOT EXISTS carros (
    codigo int auto_increment primary key,
    marca varchar(50),
    ano int,
    modelo int,
    fabricante varchar(50),
    nome varchar(50),
    chassi varchar(50)
);
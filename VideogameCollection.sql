drop database if exists videogamesCollection;
create database videogamesCollection;
use videogamesCollection;

--
#Tabla para los usuarios
--
create table users(
username varchar(8),
password varchar(8),
email varchar (25),
PRIMARY KEY (username));

--
#Tabla para los videojuegos de la colección
--
create table videogames(
title varchar(40),
company varchar(15),
gameConsole varchar(15),
releaseDate date,
completed int,
PRIMARY KEY (title));

--
#Tabla para las empresas de videojuegos
--
create table companies(
id varchar(20),
PRIMARY KEY (id));

--
#Tabla para las consolas.
--
create table videogameConsoles(
id varchar(20),
company varchar(20),
PRIMARY KEY (id),
FOREIGN KEY (company) REFERENCES companies(id));


## SELECTS para test ##
Select * from videogames;
Select * from users;
Select * from companies;
Select * from videogameConsoles;

## INSERTS de prueba ##
-- insert into videogames values ("Pokemon","Nintendo","gameboy","1994-12-10",1);
-- insert into videogames values ("Pokemon2","Nintendo","gameboy","1994-12-10",1);
-- insert into videogames values ("Pokemon3","Nintendo","gameboy","1994-12-10",1);

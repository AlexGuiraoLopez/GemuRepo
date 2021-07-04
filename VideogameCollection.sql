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
console varchar(15),
releaseYear int CHECK (releaseYear>=1700 && releaseYear <= year(curdate())),
completed int,
FOREIGN KEY (company) REFERENCES companies (id),
FOREIGN KEY (gameConsole) REFERENCES consoles (id),
PRIMARY KEY (title));

--
#Tabla para las empresas de videojuegos
--
create table companies(
id varchar(20),
PRIMARY KEY (id));

INSERT INTO companies VALUES ("Nintendo");
INSERT INTO companies VALUES ("Sega");
INSERT INTO companies VALUES ("Microsoft");
INSERT INTO companies VALUES ("Sony");
INSERT INTO companies VALUES ("Atari");

--
#Tabla para las consolas.
--
create table consoles(
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
insert into videogames values ("Pokemon Verde Hoja","Nintendo","Gameboy Advance",2004,1);

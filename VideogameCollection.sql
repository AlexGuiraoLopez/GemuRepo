drop database if exists videogamesCollection;
create database videogamesCollection;
use videogamesCollection;

create table users(
username varchar(8),
password varchar(8),
email varchar (25),
PRIMARY KEY (username));

create table videogames(
title varchar(40),
company varchar(15),
gameConsole varchar(15),
releaseDate date,
completed int,
PRIMARY KEY (title));

Select * from videogames;

## INSERTS de prueba ##
-- insert into videogames values ("Pokemon","Nintendo","gameboy","1994-12-10",1);
-- insert into videogames values ("Pokemon2","Nintendo","gameboy","1994-12-10",1);
-- insert into videogames values ("Pokemon3","Nintendo","gameboy","1994-12-10",1);

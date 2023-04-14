CREATE DATABASE ProyectoP4;
use ProyectoP4;

create table Usuario (

    cedula varchar(10) not null,
    nombre varchar(30) not null,
    clave varchar(15) not null,
   
    primary Key (cedula)

);

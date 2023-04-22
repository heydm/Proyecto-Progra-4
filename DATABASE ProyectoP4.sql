CREATE DATABASE ProyectoP4;
use ProyectoP4;

create table Usuario (

    cedula varchar(10) not null,
    nombre varchar(30) not null,
    clave varchar(15) not null,
   
    primary Key (cedula)

);

create table Tarjeta(

    numero varchar(10) not null,
    fecha varchar(30) not null,
  
    primary Key (numero)

);



create table Cliente(

    cedula varchar(10) not null,
    nombre varchar(30) not null,
    clave varchar(15) not null,
   telefono varchar(15) not null,
   correo varchar(15) not null,
  tarjeta varchar(15) not null,
    usuario varchar(15) not null,

    Constraint tarjetaF Foreign key (tarjeta) references Tarjeta primary Key (numero),
    Constraint usuarioF Foreign key (usuario) references Usuario primary Key (cedula),

    primary Key (cedula)

);

create table Marca(

    id varchar(10) not null,
    nombre varchar(30) not null,
  
    primary Key (id)

);

create table Modelo(

    id varchar(10) not null,
    nombre varchar(30) not null,
  
    primary Key (id)

);

create table Auto (

    placa varchar(30) not null,
    anio varchar(15) not null,
    marca varchar(30) not null,
    modelo varchar(30) not null,

    Constraint marcaF Foreign key (marca) references Marca primary Key (id),
    Constraint modeloF Foreign key (modelo) references Modelo primary Key (id),
    
    primary Key (placa)

);

create table Poliza (

    numero varchar(30) not null,
    fecha varchar(15) not null,
   automovil varchar(30) not null,
   cliente varchar(30) not null,

    Constraint autoF Foreign key (automovil) references Auto primary Key (placa),
    Constraint clienteF Foreign key (cliente) references Modelo primary Key (cedula),
    
    primary Key (placa)

);
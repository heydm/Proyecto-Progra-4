CREATE DATABASE Guia;

USE Guia;

create table Usuario (
  cedula varchar(10) not null,
  clave varchar(10),
  tipo integer,
  Primary key(cedula)
);

create table Cliente (
  cedula varchar(10) not null,
  nombre varchar(30),
  usuario varchar(10),
  Primary key(cedula)
);

create table Cuenta (
  numero varchar(10) not null,
  saldo double,
  cliente varchar(10),
  Primary key(numero)
);

alter table Cliente add foreign key (usuario) references Usuario(cedula);
alter table Cuenta add foreign key (cliente) references Cliente(cedula);

insert into Usuario (cedula,clave,tipo) 
	values ("111","111",1);

insert into Usuario (cedula,clave,tipo) 
	values ("222","222",1);

insert into Usuario (cedula,clave,tipo) 
	values ("333","333",2);	

insert into Cliente (cedula,nombre,usuario) 
	values ("111","J.Perez",'111');	

insert into Cliente (cedula,nombre,usuario) 
	values ("222","B.Banner",'222');	

insert into Cuenta (numero,saldo,cliente) 
	values ("1-111-11",100,'111');	
insert into Cuenta (numero,saldo,cliente) 
	values ("1-222-22",200,'111');		

insert into Cuenta (numero,saldo,cliente) 
	values ("2-111-11",150,'222');	

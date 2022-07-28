create table usuario(
    id_usuario numeric not null,
    login text unique not null,
    senha text not null,
    primary key(id_usuario)
);

create sequence seq_usuario
increment 1
start 1;

create table cargo (
    id_cargo numeric not null,
    nome text unique not null,
    primary key(id_cargo)
);
create sequence seq_cargo
increment 1
start 1;
  
insert into cargo (id_cargo, nome)
values (nextval('seq_cargo'), 'ROLE_ADMIN'); -- 1

insert into cargo (id_cargo, nome)
values (nextval('seq_cargo'), 'ROLE_USUARIO'); -- 2

insert into cargo (id_cargo, nome)
values (nextval('seq_cargo'), 'ROLE_MARKETING'); -- 3

create table usuario_cargo (
    id_usuario numeric not null,
    id_cargo numeric not null,
    primary key(id_usuario, id_cargo),
    constraint fk_usuario_cargo_cargo foreign key (id_cargo) references cargo (id_cargo),
  	constraint fk_usuario_cargo_usuario foreign key (id_usuario) references usuario (id_usuario)
);

insert into usuario (id_usuario, login, senha)
     values (nextval('seq_usuario'), 'maicon', '$2a$10$fP3fNbhDrkixHZHOqW4zKu9QdYiIWkhxH8NIXWcq7AQiUXAHivZEO'); --1

insert into usuario (id_usuario, login, senha)
     values (nextval('seq_usuario'), 'admin', '$2a$10$fP3fNbhDrkixHZHOqW4zKu9QdYiIWkhxH8NIXWcq7AQiUXAHivZEO'); --2
	 
insert into usuario (id_usuario, login, senha)
     values (nextval('seq_usuario'), 'user', '$2a$10$fP3fNbhDrkixHZHOqW4zKu9QdYiIWkhxH8NIXWcq7AQiUXAHivZEO'); --3

insert into usuario (id_usuario, login, senha)
     values (nextval('seq_usuario'), 'marketing', '$2a$10$fP3fNbhDrkixHZHOqW4zKu9QdYiIWkhxH8NIXWcq7AQiUXAHivZEO'); --4

insert into usuario_cargo (id_usuario, id_cargo)
values (1,1); --maicon / admin

insert into usuario_cargo (id_usuario, id_cargo)
values (1,2); --maicon / user

insert into usuario_cargo (id_usuario, id_cargo)
values (1,3); --maicon / marketing

insert into usuario_cargo (id_usuario, id_cargo)
values (2,1); --admin / admin

insert into usuario_cargo (id_usuario, id_cargo)
values (2,2); --admin / user

insert into usuario_cargo (id_usuario, id_cargo)
values (2,3); --admin / marketing

insert into usuario_cargo (id_usuario, id_cargo)
values (3,2); --user / usuario

insert into usuario_cargo (id_usuario, id_cargo)
values (4,3); --marketing / marketing



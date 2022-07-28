DROP TABLE usuario;

create table usuario(
    id_usuario numeric not null,
    login text unique not null,
    senha text not null,
    primary key(id_usuario)
);


DROP SEQUENCE seq_usuario;

create sequence seq_usuario
increment 1
start 1;

insert into usuario (id_usuario, login, senha)
     values (nextval('seq_usuario'), 'user', '$2a$10$fP3fNbhDrkixHZHOqW4zKu9QdYiIWkhxH8NIXWcq7AQiUXAHivZEO');
     
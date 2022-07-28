create table usuario(
    id_usuario numeric not null,
    login text unique not null,
    senha text not null,
    primary key(id_usuario)
);

create sequence seq_usuario
increment 1
start 1;

insert into usuario (id_usuario, login, senha)
     values (nextval('seq_usuario'), 'maicon', '123');

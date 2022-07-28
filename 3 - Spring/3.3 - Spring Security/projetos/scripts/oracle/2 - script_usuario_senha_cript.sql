DROP TABLE USUARIO;

CREATE TABLE USUARIO(
    ID_USUARIO NUMBER NOT NULL,
    LOGIN varchar2(512) UNIQUE NOT NULL,
    SENHA varchar2(512) NOT NULL,
    PRIMARY KEY(ID_USUARIO)
);

DROP SEQUENCE seq_usuario;

CREATE SEQUENCE seq_usuario
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

insert into usuario (id_usuario, login, senha)
     values (seq_usuario.nextval, 'user', '$2a$10$fP3fNbhDrkixHZHOqW4zKu9QdYiIWkhxH8NIXWcq7AQiUXAHivZEO');
     
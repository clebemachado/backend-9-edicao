CREATE TABLE Professor (
  id_professor NUMBER NOT NULL,
  id_universidade NUMBER NOT NULL,
  nome varchar2(255),
  salario NUMBER(10,2),
  PRIMARY KEY(id_professor, id_universidade)
);


BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE ' || 'Pessoa_X_Pessoa_Endereco';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE ' || 'Contato';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/*
BEGIN
   EXECUTE IMMEDIATE 'ALTER TABLE PET DROP CONSTRAINT ' || 'FK_PET_PESSOA';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;

BEGIN
	   EXECUTE IMMEDIATE 'ALTER TABLE PESSOA DROP CONSTRAINT ' || 'FK_PESSOA_PET';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;*/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE ' || 'Pessoa';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE ' || 'Endereco_Pessoa';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE ' || 'PET';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;

CREATE TABLE Pessoa (
  id_pessoa NUMBER NOT NULL,
  nome VARCHAR2(255) NULL,
  data_nascimento DATE,
  cpf VARCHAR2(11) NOT NULL,
  email VARCHAR2(255) NOT NULL,
  id_pet NUMBER NULL,
  PRIMARY KEY(id_pessoa)
);

BEGIN
  EXECUTE IMMEDIATE 'DROP SEQUENCE ' || 'seq_pessoa2';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -2289 THEN
      RAISE;
    END IF;
END;

CREATE SEQUENCE seq_pessoa2
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;


INSERT INTO PESSOA
(ID_PESSOA, NOME, DATA_NASCIMENTO, CPF, EMAIL)
VALUES(seq_pessoa2.nextval, 'Maicon Machado Gerardi', TO_DATE('08-09-1991', 'dd-mm-yyyy'), '48863250090', 'maicon.gerardi@dbccompany.com.br');

INSERT INTO PESSOA
(ID_PESSOA, NOME, DATA_NASCIMENTO, CPF, EMAIL)
VALUES(seq_pessoa2.nextval, 'Pedro Dantas', TO_DATE('08-09-1980', 'dd-mm-yyyy'), '29629873036', 'pedro@dbccompany.com.br');

INSERT INTO PESSOA
(ID_PESSOA, NOME, DATA_NASCIMENTO, CPF, EMAIL)
VALUES(seq_pessoa2.nextval, 'Bruna Da Silva', TO_DATE('06-01-1991', 'dd-mm-yyyy'), '01468462067', 'bruna@dbccompany.com.br');

INSERT INTO PESSOA
(ID_PESSOA, NOME, DATA_NASCIMENTO, CPF, EMAIL)
VALUES(seq_pessoa2.nextval, 'Fernanda Rosa', TO_DATE('06-05-1970', 'dd-mm-yyyy'), '01468462007', 'fernanda@dbccompany.com.br');


------ pet

CREATE TABLE PET (
  id_pet NUMBER NOT NULL,
  id_pessoa NUMBER NOT NULL,
  nome VARCHAR2(255) NOT NULL,
  tipo NUMBER NOT NULL,
  PRIMARY KEY(id_pet),
  CONSTRAINT FK_PET_PESSOA FOREIGN KEY (id_pessoa) REFERENCES Pessoa (id_pessoa)
);


ALTER TABLE PESSOA 
   ADD CONSTRAINT FK_PESSOA_PET FOREIGN KEY (id_pet) REFERENCES PET (id_pet);

BEGIN
  EXECUTE IMMEDIATE 'DROP SEQUENCE ' || 'seq_pet';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -2289 THEN
      RAISE;
    END IF;
END;

CREATE SEQUENCE seq_pet
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

  -- tipo 0 cachorro 1 gato 2 guaxinim
INSERT INTO PET
(id_pet, id_pessoa, nome, tipo)
VALUES(seq_pet.nextval, 1, 'Athos', 0);

UPDATE PESSOA 
   SET id_pet = 1 
 WHERE ID_PESSOA = 1;

INSERT INTO PET
(id_pet, id_pessoa, nome, tipo)
VALUES(seq_pet.nextval, 2, 'Caruzo', 2);

UPDATE PESSOA 
   SET id_pet = 2
 WHERE ID_PESSOA = 2;

INSERT INTO PET
(id_pet, id_pessoa, nome, tipo)
VALUES(seq_pet.nextval, 4, 'Paçoca', 1);

UPDATE PESSOA 
   SET id_pet = 3
 WHERE ID_PESSOA = 4;

------ contato

CREATE TABLE Contato (
  id_contato NUMBER NOT NULL,
  id_pessoa NUMBER NOT NULL,
  tipo NUMBER,
  numero VARCHAR2(14),
  descricao VARCHAR2(100),
  PRIMARY KEY(id_contato),
  CONSTRAINT FK_CONTATO_PESSOA FOREIGN KEY (id_pessoa) REFERENCES Pessoa (id_pessoa)
);

BEGIN
  EXECUTE IMMEDIATE 'DROP SEQUENCE ' || 'seq_contato';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -2289 THEN
      RAISE;
    END IF;
END;

CREATE SEQUENCE seq_contato
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

-- contatos do maicon
INSERT INTO CONTATO
(ID_CONTATO, ID_PESSOA, TIPO, NUMERO, DESCRICAO)
VALUES(seq_contato.nextval, 1, 0, '51955565585', 'whatsapp');

INSERT INTO CONTATO
(ID_CONTATO, ID_PESSOA, TIPO, NUMERO, DESCRICAO)
VALUES(seq_contato.nextval, 1, 1, '48335698566', 'trabalho');

-- contatos do pedro
INSERT INTO CONTATO
(ID_CONTATO, ID_PESSOA, TIPO, NUMERO, DESCRICAO)
VALUES(seq_contato.nextval, 2, 0, '51955565585', 'celular');

INSERT INTO CONTATO
(ID_CONTATO, ID_PESSOA, TIPO, NUMERO, DESCRICAO)
VALUES(seq_contato.nextval, 2, 1, '48335698566', 'casa');

-- contatos da bruna
INSERT INTO CONTATO
(ID_CONTATO, ID_PESSOA, TIPO, NUMERO, DESCRICAO)
VALUES(seq_contato.nextval, 3, 0, '51995866695', 'whatsapp');

-- contatos da bruna
INSERT INTO CONTATO
(ID_CONTATO, ID_PESSOA, TIPO, NUMERO, DESCRICAO)
VALUES(seq_contato.nextval, 3, 0, '51995866695', 'whatsapp');

-- contatos da fernanda



------- endere�o
CREATE TABLE Endereco_Pessoa (
  id_endereco NUMBER NOT NULL,
  tipo NUMBER NOT NULL,
  logradouro VARCHAR2(200) NOT NULL,
  numero NUMBER NOT NULL,
  complemento VARCHAR2(200) NULL,
  cep VARCHAR2(8) NOT NULL,
  cidade VARCHAR2(300) NOT NULL,
  estado VARCHAR2(100) NOT NULL,
  pais VARCHAR2(100) NOT NULL,
  PRIMARY KEY(id_endereco)
);

BEGIN
  EXECUTE IMMEDIATE 'DROP SEQUENCE ' || 'seq_endereco_contato';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -2289 THEN
      RAISE;
    END IF;
END;

CREATE SEQUENCE seq_endereco_contato
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;


INSERT INTO ENDERECO_PESSOA
(ID_ENDERECO, TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, CIDADE, ESTADO, PAIS)
VALUES(seq_endereco_contato.nextval, 0, 'Rua José Dos Santos', 120, 'casa', '88080700', 'Florianópolis', 'SC', 'Brasil');

INSERT INTO ENDERECO_PESSOA
(ID_ENDERECO, TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, CIDADE, ESTADO, PAIS)
VALUES(seq_endereco_contato.nextval, 1, 'Rua Pedro Canvas', 800, 'apto 2', '88805500', 'Porto Alegre', 'RS', 'Brasil');

INSERT INTO ENDERECO_PESSOA
(ID_ENDERECO, TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, CIDADE, ESTADO, PAIS)
VALUES(seq_endereco_contato.nextval, 0, 'Rua Pedro Fantin', 800, 'apt 52', '88080700', 'Florianópolis', 'SC', 'Brasil');

INSERT INTO ENDERECO_PESSOA
(ID_ENDERECO, TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, CIDADE, ESTADO, PAIS)
VALUES(seq_endereco_contato.nextval, 0, 'Rua Mario Quintana', 50, NULL, '88805800', 'Santos', 'SP', 'Brasil');

INSERT INTO ENDERECO_PESSOA
(ID_ENDERECO, TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, CIDADE, ESTADO, PAIS)
VALUES(seq_endereco_contato.nextval, 1, 'Avenida Brasil', 1855, NULL, '88754566', 'Rio De Janeiro', 'RJ', 'Brasil');

INSERT INTO ENDERECO_PESSOA
(ID_ENDERECO, TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, CIDADE, ESTADO, PAIS)
VALUES(seq_endereco_contato.nextval, 0, 'Avenida Luis Carvalho', 444, NULL, '88987788', 'Rio De Janeiro', 'RJ', 'Brasil');



CREATE TABLE Pessoa_X_Pessoa_Endereco (
  id_pessoa NUMBER NOT NULL,
  id_endereco NUMBER NOT NULL,
  PRIMARY KEY(id_pessoa, id_endereco),
  CONSTRAINT FK_CE_PESSOA FOREIGN KEY (id_pessoa) REFERENCES Pessoa (id_pessoa),
  CONSTRAINT FK_CE_ENDERECO_PESSOA FOREIGN KEY (id_endereco) REFERENCES Endereco_Pessoa (id_endereco)
);


-- enderecos maicon
INSERT INTO PESSOA_X_PESSOA_ENDERECO
(ID_PESSOA, ID_ENDERECO)
VALUES(1, 1);

INSERT INTO PESSOA_X_PESSOA_ENDERECO
(ID_PESSOA, ID_ENDERECO)
VALUES(1, 2);

INSERT INTO PESSOA_X_PESSOA_ENDERECO
(ID_PESSOA, ID_ENDERECO)
VALUES(1, 3);

-- enderecos bruna
INSERT INTO PESSOA_X_PESSOA_ENDERECO
(ID_PESSOA, ID_ENDERECO)
VALUES(3, 3);

-- fernanda
INSERT INTO PESSOA_X_PESSOA_ENDERECO
(ID_PESSOA, ID_ENDERECO)
VALUES(4, 4);

INSERT INTO PESSOA_X_PESSOA_ENDERECO
(ID_PESSOA, ID_ENDERECO)
VALUES(4, 5);
------------
-- Aula 1 --
------------

---- Instalar
• Rodar docker
  docker run --name mongodb -d -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=root -v /data/mongodb mongo


• Instalar CLI visual
https://www.mongodb.com/try/download/compass

• Conectar
mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false


---- Dados

-- Criar DB

criar vemserdbc
use vemserdbc
db.createCollection("alunos")

-- Inserir

db.alunos.insert(
    {
        "nome" : "Rafael Lazzari", 
        "data_nascimento" : new Date (1990,01,27)
    }
)


-- Buscar

- FIND com navegação no documento

db.alunos.find({})

// Resposta
{ "_id" : ObjectId ("56cb0002b6d75ec12f75d3b5") } 
"nome" : "Rafael", "data_nascimento" : ISO Date("1994-03-26T03:00:00Z") }


db.alunos.find().pretty()

db.alunos.find(
{ 
  "nome" : "Rafael"
}
).pretty()


-- Remover

db.alunos.remove({ "_id" : ObjectId ("62ead7e9f7d7e778d30c15cf") } )


// Ex
SELECT a.(*)
    FROM habilidades as h
    JOIN alunos as a ON a.id = h.aluno_id
    WHERE h.nome="inglês"
    AND a.nome = "Rafael";


-- FIND com OR e IN

-- IN
db.alunos.find({
    "curso.nome" : "Sistemas de informação",
    "curso.nome" : "Ciência da computação"
    })

-- OR
db.alunos.find({
    $or : [
        {"curso.nome" : "Sistemas de informação"},
        {"curso.nome" : "Ciência da computação"}    
    ]
})


db.alunos.find({
     $or : [
        {"curso.nome" : "Sistemas de informação"},
        {"curso.nome" : "Engenharia Química"},
        {"curso.nome" : "Moda"}
    ],
    "nome" : "Daniela"
 })


SELECT * FROM cursos 
WHERE nome in ("Sistemas de informação", "Engenharia Química","Moda");


db.alunos.find({
    "curso.nome" : {
        $in : ["Sistema de informação", "Artes"]
        }
})


// Exemplo sql
CREATE TABLE alunos (id INTEGER AUTO_INCREMENT PRIMARY KEY, nome VARCHAR (255)
	, data_nascimento DATE);
INSERT INTO alunos  VALUES (1, "Rafael", "19940226")


{
    "nome" : "João",
    "data_nascimento" : new Date (1994,02,26), 
    "curso" : {
        "nome" : "Sistemas de informação"
    },
    "notas" : [10.0, 9.0, 4.5],
    "habilidades": [
        {
            "nome" : "inglês",
            "nível" : "avançado"
        },
        {
            "nome" : "taekwondo",
            "nível" : "básico"
        }
    ]
}


-- HW

db.createCollection("usuario")

use usuario

db.usuario.insert(
    {
        "nome" : "Rafael Lazzari", 
        "data_nascimento" : new Date (1990,01,27)
    }
)

db.alunos.find(
	{ 
	  "nome" : "Rafael"
	}
)

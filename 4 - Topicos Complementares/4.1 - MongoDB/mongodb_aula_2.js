------------
-- Aula 2 --
------------

---- Insert One
db.alunos.insertOne(
{  
  "nome": "Rafael",
  "data_nascimento": new Date (1994,01,27), 
  "idade": 27,
  "curso": {
    "nome": "Ciência da computação"
  },
  "notas": [10.0, 9.0, 7.5],
  "habilidades": [
    {
      "nome": "inglês",
      "nível": "avançado"
    },
    {
      "nome": "jogatina",
      "nível": "intermediário"
    }
  ],
  "status": "A"
})


---- Insert Many
db.alunos.insertMany([
  { "nome": "Rafael", "data_nascimento": new Date (1994,01,27), "idade": 27, "curso": { "nome": "Ciência da computação" }, "notas": [10.0, 9.0, 7.5], "habilidades": [ {  "nome": "inglês",  "nível": "avançado" }, {  "nome": "jogatina",  "nível": "intermediário" } ], "status": "A"},
  { "nome": "Miguel", "data_nascimento": new Date (1993,01,27), "idade": 26, "curso": { "nome": "Artes" }, "notas": [8.0, 9.0, 2.5], "habilidades": [ {  "nome": "inglês",  "nível": "básico" }, {  "nome": "jogatina",  "nível": "avançado" } ], "status": "A"},
  { "nome": "Gabriel", "data_nascimento": new Date (1992,01,27), "idade": 25, "curso": { "nome": "Matemática" }, "notas": [8.0, 10.0, 6.5], "habilidades": [ {  "nome": "inglês",  "nível": "avançado" }, {  "nome": "jogatina",  "nível": "básico" } ], "status": "I"},
  { "nome": "Ana", "data_nascimento": new Date (1990,01,27), "idade": 23, "curso": { "nome": "Física" }, "notas": [8.0, 9.0, 9.5], "habilidades": [ {  "nome": "inglês",  "nível": "intermediário" }, {  "nome": "jogatina",  "nível": "avançado" } ], "status": "A"}
])


---- Delete
db.alunos.deleteOne( { nome: "Rafael", idade: 25 } )
db.alunos.deleteMany({}) // deleta todos documentos


---- Find Equal
{ <field1>: <value1>, ... }
{ status: "D" }

SELECT * FROM alunos WHERE status = "D"


db.alunos.find({
    status: "D"
})

db.alunos.find({
    "habilidades": {nome: "jogatina", "nível": "avançado"}
})

---- Find AND
{ status: "A", idade: { $lt: 25 } }

SELECT * FROM alunos WHERE status = "A" AND idade < 25

db.alunos.find({
    status: "A", 
    idade: { $lt: 25 }
})


---- Find OR / IN
{ <field1>: { <operator1>: <value1> }, ... }
{ status: { $in: [ "A", "D" ] } }

SELECT * FROM alunos WHERE status in ("A", "D")


db.alunos.find({
    $or : [
        {"curso.nome" : "Ciência da computação"},
        {"curso.nome" : "Física"},
        {"curso.nome" : "Artes"}
    ],
    "nome" : "Ana"
 })


---- Find Expressão
{ nome: /^Ra/ } 

SELECT * FROM alunos WHERE nome LIKE "Ra%")

db.alunos.find({
    "nome": /^Ra/ 
})


db.alunos.find({
  nome: {
    $regex: "ra*",
    $options: "i"
  }
})

---- Find Campos aninhados
{"curso.nome" : "Física"}

db.alunos.find({
   "curso.nome" : "Física"
})

db.alunos.find({
    "habilidades.nome": "jogatina",
    "habilidades.nível": "avançado"
})


---- Update
{
  <update operator>: { <field1>: <value1>, ... },
  <update operator>: { <field2>: <value2>, ... },
  ...
}

db.alunos.updateOne(
   { nome: "Rafael" },
   {
     $set: { "nome": "Rafael", status: "X" }           
   }
)

//{ $unset: "curso.nome" }


---- Find Ordenado

db.alunos.find({
    notas: { $gte: 9 } 
}).sort("nome")


db.alunos.find({ }).sort( { idade : 1, status: -1 } )

ORDER BY campo1, campo2 ASC(1) / DESC(-1)


db.alunos.insertMany([
{ "_id" : 1, "nome" : "aaa", "status" : "ID" },
{ "_id" : 2, "nome" : "bbb", "status" : "ID" },
{ "_id" : 3, "nome" : "ccc", "status" : "ID" },
{ "_id" : 4, "nome" : "eee", "status" : "ID" },
{ "_id" : 5, "nome" : "ddd", "status" : "ID" }
])

db.alunos.find({ }).sort( { _id : 1 } )

db.alunos.find({ status: "ID" }).sort( { nome: 1, _id : -1 } )

db.alunos.deleteMany({ _id : { $lte : 5} })


---- Find Limite

db.alunos.find({ status: "ID" }).sort( { _id : -1 } ).limit(3)


---- Find Array

// Busca nos elementos do array
db.alunos.find({
    notas: { $lt: 4 } 
})


-- produtos

// Limpar a collection
db.inventory.deleteMany({ })

db.inventory.insertMany([
   { item: "journal", qty: 25, tags: ["blank", "red"], dim_cm: [ 14, 21 ] },
   { item: "notebook", qty: 50, tags: ["red", "blank"], dim_cm: [ 14, 21 ] },
   { item: "paper", qty: 100, tags: ["red", "blank", "plain"], dim_cm: [ 14, 21 ] },
   { item: "planner", qty: 75, tags: ["blank", "red"], dim_cm: [ 22.85, 30 ] },
   { item: "postcard", qty: 45, tags: ["blue"], dim_cm: [ 10, 15.25 ] }
]);


// Na ordem exata
db.inventory.find( { tags: ["red", "blank"] } )

// Contém
db.inventory.find( { tags: { $all: ["red", "blank"] } } )

db.inventory.find( { tags: "red" } )

db.inventory.find( { dim_cm: { $gt: 25 } } )


// Condição múltipla, no array todo
db.inventory.find( { dim_cm: { $gt: 15, $lt: 20 } } )

// Condição múltipla, no mesmo elemento do array 
db.inventory.find( { dim_cm: { $elemMatch: { $gt: 22, $lt: 30 } } } )

// Usando índice do array, segundo elem > 25
db.inventory.find( { "dim_cm.1": { $gt: 25 } } )

// Tamanho
db.inventory.find( { "tags": { $size: 3 } } )

// Selecionar item do array
//db.inventory.find( { },{ "tags.$": 1 } )


---- Projections

// Limpar a collection
db.inventory.deleteMany({ })

// Popular a collection
db.inventory.insertMany( [
  { item: "journal", status: "A", size: { h: 14, w: 21, uom: "cm" }, instock: [ { warehouse: "A", qty: 5 } ] },
  { item: "notebook", status: "A",  size: { h: 8.5, w: 11, uom: "in" }, instock: [ { warehouse: "C", qty: 5 } ] },
  { item: "paper", status: "D", size: { h: 8.5, w: 11, uom: "in" }, instock: [ { warehouse: "A", qty: 60 } ] },
  { item: "planner", status: "D", size: { h: 22.85, w: 30, uom: "cm" }, instock: [ { warehouse: "A", qty: 40 } ] },
  { item: "postcard", status: "A", size: { h: 10, w: 15.25, uom: "cm" }, instock: [ { warehouse: "B", qty: 15 }, { warehouse: "C", qty: 35 } ] }
]);

db.inventory.find( {}, { _id: 0, item: 1, "size.uom": 1 } )


SELECT item, size from inventory WHERE status = "A"

$dateToString: { date: new Date(), format: "%Y-%m-%d" }


-- Alunos
db.alunos.find({ status: "A"}, 
{
 nome_idade: { $concat: [ "$nome", " - ", { $convert: { input: "$idade", to: "string" }}] },
 data_nascimento: { $dateToString: { date: "$data_nascimento", format: "%d/%m/%Y" } },
 status: 1
})


---- Aggregate

db.orders.insertMany( [
   { _id: 0, productName: "Steel beam", status: "new", quantity: 10 },
   { _id: 1, productName: "Steel beam", status: "urgent", quantity: 20 },
   { _id: 2, productName: "Steel beam", status: "urgent", quantity: 30 },
   { _id: 3, productName: "Iron rod", status: "new", quantity: 15 },
   { _id: 4, productName: "Iron rod", status: "urgent", quantity: 50 },
   { _id: 5, productName: "Iron rod", status: "urgent", quantity: 10 }
] )

db.orders.insertMany( [
   { _id: 6, productName: "Cadeira", status: "urgent", quantity: 10 },
   { _id: 7, productName: "Cadeira", status: "urgent", quantity: 10 }
] )

// urgentes
db.orders.aggregate( [
   { $match: { status: "urgent" } },
   { $group: { _id: "$productName", sumQuantity: {$sum: "$quantity" }} }
] )

// sem cadeira
db.orders.aggregate( [
   { $match: { status: "urgent", productName: { $nin: [ "Cadeira" ] } }},
   { $group: { _id: "$productName", sumQuantity: {$sum: "$quantity" }} }
] )



---- Geolocalização / busca proximidade

db.alunosgeo.insertMany( [

  {
    "nome" : "Guilherme",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5882133, -46.63235580000003]}
  },{
    "nome" : "Paulo",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5707855, -46.643499399999996]}
  },
  {
    "nome" : "Ana",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5829461, -46.6315126]}
  },
  {
    "nome" : "Carlos",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5834181, -46.6418552]}
  },
  {
    "nome" : "Lúcia",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5702415, -46.635375]}
  },
  {
    "nome" : "Stella",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5623743, -46.6478634]}
  },
  {
    "nome" : "Daniela",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5690615, -46.6592789]}
  },
  {
    "nome" : "Eduardo",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5552147, -46.6574764]}
  },
  {
    "nome" : "Felipe",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5606041, -46.6663599]}
  },
  {
    "nome" : "Marco",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5625317, -46.6686773]}
  },
  {
    "nome" : "Mariana",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5617056, -46.662454600000004]}
  },
  {
    "nome" : "Juliana",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5578111, -46.6656303]}
  },
  {
    "nome" : "Adriana",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5653639, -46.661725]}
  },
  {
    "nome" : "Roberto",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5549787, -46.6588497]}
  },
  {
    "nome" : "Marcelo",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5640265, -46.6527128]}
  },
  {
    "nome" : "Sofia",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5673307, -46.6529703]}
  },
  {
    "nome" : "Sheila",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5672914, -46.6462326]}
  },
  {
    "nome" : "William",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5803502, -46.6352892]}
  },
  {
    "nome" : "Manoela",
    "localizacao" : { "type" : "Point", "coordinates" : [-23.5831428, -46.6334867]}
  }
])

// Criar indice esfera 2d
db.alunosgeo.createIndex({"localizacao": "2dsphere"})

db.alunosgeo.aggregate([
{ 
  $geoNear : {
        near : {
            coordinates: [-23.5640265, -46.6527128],
            type : "Point"
        },
        distanceField : "distancia.calculada",
        spherical : true
    }
}, { $skip :1 }, { $limit : 4 }
])



-- Links
https://www.mongodb.com/docs/manual/reference/sql-aggregation-comparison/
https://www.practical-mongodb-aggregations.com/guides/guides.html




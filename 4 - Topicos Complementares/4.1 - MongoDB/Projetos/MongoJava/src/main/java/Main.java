import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Arrays;
import java.util.Date;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;

public class Main {

    public static void main(String[] args) {

        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("vemserdbc");

        MongoCollection<Document> alunos = mongoDatabase.getCollection("alunos_java");
        MongoCollection<Document> orders = mongoDatabase.getCollection("orders");

        // Novo aluno
        Document novoAluno = new Document("nome", "Juarez")
                //.append("_id", 4)
                .append("data_nascimento", new Date(2003, 10, 10))
                .append("curso", new Document("nome", "Historia"))
                .append("notas", Arrays.asList(10, 9, 8))
                .append("habilidades", Arrays.asList(new Document()
                                .append("nome", "Ingles ")
                                .append("nível", "Básico"),
                        new Document()
                                .append("nome", "Espanhol")
                                .append("nível", "Básico")));

        // Insere novoAluno
        //alunos.insertOne(novoAluno);

        //alunos.updateOne(Filters.eq("nome", "Nicolas"), new Document("$set", new Document("data_nascimento" , new Date(2020-1900, 04, 11))));

        //alunos.deleteOne(Filters.eq("nome" , "Joao Silva"));

        // Busca aluno
        System.out.println("-- Aluno");
        Document aluno = alunos.find(new Document("nome" , "Juearez"))
                .first();
        System.out.println(aluno);

        // Agrega dados
        System.out.println("-- Cursos");
        alunos.aggregate(Arrays.asList(
                        match(Filters.empty()),
                        group("$curso.nome", Accumulators.sum("qtd", 1))))
                .forEach(doc -> System.out.println(doc.toJson()));

        System.out.println("-- Orders");
        orders.aggregate(
                Arrays.asList(
                        match(Filters.eq("status", "urgent")),
                        group("$productName", Accumulators.sum("sumQuantity", "$quantity"))
                )).forEach(doc -> System.out.println(doc.toJson()));

        System.out.println("-- Orders sem Cadeira");
        orders.aggregate(
                Arrays.asList(
                        match(new Document("status", "urgent")
                                .append("productName", new Document( "$nin", Arrays.asList("Cadeira")  ))),
                        group("$productName", Accumulators.sum("sumQuantity", "$quantity"))
                )).forEach(doc -> System.out.println(doc.toJson()));

        mongoClient.close();
    }
}

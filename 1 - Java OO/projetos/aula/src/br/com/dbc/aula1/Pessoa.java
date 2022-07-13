package br.com.dbc.aula1;

import br.com.dbc.aula3.Telefone;

public class Pessoa {
    String nome;
    int idade;
    Telefone telefone;

    void imprimirDados(){
        System.out.println("Nome: "+ nome + " com "+ idade + " anos.");
    }

    String retornarIdade(){
        return idade + " anos.";
    }

    void conversar(Pessoa pessoa, String mensagem){
        System.out.println(this.nome + " falou "+ mensagem + " com "+ pessoa.nome);
    }

    void mandarWhatsApp(Pessoa pessoa, String mensagem){
        System.out.println(telefone + " mandou " + mensagem + " para " + pessoa.telefone);
    }

    public String toString(){
        return nome + " - " + retornarIdade() + this.telefone;
    }
}

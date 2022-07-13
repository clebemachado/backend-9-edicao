package br.com.dbc.aula3;

public class Main {
    public static void main(String[] args) {
        Pessoa prates = new Pessoa(); // objeto da classe Pessoa
        prates.nome = "Leonardo Prates";
        prates.idade = 38;

        Telefone telefonePrates = new Telefone();
        telefonePrates.ddd = "51";
        telefonePrates.numero = "985566896";
        telefonePrates.tipo = 1;

        prates.telefone = telefonePrates;

        System.out.println(prates.idade);

        String idade = prates.retornarIdade();
        System.out.println(idade);
        System.out.println(prates.retornarIdade());

        Pessoa rafael = new Pessoa();
        rafael.nome = "Rafael Lazzari";
        rafael.idade = 18;
        rafael.telefone = new Telefone();
        rafael.telefone.ddd = "51";
        rafael.telefone.numero = "9987856687";
        rafael.telefone.tipo = 2;

        prates.conversar(rafael, "preciso de um aumento urgente");

        prates.mandarWhatsApp(rafael, "obrigado pela ajuda");

        System.out.println(prates);
        System.out.println(prates.telefone);
    }
}

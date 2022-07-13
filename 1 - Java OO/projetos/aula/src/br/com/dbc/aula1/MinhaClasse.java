package br.com.dbc.aula1;

import java.util.Scanner;

public class MinhaClasse {

    public static void main(String[] args) {
//        String mensagem = "Olá mundo";
//        System.out.println(mensagem);
//        System.out.println("Olá mundo");
//        System.out.println(args);

        Scanner scanner = new Scanner(System.in);

        System.out.println("informe o nome do usuário: ");
        String nomeDoUsuario = scanner.nextLine();

        System.out.println("informe a idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        String minhaString = scanner.nextLine();

        System.out.println(nomeDoUsuario);
        System.out.println(idade);
        System.out.println(minhaString);

    }

    public void meuNovoMetodo(){

    }
}

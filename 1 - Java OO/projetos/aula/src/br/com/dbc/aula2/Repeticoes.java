package br.com.dbc.aula2;

import java.util.Scanner;

public class Repeticoes {
    public static void main(String[] args) {
//        System.out.println("iniciou o for");
//        for(int variavelControle = 0;variavelControle<5;variavelControle++){
//            System.out.println(variavelControle);
//        }
//        System.out.println("finalizou o for");
//
//        int[] notas = {10,4,5,8};
//        for(int nota : notas){
//            System.out.println(nota);
//        }
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("digite um número: ");
//        int numero = scanner.nextInt();
//        scanner.nextLine();
//
//        while(numero != 0){
//            System.out.println("o número é " + numero);
//            System.out.println("digite um número: ");
//            numero = scanner.nextInt();
//            scanner.nextLine();
//        }

        int numero = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("digite um número: ");
            numero = scanner.nextInt();
            scanner.nextLine();
        } while(numero != 0);

        String palavra = null;
//        while(palavra.equals("fim")){
        while("fim".equals(palavra)){
            
        }
    }
}

package br.com.dbc.aula2;

public class VetoresEMatrizes {
    public static void main(String[] args) {
//        int[] numeros = new int[5];
//
//        numeros[4] = 5;
//        numeros[1] = 10;
//        numeros[0] = 22;
//
//        System.out.println(numeros[4]);
//        System.out.println(numeros[2]);
//
//        String[] vetorStr = new String[2];
//        System.out.println(vetorStr[1]);
//
//        String[] meuVetor = {"Maicon", "Rafael", "Pedro", "Cleber"};
//        System.out.println(meuVetor[3]);
//        System.out.println(meuVetor.length);
//        System.out.println(meuVetor[meuVetor.length - 1]);
//        System.out.println(meuVetor[4]);

        int[][] matriz = new int[2][2];
        matriz[0][1] = 5;

        matriz[1][1] = 8;
        System.out.println(matriz[0][0]);
        System.out.println(matriz[1][1]);
        System.out.println(matriz[matriz.length - 1][matriz[0].length - 1]);

        int[][] outraMatriz = {
                {10, 15},
                {15, 20}
        };


    }
}

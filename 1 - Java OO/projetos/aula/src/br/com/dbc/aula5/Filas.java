package br.com.dbc.aula5;

import java.util.LinkedList;
import java.util.Queue;

public class Filas {
    public static void main(String[] args) {
        Queue<String> minhaFila = new LinkedList<>();
        minhaFila.add("Roberto");
        minhaFila.add("Fernanda");
        minhaFila.add("Pedro");

        System.out.println(minhaFila);
        String primeiro = minhaFila.poll();
        System.out.println(primeiro);
        System.out.println(minhaFila);
    }
}

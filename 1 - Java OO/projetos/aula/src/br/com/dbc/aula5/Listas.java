package br.com.dbc.aula5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Listas {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>(Arrays.asList("bata.a", "assf"));
        System.out.println(lista);

        ArrayList<String> minhaListaDeComprasNova = new ArrayList<>();
        Collections.addAll(minhaListaDeComprasNova, "batata", "milho", "creme de leite");
        System.out.println(minhaListaDeComprasNova);

        List<String> listaDeCompras = new ArrayList<>();
        listaDeCompras.add("batata"); // 0
        listaDeCompras.add("creme de leite"); // 1
        listaDeCompras.add("frango"); // 2
        listaDeCompras.add("cebola"); // 3
        System.out.println(listaDeCompras.size());
        System.out.println(listaDeCompras.get(2));
        String removido = listaDeCompras.remove(2);
        System.out.println(removido);
        System.out.println(listaDeCompras);
        listaDeCompras.set(1, "tomate");
        System.out.println(listaDeCompras);
    }
}

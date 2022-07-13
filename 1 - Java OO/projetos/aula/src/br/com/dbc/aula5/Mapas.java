package br.com.dbc.aula5;

import java.util.HashMap;
import java.util.Map;

public class Mapas {
    public static void main(String[] args) {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("123", "Maicon"); // chave = valor
        mapa.put("125", "Eduardo");
        mapa.put("156", "Gustavo");

        mapa.put("123", "Guilherme"); // chave = valor

        System.out.println(mapa);
        System.out.println(mapa.get("125"));
        System.out.println(mapa.remove("123"));
        System.out.println(mapa);
        System.out.println(mapa.entrySet());
        System.out.println(mapa.keySet());
        System.out.println(mapa.values());

//        Map<Integer, String> mapaInteiro = new HashMap<>();
//        mapaInteiro.put(123, "Maicon"); // chave = valor
//        mapaInteiro.put(125, "Eduardo");
//        mapaInteiro.put(156, "Gustavo");
    }
}

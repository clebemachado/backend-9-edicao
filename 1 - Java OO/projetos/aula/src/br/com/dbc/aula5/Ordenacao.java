package br.com.dbc.aula5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ordenacao {
    public static void main(String[] args) {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro("ford ka", 150000)); // 0
        carros.add(new Carro("mercedes Classe A", 1510)); // 1
        carros.add(new Carro("mercedes Classe A", 1502)); // 2
        carros.add(new Carro("fusca 78", 2000000)); // 3

        // negativo = menor
        // 0 = igual
        // positivo = maior
        System.out.println(carros);
        // por modelo crescente
//        carros.sort(new Comparator<Carro>() {
//            @Override
//            public int compare(Carro o1, Carro o2) {
//                return o1.getModelo().compareTo(o2.getModelo());
//            }
//        });
//        System.out.println(carros);

        // por modelo decrescente
//        carros.sort(new Comparator<Carro>() {
//            @Override
//            public int compare(Carro o1, Carro o2) {
//
//                return o2.getModelo().compareTo(o1.getModelo());
//            }
//        });
//        System.out.println(carros);

        // por quilometragem crescente
//        carros.sort(new Comparator<Carro>() {
//            @Override
//            public int compare(Carro o1, Carro o2) {
//                return o1.getQuilometragem() - o2.getQuilometragem();
//            }
//        });
//        System.out.println(carros);

        carros.sort(new Comparator<Carro>() {
            @Override
            public int compare(Carro o1, Carro o2) {
                int comparacaoModelo = o1.getModelo().compareTo(o2.getModelo());
                if(comparacaoModelo != 0){
                    return comparacaoModelo;
                }
                return o1.getQuilometragem().compareTo(o2.getQuilometragem());
            }
        });

        carros.sort((o1, o2) -> o1.getQuilometragem() - o2.getQuilometragem());
        System.out.println(carros);
    }
}

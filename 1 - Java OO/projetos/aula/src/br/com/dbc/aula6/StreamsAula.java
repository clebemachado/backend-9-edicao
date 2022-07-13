package br.com.dbc.aula6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsAula {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        lista.add(new Pessoa(1, "Maicon", 50000));
        lista.add(new Pessoa(2, "Pedro", 53000));
        lista.add(new Pessoa(3, "Joel", 60000));
        System.out.println(lista);

//        lista.stream()
//                .forEach(pessoa -> System.out.println(pessoa));

//        lista.stream()
//                .forEach(System.out::println);

//        List<Pessoa> listaFiltrada = lista.stream()
////                .filter(pessoa -> {
////                    return pessoa.getId() > 1;
////                })
//                .filter(pessoa -> filtrarLista(pessoa))
//                .filter(Streams::filtrarLista)
//                .collect(Collectors.toList());
//        System.out.println(lista);
//        System.out.println(listaFiltrada);
//
//        List<Double> salarios = lista.stream()
//                .map(Pessoa::getSalario)
//                .collect(Collectors.toList());
//        System.out.println(salarios);
//
//        List<Pessoa> ordenacao = lista.stream()
////                .sorted((p1, p2) -> p1.getNome().compareTo(p2.getNome()))
//                .sorted(Comparator.comparing(Pessoa::getNome))
//                .sorted(Comparator.comparing(Pessoa::getNome).reversed())
//                .collect(Collectors.toList());
//        System.out.println(ordenacao);

        List<PessoaNomeId> pessoasNomeId = lista.stream()
                .filter(pessoa -> pessoa.getSalario() > 5000)
                .sorted(Comparator.comparing(Pessoa::getSalario).reversed())
                .map(pessoa -> {
                    return new PessoaNomeId(pessoa.getId(), pessoa.getNome());
                })
//                .collect(Collectors.toList());
                .toList();
        System.out.println(pessoasNomeId);

        Double media = lista.stream()
                .mapToDouble(Pessoa::getSalario)
                .average()
                .getAsDouble();
        System.out.println(media);

        boolean todosGanham5000 = lista.stream()
                .allMatch(pessoa -> pessoa.getSalario() > 5000);
        System.out.println(todosGanham5000);

        boolean alguemGanha = lista.stream()
                .anyMatch(pessoa -> pessoa.getSalario() >= 60000);
        System.out.println(alguemGanha);

        Map<Integer,String> meuMapaDePessoasPorId = lista.stream()
                .collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome));
        System.out.println(meuMapaDePessoasPorId);

    }

    static boolean filtrarLista(Pessoa pessoa){
        return pessoa.getNome().contains("e");
    }
}

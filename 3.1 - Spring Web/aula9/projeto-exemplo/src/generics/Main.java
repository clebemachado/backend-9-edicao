package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws Exception {
        List list = new ArrayList();
        list.add("teste");
        list.add(0);

        String posicao0 = (String) list.get(0);

        List<String> minhaLista = new ArrayList<>();
        minhaLista.add("Maicon");
        String posicaoNovaLista = minhaLista.get(0);


        Optional<String> consulta = minhaLista.stream()
                .filter(str -> str.toLowerCase().contains("m"))
                .findFirst();
        System.out.println(consulta);
        System.out.println(consulta.isEmpty());
        System.out.println(consulta.isPresent());
//        System.out.println(consulta.get());

//        consulta.orElseThrow(() -> new Exception("Não existe"));
        String retorno = consulta.orElse("");
        System.out.println(retorno);

//        Optional<Integer> integer = Optional.of(0);
//        System.out.println(integer.get());

    }


    public List<PessoaDadosPessoaisDTO> listStream() {
        return pessoaService.list().stream()
                .map(pessoa -> {
                    PessoaDadosPessoaisDTO dadosPessoaisDTO = new PessoaDadosPessoaisDTO();
                    dadosPessoaisDTO.setIdPessoa(pessoa.getIdPessoa());
                    dadosPessoaisDTO.setNome(pessoa.getNome());
                    dadosPessoaisDTO.setCpf(pessoa.getCpf());
                    dadosPessoaisDTO.setDataNascimento(pessoa.getDataNascimento());
                    dadosPessoaisDTO.setEmail(pessoa.getEmail());
                    try {
                        DadosPessoaisDTO dadosPessoais = dadosPessoaisService.get(pessoa.getCpf());
                        dadosPessoaisDTO.setCnh(dadosPessoais.getCnh());
                        dadosPessoaisDTO.setNomeMae(dadosPessoais.getNomeMae());
                        dadosPessoaisDTO.setNomePai(dadosPessoais.getNomePai());
                        dadosPessoaisDTO.setRg(dadosPessoais.getRg());
                        dadosPessoaisDTO.setSexo(dadosPessoais.getSexo());
                        dadosPessoaisDTO.setTituloEleitor(dadosPessoais.getTituloEleitor());
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                    return dadosPessoaisDTO;
                })
                .toList();
    }


}

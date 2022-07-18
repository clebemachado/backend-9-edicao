package br.com.luppi.pessoaapi.service;

import br.com.luppi.pessoaapi.client.DadosPessoaisClient;
import br.com.luppi.pessoaapi.dto.DadosPessoaisDTO;
import br.com.luppi.pessoaapi.exception.EntidadeNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosPessoaisService {

    @Autowired
    private DadosPessoaisClient dadosPessoaisClient;

    public List<DadosPessoaisDTO> getAll() {
        return dadosPessoaisClient.getAll();
    }

    public DadosPessoaisDTO get(String cpf) {
        return dadosPessoaisClient.get(cpf);
    }

    public DadosPessoaisDTO post(DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisClient.post(dadosPessoaisDTO);
    }

    public DadosPessoaisDTO put(String cpf, DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisClient.put(cpf, dadosPessoaisDTO);
    }

    public void delete(String cpf) {
        dadosPessoaisClient.delete(cpf);
    }

}

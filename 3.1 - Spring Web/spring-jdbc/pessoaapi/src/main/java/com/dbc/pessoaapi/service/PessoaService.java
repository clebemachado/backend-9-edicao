package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa create(Pessoa pessoa) throws Exception {
        if (StringUtils.isBlank(pessoa.getNome())) {
            throw new RegraDeNegocioException("nome não informado");
        }
        if (ObjectUtils.isEmpty(pessoa.getDataNascimento())) {
            throw new RegraDeNegocioException("data de nascimento não informada");
        }
        if (StringUtils.isBlank(pessoa.getCpf()) || StringUtils.length(pessoa.getCpf()) != 11) {
            throw new RegraDeNegocioException("cpf não informado ou deve ser igual a 11");
        }

        return pessoaRepository.create(pessoa);
    }

    public List<Pessoa> list() {
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {
        return pessoaRepository.update(id, pessoaAtualizar);
    }

    public void delete(Integer id) throws Exception {
        pessoaRepository.delete(id);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }
}

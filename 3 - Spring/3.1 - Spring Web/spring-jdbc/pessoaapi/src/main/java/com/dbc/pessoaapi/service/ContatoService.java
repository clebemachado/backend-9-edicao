package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public void delete(Long id) throws Exception {
        contatoRepository.delete(id);
    }

    public Contato create(Integer idPessoa, Contato contato) throws Exception {
        Pessoa pessoa = pessoaRepository.list().stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .findFirst().orElseThrow(() -> new Exception("Pessoa não encontrada"));
        contato.setIdPessoa(pessoa.getIdPessoa());
        return contatoRepository.create(contato);
    }

    public Contato update(Integer id, Contato contato) throws Exception {
        return contatoRepository.update(id, contato);
    }


    public List<Contato> list() {
        return contatoRepository.list();
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.listByIdPessoa(idPessoa);
    }

    public Contato listByIdContato(Integer idContato) throws Exception {
        return contatoRepository.listByIdContato(idContato);
    }
}

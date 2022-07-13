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

//    public ContatoService() {
//        this.contatoRepository = new ContatoRepository();
//        this.pessoaRepository = new PessoaRepository();
//    }

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

    public Contato update(Integer id,Contato contato) throws Exception {

        Contato contatoAlterado = contatoRepository.list().stream()
                .filter(x -> x.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrada"));

        contatoAlterado.setTipoContato(contato.getTipoContato());
        contatoAlterado.setNumero(contato.getNumero());
        contatoAlterado.setDescricao(contato.getDescricao());

        Pessoa p = new Pessoa();
        p.setNome("JUAREZ");
        pessoaRepository.create(p);

        return contatoAlterado;
    }



    public List<Contato> list() {
        return contatoRepository.list();
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.listByIdPessoa(idPessoa);
    }
}

package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.entity.TipoContato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    public static List<Contato> contatosList = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostConstruct
    public void init(){
        List<Pessoa> pessoas = pessoaRepository.list();
        contatosList.add(new Contato(COUNTER.incrementAndGet(), pessoas.get(0).getIdPessoa(), TipoContato.COMERCIAL, "048995876566", "whatsapp"));
        contatosList.add(new Contato(COUNTER.incrementAndGet(), pessoas.get(0).getIdPessoa(), TipoContato.RESIDENCIAL, "04833545655", "casa"));
        contatosList.add(new Contato(COUNTER.incrementAndGet(), pessoas.get(1).getIdPessoa(), TipoContato.COMERCIAL, "051998654789", "trabalho"));
    }

    public void delete(Long id) throws Exception {
        Contato contato = contatosList.stream()
                .filter(x -> x.getIdContato() == id.longValue())
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrado"));
        contatosList.remove(contato);
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        contatosList.add(contato);
        return contato;
    }

    public Contato update(Integer id, Contato contato) throws Exception {
        Contato contatoAlterado = contatosList.stream()
                .filter(x -> x.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrada"));
        contatoAlterado.setTipoContato(contato.getTipoContato());
        contatoAlterado.setNumero(contato.getNumero());
        contatoAlterado.setDescricao(contato.getDescricao());
        return contatoAlterado;
    }


    public List<Contato> list() {
        return contatosList;
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return contatosList.stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public Contato listByIdContato(Integer idContato) throws Exception {
        return contatosList.stream()
                .filter(x -> x.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new Exception("contato não encontrado"));
    }
}

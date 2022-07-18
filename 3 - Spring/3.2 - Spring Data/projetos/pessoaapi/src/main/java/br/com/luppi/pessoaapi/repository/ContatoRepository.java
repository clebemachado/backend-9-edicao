package br.com.luppi.pessoaapi.repository;

import br.com.luppi.pessoaapi.entity.Contato;
import br.com.luppi.pessoaapi.exception.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ContatoRepository {

    private List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();


    public Contato create(Contato contato) throws RegraDeNegocioException {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public Contato update(Contato contatoRecuperado, Contato contatoAtualizado) {
        contatoRecuperado.setIdPessoa(contatoAtualizado.getIdPessoa());
        contatoRecuperado.setTipoContato(contatoAtualizado.getTipoContato());
        contatoRecuperado.setTelefone(contatoAtualizado.getTelefone());
        contatoRecuperado.setDescricao(contatoAtualizado.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Contato contato) {
        listaContatos.remove(contato);
    }

    public List<Contato> list() {
        return listaContatos;
    }



    

}

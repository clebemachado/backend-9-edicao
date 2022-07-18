package br.com.luppi.pessoaapi.repository;

import br.com.luppi.pessoaapi.entity.Endereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {

    private static List<Endereco> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEnderecos.add(endereco);
        return endereco;
    }

    public Endereco update(Endereco enderecoRecuperado, Endereco enderecoAtualizado) {
        enderecoRecuperado.setIdPessoa(enderecoAtualizado.getIdPessoa());
        enderecoRecuperado.setTipo(enderecoAtualizado.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizado.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizado.getNumero());
        enderecoRecuperado.setCep(enderecoAtualizado.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizado.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizado.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizado.getPais());
        return enderecoRecuperado;
    }

    public void delete(Endereco endereco) {
        listaEnderecos.remove(endereco);
    }

    public List<Endereco> list() {
        return listaEnderecos;
    }
}

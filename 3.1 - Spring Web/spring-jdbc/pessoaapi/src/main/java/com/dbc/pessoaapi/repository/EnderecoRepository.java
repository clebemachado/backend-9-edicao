package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    public static List<Endereco> enderecos = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    @PostConstruct
    public void init() {
        enderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, TipoEndereco.RESIDENCIAL, "Rua Pedro José", 4156, "casa", "89999555", "Florianópolis", "SC", "Brasil"));
        enderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, TipoEndereco.COMERCIAL, "Rua José dos Santos", 123, "sala 25", "85965656", "Porto Alegre", "RS", "Brasil"));
        enderecos.add(new Endereco(COUNTER.incrementAndGet(), 2, TipoEndereco.RESIDENCIAL, "Rua Leopoldo Faguntes", 456, "casa", "89999555", "Porto Alegre", "RS", "Brasil"));
    }

    public void delete(Long id) throws Exception {
        Endereco endereco = enderecos.stream()
                .filter(x -> x.getIdEndereco() == id.longValue())
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco não econtrado"));
        enderecos.remove(endereco);
    }

    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        enderecos.add(endereco);
        return endereco;
    }

    public Endereco update(Integer id, Endereco endereco) throws Exception {
        Endereco enderecoAlterado = enderecos.stream()
                .filter(x -> x.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrada"));
        enderecoAlterado.setTipo(endereco.getTipo());
        enderecoAlterado.setLogradouro(endereco.getLogradouro());
        enderecoAlterado.setNumero(endereco.getNumero());
        enderecoAlterado.setComplemento(endereco.getComplemento());
        enderecoAlterado.setCep(endereco.getCep());
        enderecoAlterado.setCidade(endereco.getCep());
        enderecoAlterado.setEstado(endereco.getEstado());
        enderecoAlterado.setPais(endereco.getPais());
        return enderecoAlterado;
    }


    public List<Endereco> list() {
        return enderecos;
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return enderecos.stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public Endereco findById(Integer idEndereco) throws Exception {
        return enderecos.stream()
                .filter(x -> x.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new Exception("endereco não encontrado"));
    }
}

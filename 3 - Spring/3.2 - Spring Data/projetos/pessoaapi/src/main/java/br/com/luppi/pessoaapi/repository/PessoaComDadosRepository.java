package br.com.luppi.pessoaapi.repository;

import br.com.luppi.pessoaapi.client.DadosPessoaisClient;
import br.com.luppi.pessoaapi.dto.DadosPessoaisDTO;
import br.com.luppi.pessoaapi.entity.PessoaEntity;
import br.com.luppi.pessoaapi.entity.PessoaComDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PessoaComDadosRepository {
    private static List<PessoaComDados> listaPessoasComDados = new ArrayList<>();

    @Autowired
    private PessoaRepositoryOld pessoaRepositoryOld;
    @Autowired
    private DadosPessoaisClient dadosPessoaisClient;


    public PessoaComDados create(PessoaComDados pessoaComDados) {
        DadosPessoaisDTO dados = extrairDados(pessoaComDados);
        dadosPessoaisClient.post(dados);

        PessoaEntity pessoaEntity = extrairPessoa(pessoaComDados);
        PessoaEntity pessoaEntityCriada = pessoaRepositoryOld.create(pessoaEntity);
        pessoaComDados.setIdPessoa(pessoaEntityCriada.getIdPessoa());

        listaPessoasComDados.add(pessoaComDados);
        return pessoaComDados;
    }

    public List<PessoaComDados> list() {
        return listaPessoasComDados;
    }

    public void delete(PessoaComDados pessoaComDados) {
        listaPessoasComDados.remove(pessoaComDados);
    }

    public PessoaComDados update(PessoaComDados cadastroRecuperado, PessoaComDados cadastroAtualizado) {
        PessoaEntity pessoaEntityRecuperada = extrairPessoa(cadastroRecuperado);
        PessoaEntity pessoaEntityAtualizada = extrairPessoa(cadastroAtualizado);
        pessoaRepositoryOld.update(pessoaEntityRecuperada, pessoaEntityAtualizada);

        DadosPessoaisDTO dadosAtualizados = extrairDados(cadastroAtualizado);
        dadosPessoaisClient.put(cadastroRecuperado.getCpf(), dadosAtualizados);

        cadastroRecuperado.setNome(cadastroAtualizado.getNome());
        cadastroRecuperado.setDataNascimento(cadastroAtualizado.getDataNascimento());
        cadastroRecuperado.setEmail(cadastroAtualizado.getEmail());
        cadastroRecuperado.setCnh(cadastroAtualizado.getCnh());
        cadastroRecuperado.setCpf(cadastroAtualizado.getCpf());
        cadastroRecuperado.setNomeMae(cadastroAtualizado.getNomeMae());
        cadastroRecuperado.setNomePai(cadastroAtualizado.getNomePai());
        cadastroRecuperado.setRg(cadastroAtualizado.getRg());
        cadastroRecuperado.setSexo(cadastroAtualizado.getSexo());
        cadastroRecuperado.setTituloEleitor(cadastroRecuperado.getTituloEleitor());
        return cadastroRecuperado;
    }

    public PessoaEntity extrairPessoa(PessoaComDados pessoaComDados) {
        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setNome(pessoaComDados.getNome());
        pessoaEntity.setCpf(pessoaComDados.getCpf());
        pessoaEntity.setDataNascimento(pessoaComDados.getDataNascimento());
        pessoaEntity.setEmail(pessoaComDados.getEmail());
        return pessoaEntity;
    }

    public DadosPessoaisDTO extrairDados(PessoaComDados pessoaComDados) {
        DadosPessoaisDTO dados = new DadosPessoaisDTO();
        dados.setCnh(pessoaComDados.getCnh());
        dados.setCpf(pessoaComDados.getCpf());
        dados.setNome(pessoaComDados.getNome());
        dados.setNomeMae(pessoaComDados.getNomeMae());
        dados.setNomePai(pessoaComDados.getNomePai());
        dados.setRg(pessoaComDados.getRg());
        dados.setSexo(pessoaComDados.getSexo());
        dados.setTituloEleitor(pessoaComDados.getTituloEleitor());
        return dados;
    }
}

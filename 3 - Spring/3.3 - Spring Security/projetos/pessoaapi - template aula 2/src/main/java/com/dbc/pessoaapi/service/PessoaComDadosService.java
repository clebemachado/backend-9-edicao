package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.PessoaComDadosDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.PessoaComDados;
import com.dbc.pessoaapi.exception.EntidadeNaoEncontradaException;
import com.dbc.pessoaapi.repository.PessoaComDadosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaComDadosService {

    @Autowired
    private PessoaComDadosRepository pessoaComDadosRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private DadosPessoaisClient dadosPessoaisClient;
    @Autowired
    private ObjectMapper objectMapper;


    public PessoaComDadosDTO create(PessoaComDadosDTO pessoaComDadosDTO) {
        PessoaComDados pessoaComDados = returnEntity(pessoaComDadosDTO);
        return returnDTO(pessoaComDadosRepository.create(pessoaComDados));
    }

    public List<PessoaComDadosDTO> list() {
        return pessoaComDadosRepository.list().stream()
                .map(this::returnDTO)
                .collect(Collectors.toList());
    }

    public void delete(String cpf) throws EntidadeNaoEncontradaException {
        PessoaEntity pessoaEntityRecuperada = pessoaService.returnByCpf(cpf);
        pessoaService.delete(pessoaEntityRecuperada.getIdPessoa());
        dadosPessoaisClient.delete(cpf);
        PessoaComDados pessoaComDadosRecuperada = returnByCpf(cpf);
        pessoaComDadosRepository.delete(pessoaComDadosRecuperada);
    }

    public PessoaComDadosDTO update(String cpf, PessoaComDadosDTO pessoaComDadosDTO) throws EntidadeNaoEncontradaException {
        PessoaComDados pessoaComDadosAtualizada = returnEntity(pessoaComDadosDTO);
        PessoaComDados pessoaComDadosRecuperada = returnByCpf(cpf);
        return returnDTO(pessoaComDadosRepository.update(pessoaComDadosRecuperada, pessoaComDadosAtualizada));
    }

    public PessoaComDados returnByCpf(String cpf) throws EntidadeNaoEncontradaException {
        return pessoaComDadosRepository.list().stream()
                .filter(pessoaComDados -> pessoaComDados.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new EntidadeNaoEncontradaException("CPF nao encontrado"));
    }

    public PessoaComDados returnEntity(PessoaComDadosDTO dto) {
        return objectMapper.convertValue(dto, PessoaComDados.class);
    }

    private PessoaComDadosDTO returnDTO(PessoaComDados entity) {
        return objectMapper.convertValue(entity, PessoaComDadosDTO.class);
    }
}

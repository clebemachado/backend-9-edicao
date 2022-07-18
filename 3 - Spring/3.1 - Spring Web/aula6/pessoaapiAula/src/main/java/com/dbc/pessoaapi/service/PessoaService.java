package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.exception.BancoDeDadosException;
import com.dbc.pessoaapi.exception.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

//    public PessoaService() {
////        pessoaRepository = new PessoaRepository();
//    }

    public PessoaDTO create(PessoaCreateDTO pessoa) {
        log.info("Criando a pessoa...");

        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);

        Pessoa pessoaCriada = pessoaRepository.create(pessoaEntity);

        // Retorno

        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

        log.warn("Pessoa " + pessoaDTO.getNome() + " criada!");
        return pessoaDTO;
    }

    public List<Pessoa> list() {
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {

        //throw new BancoDeDadosException("TESTE!");
        return pessoaRepository.update(id, pessoaAtualizar);
    }

    public void delete(Integer id) throws Exception {
        pessoaRepository.delete(id);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }
}

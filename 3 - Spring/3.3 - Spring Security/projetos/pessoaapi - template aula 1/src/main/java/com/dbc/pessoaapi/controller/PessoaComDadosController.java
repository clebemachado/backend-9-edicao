package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.documentation.PessoaComDadosDocumentation;
import com.dbc.pessoaapi.dto.PessoaComDadosDTO;
import com.dbc.pessoaapi.exception.EntidadeNaoEncontradaException;
import com.dbc.pessoaapi.service.PessoaComDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa-com-dados")
@Validated
public class PessoaComDadosController implements PessoaComDadosDocumentation {

    @Autowired
    private PessoaComDadosService pessoaComDadosService;

    @PostMapping
    public ResponseEntity<PessoaComDadosDTO>  post(@Valid @RequestBody PessoaComDadosDTO pessoaComDadosDTO) {
        return ResponseEntity.ok(pessoaComDadosService.create(pessoaComDadosDTO));
    }

    @GetMapping
    public ResponseEntity<List<PessoaComDadosDTO>>  get() {
        return ResponseEntity.ok(pessoaComDadosService.list());
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf) throws EntidadeNaoEncontradaException {
        pessoaComDadosService.delete(cpf);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<PessoaComDadosDTO>  put(@PathVariable("cpf") String cpf, @RequestBody PessoaComDadosDTO pessoaComDadosDTO) throws EntidadeNaoEncontradaException {
        return ResponseEntity.ok(pessoaComDadosService.update(cpf, pessoaComDadosDTO));
    }

}

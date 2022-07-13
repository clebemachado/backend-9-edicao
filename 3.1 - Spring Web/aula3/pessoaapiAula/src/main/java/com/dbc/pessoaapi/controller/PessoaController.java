package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.service.PessoaService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;

    // Modelo mais novo
//    private final PessoaService pessoaService;

    @Value("${user}")
    private String usuario;

    // Modelo mais novo
//    public PessoaController(PessoaService pessoaService) {
//        this.pessoaService = pessoaService;
//    }

    @GetMapping("/hello")
    public String hello() {
        return usuario;
    }

    @PostMapping
    public Pessoa create(@RequestBody Pessoa pessoa) {
        return pessoaService.create(pessoa);
    }

    @GetMapping
    public List<Pessoa> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname")
    public List<Pessoa> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }


    @PutMapping("/{idPessoa}")
    public Pessoa update(@PathVariable("idPessoa") Integer id,
                         @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}

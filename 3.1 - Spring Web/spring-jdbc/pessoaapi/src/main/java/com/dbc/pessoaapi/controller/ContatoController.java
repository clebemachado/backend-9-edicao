package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        contatoService.delete(id);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Contato> create(@PathVariable("idPessoa") Integer idPessoa,
                                         @RequestBody @Valid Contato contato) throws Exception {
        return ResponseEntity.ok(contatoService.create(idPessoa, contato));
    }

    @PutMapping("/{id}")
    public Contato update(@PathVariable("id") Integer id,
                          @RequestBody Contato contato) throws Exception {
        return contatoService.update(id, contato);
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    // {{url}}/contato/1/pessoa
    @GetMapping("/{idPessoa}/pessoa")
    public List<Contato> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }

    // {{url}}/contato/1/contato
    @GetMapping("/{idContato}/contato")
    public Contato listByIdContato(@PathVariable("idContato") Integer idContato) throws Exception {
        return contatoService.listByIdContato(idContato);
    }

    // {{url}}/contato/list-by-pessoas?idPessoa=1&nome=Maicon Machado
    @GetMapping("/list-by-pessoas")
    public List<Contato> listByIdPessoaRequestParam(@RequestParam("idPessoa") Integer id,
                                                    @RequestParam("nome") String nome) {
        System.out.println(nome);
        return contatoService.listByIdPessoa(id);
    }
}
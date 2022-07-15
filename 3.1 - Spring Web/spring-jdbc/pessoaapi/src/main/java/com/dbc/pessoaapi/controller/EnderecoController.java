package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        enderecoService.delete(id);
    }

    @PostMapping("/{idPessoa}")
    public Endereco create(@PathVariable("idPessoa") Integer idPessoa,
                           @RequestBody Endereco endereco) throws Exception {
        return enderecoService.create(idPessoa, endereco);
    }

    @PutMapping("/{id}")
    public Endereco update(@PathVariable("id") Integer id,
                           @RequestBody Endereco endereco) throws Exception {
        return enderecoService.update(id, endereco);
    }

    @GetMapping
    public List<Endereco> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @GetMapping("/{idEndereco}")
    public Endereco findById(@PathVariable("idEndereco") Integer id) throws Exception {
        return enderecoService.findById(id);
    }
}

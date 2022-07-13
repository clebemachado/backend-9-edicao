package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaCreateMailDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.service.EmailService;
import com.dbc.pessoaapi.service.PessoaService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;


@RestController
@RequestMapping("/pessoa")
@Validated
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EmailService emailService;

    // Modelo mais novo
//    private final PessoaService pessoaService;

    @Value("${user}")
    private String usuario;

    @Value("${spring.application.name}")
    private String app;

    // Modelo mais novo
//    public PessoaController(PessoaService pessoaService) {
//        this.pessoaService = pessoaService;
//    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello " + app + "!";
    }

    @SneakyThrows
    @GetMapping("/email")
    public String email() {
        //emailService.sendWithAttachment();
        emailService.sendEmail();
        return "Enviando E-mail.. " + app + "!";
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaCreateDTO pessoa) {

        return ResponseEntity.ok(pessoaService.create(pessoa));
        //return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.OK);
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
    public Pessoa update(@PathVariable("idPessoa") @Min(2) Integer id,
                         @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }


    @PutMapping("/{idPessoa}/atualizar-email")
    public PessoaDTO updateMail(@PathVariable("idPessoa") @Min(2) Integer id,
                         @RequestBody PessoaCreateMailDTO pessoaAtualizar) throws Exception {
        //return pessoaService.update(id, pessoaAtualizar);
        return null;
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}

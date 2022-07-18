package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Validated
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private Connection connection;

    @Value("${spring.application.name}")
    private String name;

    @GetMapping("/hello")
    public String hello() {
        return name;
    }

    @GetMapping("/next")
    public Integer nextSeq() {
        try {
            String sql = "SELECT SEQ_ALUGUEL.nextval seq FROM DUAL";
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            if (result.next()) {
                return result.getInt("seq");
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @PostMapping
    public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa pessoa) throws Exception {
        Pessoa pessoaCriada = pessoaService.create(pessoa);
        return ResponseEntity.ok(pessoaCriada);
    }

    @Operation(summary = "listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public ResponseEntity<List<Pessoa>> list() {
        List<Pessoa> lista = pessoaService.list();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/byname")
    public ResponseEntity<List<Pessoa>> listByName(@RequestParam("nome") @NotBlank String nome) {
        List<Pessoa> lista = pessoaService.listByName(nome);
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<Pessoa> update(@PathVariable("idPessoa") Integer id,
                                         @RequestBody Pessoa pessoaAtualizar) throws Exception {
        Pessoa pessoaAlterada = pessoaService.update(id, pessoaAtualizar);
        return ResponseEntity.ok(pessoaAlterada);
    }

    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }
}

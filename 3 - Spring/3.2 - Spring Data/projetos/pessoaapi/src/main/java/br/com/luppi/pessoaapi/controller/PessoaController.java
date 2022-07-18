package br.com.luppi.pessoaapi.controller;
import br.com.luppi.pessoaapi.config.PropertiesReader;
import br.com.luppi.pessoaapi.dto.PessoaCreateDTO;
import br.com.luppi.pessoaapi.dto.PessoaDTO;
import br.com.luppi.pessoaapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import br.com.luppi.pessoaapi.service.EmailService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Validated
@Slf4j
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PropertiesReader propertiesReader;

    @Operation(summary = "Adicionar pessoa", description = "Adiciona uma pessoa na aplicação")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Adiciona a pessoa"),
                        @ApiResponse(responseCode = "500", description = "Exception gerada")
                }
        )
    @PostMapping
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }

    @Operation(summary = "Listar pessoas", description = "lista todas as pessoas cadastradas")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna todas as pessoas cadastradas"),
                        @ApiResponse(responseCode = "500", description = "Exception gerada")
                }
        )
    @GetMapping // localhost:8080/pessoa
    public ResponseEntity<List<PessoaDTO>> list() {
        return ResponseEntity.ok(pessoaService.list());
    }

    @Operation(summary = "Buscar por nome", description = "lista as pessoas através do nome desejado")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna as pessoas pelo nome"),
                        @ApiResponse(responseCode = "500", description = "Exception gerada")
                }
        )
    @GetMapping("/byname")
    public ResponseEntity<List<PessoaDTO>> listByName(@RequestParam("nome") String nome){
        return ResponseEntity.ok(pessoaService.listByName(nome));
    }

    @Operation(summary = "Atualizar pessoa", description = "Atualiza os dados cadastrados de uma pessoa")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Dados atualizados"),
                        @ApiResponse(responseCode = "500", description = "Exception gerada")
                }
        )
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                         @RequestBody @Valid PessoaCreateDTO pessoaAtualizada) throws Exception {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizada));
    }

    @Operation(summary = "Remover pessoa", description = "remove uma pessoa através do id")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Cadastro removido"),
                        @ApiResponse(responseCode = "500", description = "Exception gerada")
                }
        )
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }

    @Hidden
    @GetMapping("/ambiente")
    public String retornarPropertie() {
        return propertiesReader.getAmbiente();
    }

}

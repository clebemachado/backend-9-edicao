package br.com.luppi.pessoaapi.controller;

import br.com.luppi.pessoaapi.dto.ContatoCreateDTO;
import br.com.luppi.pessoaapi.dto.ContatoDTO;
import br.com.luppi.pessoaapi.exception.EntidadeNaoEncontradaException;
import br.com.luppi.pessoaapi.exception.RegraDeNegocioException;
import br.com.luppi.pessoaapi.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Validated
@RestController
@RequestMapping("/contato")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @Operation(summary = "Cadastrar novo contato")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna o contato criado"),
                        @ApiResponse(responseCode = "404", description = "{idPessoa} não encontrado"),
                        @ApiResponse(responseCode = "500", description = "Exception gerada")
                }
        )
    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer id,
                                             @RequestBody @Valid ContatoCreateDTO contato) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        return ResponseEntity.ok(contatoService.create(id, contato));
    }

    @Operation(summary = "Listar contatos")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos cadastrados"),
                        @ApiResponse(responseCode = "500", description = "Exception gerada")
                }
        )
    @GetMapping
    public ResponseEntity<List<ContatoDTO>>  list() {
        return ResponseEntity.ok(contatoService.list());
    }

    @Operation(summary = "Atualizar contato")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Atualiza os valores de um contato já existente"),
                        @ApiResponse(responseCode = "404", description = "{idContato} não encontrado"),
                        @ApiResponse(responseCode = "500", description = "Exception gerada")
                }
        )
    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id,
                          @RequestBody @Valid ContatoCreateDTO contatoAtualizado) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        return ResponseEntity.ok(contatoService.update(id, contatoAtualizado));
    }

    @Operation(summary = "Apagar contato")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Remove o contato da lista"),
                    @ApiResponse(responseCode = "404", description = "{idContato} não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Exception gerada")
            }
    )
    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        contatoService.delete(id);
    }

    @Operation(summary = "Listar contatos por pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos da pessoa desejada"),
                    @ApiResponse(responseCode = "404", description = "{idPessoa} não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Exception gerada")
            }
    )
    @GetMapping("/{idPessoa}")
    public ResponseEntity<List<ContatoDTO>> listByPersonId(@PathVariable("idPessoa") Integer id) throws EntidadeNaoEncontradaException {
        return ResponseEntity.ok(contatoService.listByPersonId(id));
    }
}

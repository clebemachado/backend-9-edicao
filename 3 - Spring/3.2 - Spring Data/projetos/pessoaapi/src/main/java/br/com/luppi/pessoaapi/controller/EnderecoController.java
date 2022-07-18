package br.com.luppi.pessoaapi.controller;

import br.com.luppi.pessoaapi.dto.EnderecoCreateDTO;
import br.com.luppi.pessoaapi.dto.EnderecoDTO;
import br.com.luppi.pessoaapi.exception.EntidadeNaoEncontradaException;
import br.com.luppi.pessoaapi.exception.RegraDeNegocioException;
import br.com.luppi.pessoaapi.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;


    @Operation(summary = "Cadastrar novo endereço")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna o endereço criado"),
                        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
                        @ApiResponse(responseCode = "404", description = "{idPessoa} não encontrada"),
                        @ApiResponse(responseCode = "500", description = "Exception gerada")
                }
        )
    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer id,
                                              @RequestBody @Valid EnderecoCreateDTO endereco) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        return ResponseEntity.ok(enderecoService.create(id, endereco));
    }

    @Operation(summary = "Listar endereços cadastrados")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna toda a lista de endereços"),
                        @ApiResponse(responseCode = "500", description = "Exception gerada")
                }
        )
    @GetMapping
    public ResponseEntity<List<EnderecoDTO>>  list() {
        return ResponseEntity.ok(enderecoService.list());
    }

    @Operation(summary = "Listar endereço por ID do endereço")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna o contato através do ID"),
                        @ApiResponse(responseCode = "404", description = "{idEndereco} não encontrado"),
                        @ApiResponse(responseCode = "500", description = "Exception gerada")
                }
        )
    @GetMapping("/{idEndereco}")
    public ResponseEntity<List<EnderecoDTO>> listByAddressId(@PathVariable("idEndereco") Integer id) throws EntidadeNaoEncontradaException {
        return ResponseEntity.ok(enderecoService.listByAddressId(id));
    }

    @Operation(summary = "Listar endereços por ID da pessoa")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços por idPessoa"),
                        @ApiResponse(responseCode = "404", description = "{idPessoa} não encontrado"),
                        @ApiResponse(responseCode = "500", description = "Exception gerada")
                }
        )
    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<EnderecoDTO>>  listByPersonId(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        return ResponseEntity.ok(enderecoService.listByPersonId(id));
    }

    @Operation(summary = "Atualizar endereço através do {idEndereco}")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso"),
                        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
                        @ApiResponse(responseCode = "404", description = "{idEndereco} não encontrado"),
                        @ApiResponse(responseCode = "500", description = "Exception gerada")
                }
        )
    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> uptade(@PathVariable("idEndereco") Integer id,
                                 @RequestBody @Valid EnderecoCreateDTO enderecoAtualizado) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        return ResponseEntity.ok(enderecoService.update(id, enderecoAtualizado));
    }

    @Operation(summary = "Deletar endereço através do {idEndereco}")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Endereço deletado com sucesso"),
                        @ApiResponse(responseCode = "404", description = "{idEndereco} não encontrado"),
                        @ApiResponse(responseCode = "500", description = "Exception gerada")
                }
        )
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        enderecoService.delete(id);
    }

}

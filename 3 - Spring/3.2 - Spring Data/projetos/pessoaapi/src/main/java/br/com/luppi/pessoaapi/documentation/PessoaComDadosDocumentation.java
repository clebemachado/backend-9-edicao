package br.com.luppi.pessoaapi.documentation;

import br.com.luppi.pessoaapi.dto.PessoaComDadosDTO;
import br.com.luppi.pessoaapi.exception.EntidadeNaoEncontradaException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PessoaComDadosDocumentation {

    @Operation(summary = "Criar pessoa com dados, alterando pessoa e dadosPessoais junto")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Criado com sucesso"),
                        @ApiResponse(responseCode = "400", description = "Erro do client"),
                        @ApiResponse(responseCode = "500", description = "Exception gerada")
                }
        )
    ResponseEntity<PessoaComDadosDTO> post(PessoaComDadosDTO pessoaComDadosDTO);

    @Operation(summary = "Retornar lista de pessoa com dados")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna a lista"),
                        @ApiResponse(responseCode = "500", description = "Exception gerada")
                }
        )
    ResponseEntity<List<PessoaComDadosDTO>> get();

    @Operation(summary = "Deletar pessoa com dados, dados pessoais e pessoa juntos")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Deletado com sucesso"),
                        @ApiResponse(responseCode = "404", description = "CPF não encontrado"),
                        @ApiResponse(responseCode = "500", description = "Exception gerada")
                }
        )
    void delete(String cpf) throws EntidadeNaoEncontradaException;

    @Operation(summary = "Alterar pessoa com dados, dados pessoais e pessoa juntos")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Alterado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Erro do client"),
                    @ApiResponse(responseCode = "404", description = "CPF não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Exception gerada")
            }
    )
    ResponseEntity<PessoaComDadosDTO> put(String cpf, PessoaComDadosDTO pessoaComDadosDTO) throws EntidadeNaoEncontradaException;
}

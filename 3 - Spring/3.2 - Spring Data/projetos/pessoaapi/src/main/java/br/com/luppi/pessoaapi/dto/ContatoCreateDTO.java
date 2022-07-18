package br.com.luppi.pessoaapi.dto;

import br.com.luppi.pessoaapi.enums.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {
    @Schema(description = "Indentificador do dono de contato", example = "1")
    private Integer idPessoa;

    @Schema(description = "Contato comercial ou residencial", example = "RESIDENCIAL")
    @NotNull(message = "Tipo do contato nao pode ser nulo")
    private TipoContato tipoContato;
    @Size(min=3, max=13)

    @Schema(description = "Permitido caracteres especiais: (DDD) 00000-0000", example = "(54) 91234-1232")
    @NotBlank(message = "Numero nao pode ser nulo ou em branco")
    private String telefone;

    @Schema(description = "Maiores detalhes sobre o contato", example = "Número da casa de praia")
    @NotBlank(message = "Descricao nao pode ser nulo ou em branco")
    private String descricao;
}

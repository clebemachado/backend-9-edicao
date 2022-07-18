package br.com.luppi.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EnderecoDTO extends EnderecoCreateDTO {
    @Schema(description = "Identificador único do endereco")
    private Integer idEndereco;
}

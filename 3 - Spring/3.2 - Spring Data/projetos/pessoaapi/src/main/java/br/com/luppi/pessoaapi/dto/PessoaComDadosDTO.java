package br.com.luppi.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
public class PessoaComDadosDTO extends DadosPessoaisDTO {
    @Schema(description = "Identificador único da pessoa")
    private Integer idPessoa;

    @Schema(description = "Nome da pessoa")
    @NotBlank
    private String nome;

    @Schema(description = "AAAA-MM-DD")
    @Past
    @NotNull
    private LocalDate dataNascimento;

    @Schema(description = "seuEmail@dominio")
    @Email
    private String email;
}

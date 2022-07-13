package com.dbc.pessoaapi.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pessoa {

    private Integer idPessoa;

    @NotEmpty
    //@Getter(AccessLevel.NONE)
    private String nome;

    @NotNull(message = "informe a data de nasc")
    private LocalDate dataNascimento;

    //javax.validation.constraints.
    @CPF
    private String cpf;

}
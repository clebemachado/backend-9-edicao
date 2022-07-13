package com.dbc.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class PessoaCreateMailDTO {
    @NotEmpty
    @NotBlank
    private String email;
}
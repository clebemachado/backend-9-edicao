package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.enums.TipoSexo;
import lombok.Data;

@Data
public class DadosPessoaisDTO {
    private String cnh;
    private String cpf;
    private String nome;
    private String nomeMae;
    private String nomePai;
    private String rg;
    private TipoSexo sexo;
    private String tituloEleitor;
}

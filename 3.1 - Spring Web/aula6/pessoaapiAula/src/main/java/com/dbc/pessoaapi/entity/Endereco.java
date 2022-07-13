package com.dbc.pessoaapi.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private Integer idEndereco;
    private Integer idPessoa;
    private TipoEndereco tipo;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

}

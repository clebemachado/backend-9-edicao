package br.com.luppi.pessoaapi.entity;

import br.com.luppi.pessoaapi.enums.TipoEndereco;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Endereco {

    private Integer idEndereco;
    private Integer idPessoa;
    private TipoEndereco tipo;
    private String logradouro;
    private Integer numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

}

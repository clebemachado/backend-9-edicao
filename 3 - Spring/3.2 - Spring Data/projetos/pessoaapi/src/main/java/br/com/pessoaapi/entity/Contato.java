package br.com.pessoaapi.entity;

import br.com.pessoaapi.enums.TipoContato;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contato {

    private Integer idContato;
    private Integer idPessoa;
    private TipoContato tipoContato;
    private String telefone;
    private String descricao;

}

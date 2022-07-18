package br.com.luppi.pessoaapi.entity;

import br.com.luppi.pessoaapi.enums.TipoContato;
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

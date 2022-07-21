package br.com.pessoaapi.entity;

import br.com.pessoaapi.enums.TipoSexo;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PessoaComDados {
    private Integer idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String cnh;
    private String cpf;
    private String nomeMae;
    private String nomePai;
    private String rg;
    private TipoSexo sexo;
    private String tituloEleitor;
}

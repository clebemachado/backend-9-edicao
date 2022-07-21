package br.com.pessoaapi.dto;

import br.com.pessoaapi.enums.TipoSexo;
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

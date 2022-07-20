package br.com.luppi.pessoaapi.entity;

import br.com.luppi.pessoaapi.enums.TipoContato;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity(name = "CONTATO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContatoEntity {

    @Id
    @SequenceGenerator(name = "SEQ_CONTATO", sequenceName = "seq_contato", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTATO")
    private Integer idContato;

    @Column(name = "ID_PESSOA", insertable = false, updatable = false)
    private Integer idPessoa;

    @Column(name = "TIPO")
    private TipoContato tipoContato;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "DESCRICAO")
    private String descricao;

    @JsonIgnore
//    @ManyToOne(fetch = FetchType.EAGER) // traz sempre
    @ManyToOne(fetch = FetchType.LAZY) // traz quando solicitado
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private PessoaEntity pessoa; // contato.getPessoa()
}
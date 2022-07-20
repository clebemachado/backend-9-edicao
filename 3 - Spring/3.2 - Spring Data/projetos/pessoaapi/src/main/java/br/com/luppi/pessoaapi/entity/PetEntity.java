package br.com.luppi.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PET")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PET_SEQ")
    @SequenceGenerator(name = "PET_SEQ", sequenceName = "se_pet", allocationSize = 1)
    @Column(name = "id_pet")
    private Integer idPet;

    @Column(name = "id_pessoa", insertable = false, updatable = false)
    private Integer idPessoa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoPet tipo;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_pessoa", referencedColumnName = "id_pessoa")
    private PessoaEntity pessoa;
}

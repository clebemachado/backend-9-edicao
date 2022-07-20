package br.com.luppi.pessoaapi.entity;

import br.com.luppi.pessoaapi.entity.pk.ProfessorPK;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
//jeito 1
@Entity(name = "PROFESSOR")

//jeito 2
//@Table(name = "PROFESSOR")
//@Entity
public class ProfessorEntity {

    @EmbeddedId
    private ProfessorPK professorPK;

    @Column(name = "nome")
    private String nome;

    @Column(name = "salario")
    private Double salario;
}

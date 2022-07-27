package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    public List<PessoaEntity> findAllByBatataContains(String batata);

    List<PessoaEntity> findAllByDataNascimentoBetween(LocalDate dtInicial, LocalDate dtFinal);
//    PessoaEntity findByBy
}

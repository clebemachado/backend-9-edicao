package br.com.luppi.pessoaapi.repository;

import br.com.luppi.pessoaapi.dto.PessoaCompostaDTO;
import br.com.luppi.pessoaapi.entity.PessoaEntity;
import br.com.luppi.pessoaapi.enums.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    // query methods
    public List<PessoaEntity> findAllByBatataContains(String batata);

    List<PessoaEntity> findAllByDataNascimentoBetween(LocalDate dtInicial, LocalDate dtFinal);
//    PessoaEntity findByBy


    // jpql = (java) persistence query language

    @Query(" select p " +
            "  from PESSOA p" +
            " where p.cpf = ?1")
    List<PessoaEntity> listPessoasByCpf(String cpf);

    @Query(value = " select p.* " +
            "         from PESSOA p" +
            "        where p.cpf = :cpf", nativeQuery = true)
    List<PessoaEntity> listPessoasByCpfNative(@Param("cpf") String cpf);

    @Query(" select p " +
            "  from PESSOA p" +
            " where p.cpf = :cpf")
    List<PessoaEntity> listPessoasByCpfParam(@Param("cpf") String cpf);



    @Query(" select p " +
            "  from PESSOA p " +
            "  join p.contatos cont " +  // ==== "  join CONTATO cont on (p.id_pessoa = c.id_pessoa)" +
            " where cont.tipoContato = :tipoContato ")
    List<PessoaEntity> listPessoasPorTipoContato(@Param("tipoContato") TipoContato tipoContato);

    @Query(value = " select * " +
            "  from PESSOA p " +
            "  join CONTATO cont on (p.id_pessoa = cont.id_pessoa)" +
            " where cont.tipo = :tipoContato", nativeQuery = true)
    List<PessoaEntity> listPessoasPorTipoContatoNative(@Param("tipoContato") Integer tipoContato);

    @Query(value = " select new br.com.luppi.pessoaapi.dto.PessoaCompostaDTO(" +
            " p.batata," +
            " p.email," +
            " pety.nome," +
            " pety.tipo" +
            ")" +
            "  from PESSOA p " +
            "  join p.pet pety " +
            " where (:idPessoa is null OR p.idPessoa = :idPessoa )")
    List<PessoaCompostaDTO> listaCompostaDTO(@Param("idPessoa") Integer idPessoa);
}

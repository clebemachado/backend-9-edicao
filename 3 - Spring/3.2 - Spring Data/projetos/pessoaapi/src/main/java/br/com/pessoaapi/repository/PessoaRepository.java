package br.com.pessoaapi.repository;

import br.com.pessoaapi.dto.PessoaCompostaDTO;
import br.com.pessoaapi.dto.PessoaCompostaTudoDTO;
import br.com.pessoaapi.entity.PessoaEntity;
import br.com.pessoaapi.enums.TipoContato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query(value = " select new br.com.pessoaapi.dto.PessoaCompostaDTO(" +
            " p.batata," +
            " p.email," +
            " pety.nome," +
            " pety.tipo" +
            ")" +
            "  from PESSOA p " +
            "  join p.pet pety " +
            " where (:idPessoa is null OR p.idPessoa = :idPessoa )")
    List<PessoaCompostaDTO> listaCompostaDTO(@Param("idPessoa") Integer idPessoa);



    // JPQL PAGINADO
    @Query(value = """
           select new br.com.pessoaapi.dto.PessoaCompostaTudoDTO(
           p.id,
           p.batata,
           p.cpf,
           p.email,
           c.numero,
           e.cep,
           e.cidade,
           e.estado,
           e.pais,
           pet.nome)
           from PESSOA p
           left join p.contatos c
           left join p.enderecos e
           left join p.pet pet
           """) // se for uma JPQL
    Page<PessoaCompostaTudoDTO> findPessoaCompostaTudoPaginado(Pageable pageable);

    //QUERY NATIVA
    @Query(value = " select p.* " +
            "         from PESSOA p" +
            "        where (:cpf is null or p.cpf = :cpf)",
            countQuery = "select count(*) " +
            "         from PESSOA p" +
            "        where (:cpf is null or p.cpf = :cpf)",
            nativeQuery = true)
    Page<PessoaEntity> listPessoasByCpfNativePaginado(@Param("cpf") String cpf, Pageable pageable);

}

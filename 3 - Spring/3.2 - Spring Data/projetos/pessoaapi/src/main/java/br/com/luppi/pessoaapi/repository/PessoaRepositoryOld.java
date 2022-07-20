package br.com.luppi.pessoaapi.repository;

import br.com.luppi.pessoaapi.entity.PessoaEntity;
import org.springframework.stereotype.Repository;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PessoaRepositoryOld {
    private static List<PessoaEntity> listaPessoaEntities = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public PessoaRepositoryOld() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //18/10/2020
//        listaPessoaEntities.add(new PessoaEntity(COUNTER.incrementAndGet() /*1*/, "Maicon Gerardi", LocalDate.parse("10/10/1990", formatter), "12345678910", "luppi.gabriel08@gmail.com"));
//        listaPessoaEntities.add(new PessoaEntity(COUNTER.incrementAndGet() /*2*/, "Charles Pereira", LocalDate.parse("08/05/1985", formatter), "12345678911", "luppi.gabriel08@gmail.com"));
//        listaPessoaEntities.add(new PessoaEntity(COUNTER.incrementAndGet() /*3*/, "Marina Oliveira", LocalDate.parse("30/03/1970", formatter), "12345678912", "luppi.gabriel08@gmail.com"));
//        listaPessoaEntities.add(new PessoaEntity(COUNTER.incrementAndGet() /*4*/, "Rafael Lazzari", LocalDate.parse("01/07/1990", formatter), "12345678916", "gabrielanjos1105@gmail.com"));
//        listaPessoaEntities.add(new PessoaEntity(COUNTER.incrementAndGet() /*5*/, "Ana", LocalDate.parse("01/07/1990", formatter), "12345678917", "gabrielanjos1105@gmail.com"));
    }

    public PessoaEntity create(PessoaEntity pessoaEntity) {
        pessoaEntity.setIdPessoa(COUNTER.incrementAndGet());
        listaPessoaEntities.add(pessoaEntity);
        return pessoaEntity;
    }

    public PessoaEntity update(PessoaEntity pessoaEntityRecuperada, PessoaEntity pessoaEntityAtualizada) {
        pessoaEntityRecuperada.setCpf(pessoaEntityAtualizada.getCpf());
        pessoaEntityRecuperada.setBatata(pessoaEntityAtualizada.getBatata());
        pessoaEntityRecuperada.setDataNascimento(pessoaEntityAtualizada.getDataNascimento());
        pessoaEntityRecuperada.setEmail(pessoaEntityAtualizada.getEmail());
        return pessoaEntityRecuperada;
    }

    public void delete(PessoaEntity pessoaEntity) {
        listaPessoaEntities.remove(pessoaEntity);
    }

    public List<PessoaEntity> list() {
        return listaPessoaEntities;
    }


}

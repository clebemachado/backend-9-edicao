package br.com.pessoaapi.service;

import br.com.pessoaapi.dto.PessoaCreateDTO;
import br.com.pessoaapi.dto.PessoaDTO;
import br.com.pessoaapi.entity.PessoaEntity;
import br.com.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceTest {

    @InjectMocks // injetar a classe na qual é o foco do caso de uso...
    private PessoaService pessoaService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private PessoaRepository pessoaRepository;


    @Before
    public void init(){
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ReflectionTestUtils.setField(pessoaService, "objectMapper", objectMapper);
    }

    @Test
    public void deveTestarCreateComSucesso() {
        // setup  preparamos o que vamos usar no teste
        PessoaCreateDTO pessoaCreateDTO = new PessoaCreateDTO();
        pessoaCreateDTO.setDataNascimento(LocalDate.of(1991,9,8));
        pessoaCreateDTO.setCpf("12345679810");
        pessoaCreateDTO.setEmail("maicon@teste.com.br");
        pessoaCreateDTO.setNome("Maicon");

        PessoaEntity pessoaEntity = getPessoaEntity();

        when(pessoaRepository.save(any(PessoaEntity.class))).thenReturn(pessoaEntity);

        // act    ação do teste
        PessoaDTO pessoaDTO = pessoaService.create(pessoaCreateDTO);

        // assert garatir o retorno do teste
        assertNotNull(pessoaDTO);
        assertEquals(LocalDate.of(1991,9,8), pessoaDTO.getDataNascimento());
        assertEquals("12345679810", pessoaDTO.getCpf());
        assertEquals("maicon@teste.com.br", pessoaDTO.getEmail());
        assertEquals(null, pessoaDTO.getNome());
        assertNotNull(pessoaDTO.getIdPessoa());
    }

    @Test
    public void deveTestarListComSucesso(){
        // setup
        List<PessoaEntity> pessoaEntities = List.of(getPessoaEntity());

        when(pessoaRepository.findAll()).thenReturn(pessoaEntities);

        // act
        List<PessoaDTO> pessoaDTOS = pessoaService.list();

        // assert
        assertNotNull(pessoaDTOS);
        assertTrue(!pessoaDTOS.isEmpty());
    }

    @Test
    public void deveTestarListPaginadoComSucesso(){
        // setup
        List<PessoaEntity> pessoaEntities = List.of(getPessoaEntity());
        Page<PessoaEntity> pagePessoas = new PageImpl<>(pessoaEntities);

        when(pessoaRepository.findAll(any(Pageable.class)))
                .thenReturn(pagePessoas);

        // act
        Page<PessoaEntity> paginaDePessoas = pessoaService
                .listPaginado(1000, 3);

        // assert
        assertNotNull(paginaDePessoas);
        assertEquals(1, paginaDePessoas.getTotalElements());
        assertEquals(1, paginaDePessoas.getContent().size());
    }

    private static PessoaEntity getPessoaEntity() {
        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setDataNascimento(LocalDate.of(1991,9,8));
        pessoaEntity.setCpf("12345679810");
        pessoaEntity.setEmail("maicon@teste.com.br");
        pessoaEntity.setBatata("Maicon");
        pessoaEntity.setIdPessoa(10);
        return pessoaEntity;
    }
}

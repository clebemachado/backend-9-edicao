package br.com.pessoaapi.service;

import br.com.pessoaapi.dto.PessoaCreateDTO;
import br.com.pessoaapi.dto.PessoaDTO;
import br.com.pessoaapi.entity.PessoaEntity;
import br.com.pessoaapi.exception.EntidadeNaoEncontradaException;
import br.com.pessoaapi.exception.RegraDeNegocioException;
import br.com.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceTest {

    @InjectMocks // injetar a classe na qual é o foco do caso de uso...
    private PessoaService pessoaService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private PessoaRepository pessoaRepository;


    @Before
    public void init() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ReflectionTestUtils.setField(pessoaService, "objectMapper", objectMapper);
    }

    @Test
    public void deveTestarCreateComSucesso() {
        // setup  preparamos o que vamos usar no teste
        PessoaCreateDTO pessoaCreateDTO = getPessoaCreateDTO();

        PessoaEntity pessoaEntity = getPessoaEntity();

        when(pessoaRepository.save(any(PessoaEntity.class))).thenReturn(pessoaEntity);

        // act    ação do teste
        PessoaDTO pessoaDTO = pessoaService.create(pessoaCreateDTO);

        // assert garatir o retorno do teste
        assertNotNull(pessoaDTO);
        assertEquals(LocalDate.of(1991, 9, 8), pessoaDTO.getDataNascimento());
        assertEquals("12345679810", pessoaDTO.getCpf());
        assertEquals("maicon@teste.com.br", pessoaDTO.getEmail());
        assertEquals(null, pessoaDTO.getNome());
        assertNotNull(pessoaDTO.getIdPessoa());
    }


    @Test
    public void deveTestarListComSucesso() {
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
    public void deveTestarListPaginadoComSucesso() {
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

    @Test
    public void deveTestarUpdateComSucesso() throws EntidadeNaoEncontradaException, RegraDeNegocioException {
        // setup
        PessoaCreateDTO pessoaCreateDTO = getPessoaCreateDTO();
        PessoaEntity pessoaEntity = getPessoaEntity();

        when(pessoaRepository.findById(anyInt())).thenReturn(Optional.of(pessoaEntity));
        when(pessoaRepository.save(any(PessoaEntity.class))).thenReturn(pessoaEntity);

        // act
        PessoaDTO pessoaDTO = pessoaService.update(10, pessoaCreateDTO);

        // assert
        assertNotNull(pessoaDTO);
        assertEquals(10, pessoaDTO.getIdPessoa().intValue());
        assertEquals(LocalDate.of(1991, 9, 8), pessoaDTO.getDataNascimento());
        assertEquals("12345679810", pessoaDTO.getCpf());
        assertEquals("maicon@teste.com.br", pessoaDTO.getEmail());
        assertEquals(null, pessoaDTO.getNome());
    }

    @Test(expected = EntidadeNaoEncontradaException.class)
    public void deveTestarUpdateSemId() throws EntidadeNaoEncontradaException {
        // setup
        PessoaCreateDTO pessoaCreateDTO = getPessoaCreateDTO();

        when(pessoaRepository.findById(anyInt())).thenReturn(Optional.empty());

        // act
        pessoaService.update(10, pessoaCreateDTO);

        // assert
    }

    @Test
    public void deveTestarDeleteComSucesso() {
        // setup
        Integer idParaDeletar = 10;
        PessoaEntity pessoaEntity = getPessoaEntity();

        when(pessoaRepository.findById(anyInt())).thenReturn(Optional.of(pessoaEntity));
        doNothing().when(pessoaRepository).delete(any(PessoaEntity.class));

        // act
        pessoaService.delete(idParaDeletar);

        // assert
        verify(pessoaRepository, times(1)).delete(any(PessoaEntity.class));
    }

    private static PessoaEntity getPessoaEntity() {
        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setDataNascimento(LocalDate.of(1991, 9, 8));
        pessoaEntity.setCpf("12345679810");
        pessoaEntity.setEmail("maicon@teste.com.br");
        pessoaEntity.setBatata("Maicon");
        pessoaEntity.setIdPessoa(10);
        return pessoaEntity;
    }


    private static PessoaCreateDTO getPessoaCreateDTO() {
        PessoaCreateDTO pessoaCreateDTO = new PessoaCreateDTO();
        pessoaCreateDTO.setDataNascimento(LocalDate.of(1991, 9, 8));
        pessoaCreateDTO.setCpf("12345679810");
        pessoaCreateDTO.setEmail("maicon@teste.com.br");
        pessoaCreateDTO.setNome("Maicon");
        return pessoaCreateDTO;
    }
}

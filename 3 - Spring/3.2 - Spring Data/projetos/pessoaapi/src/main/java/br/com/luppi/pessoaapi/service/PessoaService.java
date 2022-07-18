package br.com.luppi.pessoaapi.service;

import br.com.luppi.pessoaapi.dto.PessoaCreateDTO;
import br.com.luppi.pessoaapi.dto.PessoaDTO;
import br.com.luppi.pessoaapi.entity.PessoaEntity;
import br.com.luppi.pessoaapi.exception.EntidadeNaoEncontradaException;
import br.com.luppi.pessoaapi.exception.RegraDeNegocioException;
import br.com.luppi.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
//    @Autowired
//    private  PessoaRepository pessoaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private final String NOT_FOUND_MESSAGE = "ID da pessoa nao encontrada";


    public PessoaDTO create(PessoaCreateDTO pessoaDto) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = converterDTO(pessoaDto);
        return retornarDTO(pessoaRepository.save(pessoaEntity));
    }
    public List<PessoaDTO> list(){
        return pessoaRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaDto) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        PessoaEntity pessoaEntityRecuperada = returnPersonById(id);

        pessoaEntityRecuperada.setCpf(pessoaDto.getCpf());
        pessoaEntityRecuperada.setEmail(pessoaDto.getEmail());
        pessoaEntityRecuperada.setDataNascimento(pessoaDto.getDataNascimento());
        pessoaEntityRecuperada.setNome(pessoaDto.getNome());

        return retornarDTO(pessoaRepository.save(pessoaEntityRecuperada));
    }

    public void delete(Integer id) throws EntidadeNaoEncontradaException {
        PessoaEntity pessoaEntityRecuperada = returnPersonById(id);
        pessoaRepository.delete(pessoaEntityRecuperada);
//        pessoaRepositoryTIRARJPA.deleteById(id);
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public void verificarId(Integer idPessoa) throws  EntidadeNaoEncontradaException {
        pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

    public PessoaEntity returnPersonById(Integer id) throws EntidadeNaoEncontradaException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

    public PessoaEntity returnByCpf(String cpf) throws EntidadeNaoEncontradaException {
        return pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

    public PessoaEntity converterDTO(PessoaCreateDTO dto) {
        return objectMapper.convertValue(dto, PessoaEntity.class);
    }

    public PessoaDTO retornarDTO(PessoaEntity pessoaEntity) {
        return objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
    }
}

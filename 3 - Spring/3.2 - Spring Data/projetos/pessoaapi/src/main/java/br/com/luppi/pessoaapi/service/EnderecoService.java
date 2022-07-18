package br.com.luppi.pessoaapi.service;


import br.com.luppi.pessoaapi.dto.EnderecoCreateDTO;
import br.com.luppi.pessoaapi.dto.EnderecoDTO;
import br.com.luppi.pessoaapi.entity.Endereco;
import br.com.luppi.pessoaapi.entity.PessoaEntity;
import br.com.luppi.pessoaapi.exception.EntidadeNaoEncontradaException;
import br.com.luppi.pessoaapi.exception.RegraDeNegocioException;
import br.com.luppi.pessoaapi.repository.EnderecoRepository;
import br.com.luppi.pessoaapi.repository.PessoaRepositoryOld;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaRepositoryOld pessoaRepositoryOld;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EmailService emailService;

    private final String NOT_FOUND_MESSAGE = "ID do endereço nao encontrado";


    public EnderecoDTO create(Integer id, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        PessoaEntity pessoaEntity = pessoaService.returnPersonById(id);
        enderecoCreateDTO.setIdPessoa(id);
        Endereco endereco = returnEntity(enderecoCreateDTO);
        EnderecoDTO enderecoDto = retornarDTO(enderecoRepository.create(endereco));
        emailService.sendCreateEnderecoEmail(pessoaEntity, endereco);
        return enderecoDto;
    }

    public List<EnderecoDTO> list() {
        return enderecoRepository.list().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        Endereco enderecoAtualizado = returnEntity(enderecoCreateDTO);
        PessoaEntity pessoaEntity = pessoaService.returnPersonById(enderecoAtualizado.getIdPessoa());
        Endereco enderecoRecuperado = recuperarEnderecoPorIdEndereco(id);
        EnderecoDTO enderecoDto = retornarDTO(enderecoRepository.update(enderecoRecuperado, enderecoAtualizado));
        emailService.sendUpdateEnderecoEmail(pessoaEntity, enderecoAtualizado);
        return enderecoDto;
    }

    public void delete(Integer id) throws EntidadeNaoEncontradaException, RegraDeNegocioException {
        Endereco enderecoRecuperado = recuperarEnderecoPorIdEndereco(id);
        PessoaEntity pessoaEntity = pessoaService.returnPersonById(enderecoRecuperado.getIdPessoa());
        enderecoRepository.delete(enderecoRecuperado);
        emailService.sendDeleteEnderecoEmail(pessoaEntity, enderecoRecuperado);
    }

    public List<EnderecoDTO> listByPersonId(Integer id) throws EntidadeNaoEncontradaException {
        pessoaService.verificarId(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByAddressId(Integer id) throws EntidadeNaoEncontradaException {
        verificarId(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    //Uteis-------------------------------------------
    private Endereco recuperarEnderecoPorIdEndereco(Integer id) throws EntidadeNaoEncontradaException {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

    private void verificarId(Integer id) throws EntidadeNaoEncontradaException {
        enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

    public Endereco returnEntity(EnderecoCreateDTO dto) {
        return objectMapper.convertValue(dto, Endereco.class);
    }

    public EnderecoDTO retornarDTO(Endereco endereco) {
        return objectMapper.convertValue(endereco, EnderecoDTO.class);
    }
}

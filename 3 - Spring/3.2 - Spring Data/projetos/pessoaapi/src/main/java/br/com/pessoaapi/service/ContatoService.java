package br.com.pessoaapi.service;

import br.com.pessoaapi.dto.ContatoCreateDTO;
import br.com.pessoaapi.dto.ContatoDTO;
import br.com.pessoaapi.entity.Contato;
import br.com.pessoaapi.exception.EntidadeNaoEncontradaException;
import br.com.pessoaapi.exception.RegraDeNegocioException;
import br.com.pessoaapi.repository.ContatoRepository;
import br.com.pessoaapi.repository.PessoaRepositoryOld;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaRepositoryOld pessoaRepositoryOld;
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private ObjectMapper objectMapper;


    public ContatoDTO create(Integer id, ContatoCreateDTO contatoDto) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        pessoaService.verificarId(id);
        contatoDto.setIdPessoa(id);
        Contato contato = retornarEntidade(contatoDto);
        return retornarDTO(contatoRepository.create(contato));
    }
    public List<ContatoDTO> list(){
        return contatoRepository.list().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id,ContatoCreateDTO contatoDto) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        Contato contatoAtualizado = retornarEntidade(contatoDto);
        Contato contatoRecuperado = recuperarContatoPorIdContato(id);
        return retornarDTO(contatoRepository.update(contatoRecuperado, contatoAtualizado));
    }

    public void delete(Integer id) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        Contato contatoRecuperado = recuperarContatoPorIdContato(id);
        contatoRepository.delete(contatoRecuperado);
    }

    public List<ContatoDTO> listByPersonId(Integer id) throws EntidadeNaoEncontradaException {
        pessoaService.verificarId(id);
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }



    // Uteis-----------------------------------------------------------------------

    private Contato recuperarContatoPorIdContato(Integer id) throws EntidadeNaoEncontradaException {
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Contato não encontrado"));
    }

    private Contato retornarEntidade(ContatoCreateDTO dto) {
        return objectMapper.convertValue(dto, Contato.class);
    }

    private ContatoDTO retornarDTO(Contato contato) {
        return objectMapper.convertValue(contato, ContatoDTO.class);
    }
}

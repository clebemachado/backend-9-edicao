package br.com.pessoaapi.controller;

import br.com.pessoaapi.dto.PessoaCompostaTudoDTO;
import br.com.pessoaapi.entity.PessoaEntity;
import br.com.pessoaapi.repository.PessoaRepository;
import br.com.pessoaapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paginacao")
@RequiredArgsConstructor
public class PaginacaoController {
    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;

    @GetMapping
    public Page<PessoaEntity> getPessoas(Integer pagina, Integer quantidadeRegistros){
        return pessoaService.listPaginado(pagina, quantidadeRegistros);
    }

    @GetMapping("/relatorio-paginado")
    public Page<PessoaCompostaTudoDTO> getRelatorioPaginado(Integer pagina, Integer quantidadeRegistros){
        Sort ordenacao = Sort.by("batata").descending()
                .and(Sort.by("cpf"));
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, ordenacao);
//        Page<PessoaCompostaTudoDTO> pessoaCompostaTudoPaginado = pessoaRepository.findPessoaCompostaTudoPaginado(pageable);
//        return pessoaCompostaTudoPaginado.getContent();
        return pessoaRepository.findPessoaCompostaTudoPaginado(pageable);
    }

    @GetMapping("/por-cpf-nativo")
    public Page<PessoaEntity> getCpfNativo(Integer pagina, Integer quantidadeRegistros, @RequestParam(required = false) String cpf){
        Sort ordenacao = Sort.by("nome");
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, ordenacao);
        return pessoaRepository.listPessoasByCpfNativePaginado(cpf, pageable);
    }
}

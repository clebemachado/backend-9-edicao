package br.com.luppi.pessoaapi.controller;

import br.com.luppi.pessoaapi.dto.DadosPessoaisDTO;
import br.com.luppi.pessoaapi.service.DadosPessoaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dados-pessoais")
public class DadosPessoaisController {
    @Autowired
    private DadosPessoaisService dadosPessoaisService;


    @GetMapping
    public List<DadosPessoaisDTO> getAll() {
        return dadosPessoaisService.getAll();
    }

    @PostMapping
    public DadosPessoaisDTO post(DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisService.post(dadosPessoaisDTO);
    }

    @PutMapping("/{cpf}")
    public DadosPessoaisDTO put(@PathVariable("cpf") String cpf, DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisService.put(cpf, dadosPessoaisDTO);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf) {
        dadosPessoaisService.delete(cpf);
    }

    @GetMapping("/{cpf}")
    public DadosPessoaisDTO get(@PathVariable("cpf") String cpf) {
        return dadosPessoaisService.get(cpf);
    }
}

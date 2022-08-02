package br.com.pessoaapi.controller;

import br.com.pessoaapi.config.PropertiesReader;
import br.com.pessoaapi.dto.PessoaCompostaDTO;
import br.com.pessoaapi.dto.PessoaCreateDTO;
import br.com.pessoaapi.dto.PessoaDTO;
import br.com.pessoaapi.entity.ContatoEntity;
import br.com.pessoaapi.entity.PessoaEntity;
import br.com.pessoaapi.enums.TipoContato;
import br.com.pessoaapi.repository.PessoaRepository;
import br.com.pessoaapi.service.EmailService;
import br.com.pessoaapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Validated
@Slf4j
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PropertiesReader propertiesReader;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Operation(summary = "Adicionar pessoa", description = "Adiciona uma pessoa na aplicação")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Adiciona a pessoa"),
                    @ApiResponse(responseCode = "500", description = "Exception gerada")
            }
    )
    @PostMapping
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }

    @Operation(summary = "Listar pessoas", description = "lista todas as pessoas cadastradas")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna todas as pessoas cadastradas"),
                    @ApiResponse(responseCode = "500", description = "Exception gerada")
            }
    )
    @GetMapping // localhost:8080/pessoa
    public ResponseEntity<List<PessoaDTO>> list() {
        return ResponseEntity.ok(pessoaService.list());
    }


    @GetMapping("/by-nome") // localhost:8080/pessoa/12341 // localhost:8080/pessoa/12341
    // localhost:8080/pessoa?nome=blablabla
    public ResponseEntity<List<PessoaEntity>> list(@RequestParam("nome") String nome) {
        return ResponseEntity.ok(pessoaRepository.findAllByBatataContains(nome));
    }
    // "/pessoa/contatos-id-pessoa/" 3
    // "/pessoa/contatos-id-pessoa/**/sdfsdf"
    @GetMapping("/contatos-id-pessoa/{idPessoa}") // localhost:8080/pessoa/12341 // localhost:8080/pessoa/12341
    // localhost:8080/pessoa?nome=blablabla
    public ResponseEntity<Collection<ContatoEntity>> list(@PathVariable("idPessoa") Integer idPessoa) {
        PessoaEntity pessoa = pessoaRepository
                .findById(idPessoa)
                .get();

        return ResponseEntity.ok(pessoa.getContatos());
    }

    // "/pessoa/contatos-id-pessoa/**/cpf"
    @GetMapping("/contatos-id-pessoa/{cpf}/cpf") // localhost:8080/pessoa/12341 // localhost:8080/pessoa/12341
    // localhost:8080/pessoa?nome=blablabla
    public ResponseEntity<Collection<ContatoEntity>> listx(@PathVariable("idPessoa") Integer idPessoa) {
        PessoaEntity pessoa = pessoaRepository
                .findById(idPessoa)
                .get();

        return ResponseEntity.ok(pessoa.getContatos());
    }

    @Operation(summary = "Buscar por nome", description = "lista as pessoas através do nome desejado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna as pessoas pelo nome"),
                    @ApiResponse(responseCode = "500", description = "Exception gerada")
            }
    )
    @GetMapping("/byname")
    public ResponseEntity<List<PessoaDTO>> listByName(@RequestParam("nome") String nome) {
        return ResponseEntity.ok(pessoaService.listByName(nome));
    }

    @Operation(summary = "Atualizar pessoa", description = "Atualiza os dados cadastrados de uma pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Dados atualizados"),
                    @ApiResponse(responseCode = "500", description = "Exception gerada")
            }
    )
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                            @RequestBody @Valid PessoaCreateDTO pessoaAtualizada) throws Exception {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizada));
    }

    @Operation(summary = "Remover pessoa", description = "remove uma pessoa através do id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cadastro removido"),
                    @ApiResponse(responseCode = "500", description = "Exception gerada")
            }
    )
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) {
        pessoaService.delete(id);
    }

    @Hidden
    @GetMapping("/ambiente")
    public String retornarPropertie() {
        return propertiesReader.getAmbiente();
    }

    //@GetMapping("/pessoas/cpf/{meuCPF}")
    @GetMapping("/cpf")
    public List<PessoaEntity> getPessoasByCpf(String cpf) { // ?cpf=12411221 //@PathVariable("meuCPF") String meuCpf
        return pessoaRepository.listPessoasByCpf(cpf);
    }

    @GetMapping("/cpf-native")
    public List<PessoaEntity> getPessoasByCpfNative(String cpf) { // ?cpf=12411221 //@PathVariable("meuCPF") String meuCpf
        return pessoaRepository.listPessoasByCpfNative(cpf);
    }

    @GetMapping("/contatos-por-tipo")
    public List<PessoaEntity> getContatosPorTipo(TipoContato tipoContato) {
       return pessoaRepository.listPessoasPorTipoContato(tipoContato);
    }

    @GetMapping("/contatos-por-tipo-native")
    public List<PessoaEntity> getContatosPorTipoNative(TipoContato tipoContato) { // ?cpf=12411221 //@PathVariable("meuCPF") String meuCpf
        return pessoaRepository.listPessoasPorTipoContatoNative(tipoContato.ordinal());
    }

    @GetMapping("/pessoa-composta")
    public List<PessoaCompostaDTO> getPessoaComposta(@RequestParam(required = false) Integer idPessoa) { // ?cpf=12411221 //@PathVariable("meuCPF") String meuCpf
        return pessoaRepository.listaCompostaDTO(idPessoa);
    }
}


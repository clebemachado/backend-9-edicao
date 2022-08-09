package com.kafka.produtor.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.produtor.dto.BancoDTO;
import com.kafka.produtor.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/enviar")
    public void enviarMensagemParaOTopico(String mensagem){
        produtorService.enviarMensagemString(mensagem);
    }

    @PostMapping("/enviar-dados-bancarios")
    public void enviarMensagemParaOTopico(@RequestBody BancoDTO bancoDTO) throws JsonProcessingException {
        produtorService.enviarMensagemObjeto(bancoDTO);
    }
}

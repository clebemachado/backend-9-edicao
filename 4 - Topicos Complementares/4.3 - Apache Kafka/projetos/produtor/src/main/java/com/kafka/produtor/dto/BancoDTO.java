package com.kafka.produtor.dto;

import lombok.Data;

import java.util.List;

@Data
public class BancoDTO {
    private String nrConta;
    private String nrAgencia;
    private String nome;
    private Double valorConta;
    private List<String> transferencias;
}

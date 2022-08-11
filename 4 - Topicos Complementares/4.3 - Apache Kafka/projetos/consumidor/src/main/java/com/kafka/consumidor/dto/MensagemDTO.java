package com.kafka.consumidor.dto;

import lombok.Data;

@Data
public class MensagemDTO {
    private String msg;
    private String destinatario;
    private String remetente;
    private String assunto;
}

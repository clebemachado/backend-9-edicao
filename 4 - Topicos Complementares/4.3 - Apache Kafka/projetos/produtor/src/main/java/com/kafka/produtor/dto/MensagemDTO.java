package com.kafka.produtor.dto;

import lombok.Data;

@Data
public class MensagemDTO {
    private String msg;
    private String destinatario;
    private String remetente;
    private String assunto;
}

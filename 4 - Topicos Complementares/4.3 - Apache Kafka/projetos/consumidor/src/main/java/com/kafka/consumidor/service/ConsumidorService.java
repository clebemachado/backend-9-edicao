package com.kafka.consumidor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.consumidor.dto.BancoDTO;
import com.kafka.consumidor.dto.MensagemDTO;
import com.kafka.consumidor.dto.TipoMensagem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumidorService {

    private final ObjectMapper objectMapper;

//    @KafkaListener(
//            topics = "${kafka.topic}", // meu-primeiro-topico
//            groupId = "group1",
//            containerFactory = "listenerContainerFactory",
//            clientIdPrefix = "primeiroTopico")
//    public void consumir(@Payload String mensagem,
//                         @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
//                         @Header(KafkaHeaders.OFFSET) Long offset) {
//        log.info("####{consume} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, mensagem);
//    }
//
//    @KafkaListener(
//            topics = "${kafka.topic-banco}", // meu-primeiro-topico
//            groupId = "group1",
//            containerFactory = "listenerContainerFactory",
//            clientIdPrefix = "banco")
//    public void consumirBanco(@Payload String mensagem,
//                              @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
//                              @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
//        BancoDTO bancoDTO = objectMapper.readValue(mensagem, BancoDTO.class);
//        log.info("####{consume} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, bancoDTO);
//    }

    @KafkaListener(
            groupId = "group1",
            containerFactory = "listenerContainerFactory",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic-mensagem}", partitions = {"0", "1"})},
            clientIdPrefix = "mensagens-whatsapp-sms")
    public void consumirMensagens(@Payload String mensagem,
                                  @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                  @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer particao,
                                  @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        if (particao == TipoMensagem.SMS.ordinal()) {
            log.info("####{SMS} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}' partition -> {}  ", offset, key, mensagemDTO, particao);
        } else {
            log.info("####{WHATSAPP} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  partition -> {} ", offset, key, mensagemDTO, particao);
        }
    }

    @KafkaListener(
            groupId = "group1",
            containerFactory = "listenerContainerFactory",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic-mensagem}", partitions = {"2"})},
            clientIdPrefix = "mensagens-email")
    public void consumirMensagensEmail(@Payload String mensagem,
                                  @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                  @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer particao,
                                  @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info("####{EMAIL} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}' partition -> {}  ", offset, key, mensagemDTO, particao);
    }
}

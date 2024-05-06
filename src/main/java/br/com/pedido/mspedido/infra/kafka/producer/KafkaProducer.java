package br.com.pedido.mspedido.infra.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topico, String pedidoId) {
        kafkaTemplate.send(topico, pedidoId);
    }
}

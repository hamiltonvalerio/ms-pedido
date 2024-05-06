package br.com.pedido.mspedido.adapter.output.kafka.producer;

import br.com.pedido.mspedido.infra.kafka.producer.KafkaProducer;
import org.springframework.stereotype.Component;

@Component
public class PedidoProducerImpl {

    private final KafkaProducer kafkaProducer;

    public PedidoProducerImpl(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public void sendPedido(Long id) {
        System.out.println("Enviando pedido: " + id);
        kafkaProducer.send("pedido-kafka-topic", id.toString());
    }
}

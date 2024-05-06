package br.com.pedido.mspedido.infra.kafka.consumer;

import br.com.pedido.mspedido.domain.StatusPedido;
import br.com.pedido.mspedido.domain.entity.Pedido;
import br.com.pedido.mspedido.infra.mongo.repository.pedido.PedidoRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private final PedidoRepository pedidoRepository;

    public KafkaConsumer(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @KafkaListener(topics = "pedido-kafka-topic", groupId = "group-id-pedido")
    public void consumeReserva(String pedidoId) {
        System.out.println("Consumindo pedido: " + pedidoId);
        Pedido pedido = pedidoRepository.findById(Long.valueOf(pedidoId)).orElse(null);
        if(pedido != null) {
            pedido.setStatus(StatusPedido.ENVIADO_TRANSPORTADORA.name());
            pedidoRepository.save(pedido);
        }
    }
}

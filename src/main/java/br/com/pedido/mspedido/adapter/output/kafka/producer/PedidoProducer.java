package br.com.pedido.mspedido.adapter.output.kafka.producer;

public interface PedidoProducer {
    public void sendPedido(Long id);
}

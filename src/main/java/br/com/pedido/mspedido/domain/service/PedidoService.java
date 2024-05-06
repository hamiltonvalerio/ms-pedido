package br.com.pedido.mspedido.domain.service;

import br.com.pedido.mspedido.domain.entity.Pedido;
import br.com.pedido.mspedido.infra.mongo.repository.pedido.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido getPedidoById(String id) {
        return pedidoRepository.findById(Long.valueOf(id)).orElse(null);
    }
}

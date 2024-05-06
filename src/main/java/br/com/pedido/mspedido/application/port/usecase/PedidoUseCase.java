package br.com.pedido.mspedido.application.port.usecase;

import br.com.pedido.mspedido.adapter.input.dto.PedidoDTO;

public interface PedidoUseCase {
    PedidoDTO criarPedido(PedidoDTO pedidoDTO);

    PedidoDTO buscarPedido(String id);
}

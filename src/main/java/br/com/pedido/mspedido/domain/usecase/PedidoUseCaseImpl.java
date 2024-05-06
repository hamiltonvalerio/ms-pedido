package br.com.pedido.mspedido.domain.usecase;

import br.com.pedido.mspedido.adapter.input.dto.PedidoDTO;
import br.com.pedido.mspedido.adapter.input.mapper.PedidoMapper;
import br.com.pedido.mspedido.adapter.output.kafka.producer.PedidoProducerImpl;
import br.com.pedido.mspedido.application.port.usecase.PedidoUseCase;
import br.com.pedido.mspedido.domain.StatusPedido;
import br.com.pedido.mspedido.domain.service.PedidoService;
import org.springframework.stereotype.Component;

@Component
public class PedidoUseCaseImpl implements PedidoUseCase {

    private final PedidoService pedidoService;

    private final PedidoProducerImpl pedidoProducerImpl;

    public PedidoUseCaseImpl(PedidoService pedidoService, PedidoProducerImpl pedidoProducerImpl) {
        this.pedidoService = pedidoService;
        this.pedidoProducerImpl = pedidoProducerImpl;
    }

    @Override
    public PedidoDTO criarPedido(PedidoDTO pedidoDTO) {
        pedidoDTO.setStatus(StatusPedido.AGUARDANDO_ENVIO.name());
        PedidoDTO dto = PedidoMapper.INSTANCE.pedidoToPedidoDTO(pedidoService.savePedido(PedidoMapper.INSTANCE.pedidoDTOToPedido(pedidoDTO)));
        if(dto == null) {
            throw new RuntimeException("Erro ao criar pedido");
        }else{
            enviarMensagem(dto);
        }
        return dto;
    }

    private void enviarMensagem(PedidoDTO dto) {
        System.out.println("Enviando mensagem para o pedido: " + dto.getId());
        pedidoProducerImpl.sendPedido(dto.getId());
    }

    @Override
    public PedidoDTO buscarPedido(String id) {
        return PedidoMapper.INSTANCE.pedidoToPedidoDTO(pedidoService.getPedidoById(id));
    }
}

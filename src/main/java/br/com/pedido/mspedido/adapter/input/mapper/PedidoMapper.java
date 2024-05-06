package br.com.pedido.mspedido.adapter.input.mapper;

import br.com.pedido.mspedido.adapter.input.dto.PedidoDTO;
import br.com.pedido.mspedido.domain.entity.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);
    PedidoDTO pedidoToPedidoDTO(Pedido pedido);
    Pedido pedidoDTOToPedido(PedidoDTO pedidoDTO);
}

package br.com.pedido.mspedido.infra.mongo.repository.pedido;

import br.com.pedido.mspedido.domain.entity.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido, Long>{
}

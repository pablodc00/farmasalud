package io.efip.farmasalud.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import io.efip.farmasalud.model.DetallePedido;

public interface DetallePedidoRepository extends CrudRepository<DetallePedido, Long> {

    List<DetallePedido> findByPedido_Id(Long pedidoId);
}

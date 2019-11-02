package io.efip.farmasalud.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.efip.farmasalud.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {

    List<Pedido> findBySucursal_Id(Long sucursalId);
}

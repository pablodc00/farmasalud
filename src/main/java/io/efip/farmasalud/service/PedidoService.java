package io.efip.farmasalud.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.efip.farmasalud.dao.DetallePedidoRepository;
import io.efip.farmasalud.dao.PedidoRepository;
import io.efip.farmasalud.model.DetallePedido;
import io.efip.farmasalud.model.Pedido;

@Service
public class PedidoService {
    private static final Logger LOG = LoggerFactory.getLogger(PedidoService.class);
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public Long registrarPedido(DetallePedido detallePedido) {
        LOG.info("Registro de pedido ...");
        pedidoRepository.save(detallePedido.getPedido());
        LOG.info("Registro de pedido finalizado, ID: {}", detallePedido.getPedido().getId());

        LOG.info("Registro detalle pedido ...");
        detallePedidoRepository.save(detallePedido);        
        LOG.info("Registro detalle pedido finalizado, ID: {}", detallePedido.getId());
        return detallePedido.getId();
    }
    
    public List<DetallePedido> findDetallePedidoByPedido(Long pedidoId) {
        LOG.info("Find detalle pedido by pedido {}", pedidoId);
        return detallePedidoRepository.findByPedido_Id(pedidoId);
    }    
    
    public Optional<Pedido> findPedidoById(Long pedidoId) {
        LOG.info("Find pedido by ID {}", pedidoId);
        return pedidoRepository
                .findById(pedidoId);
    }

    public List<Pedido> findPedidosBySucursal(Long sucursalId) {
        LOG.info("Find pedidos by sucursal {}", sucursalId);
        return pedidoRepository.findBySucursal_Id(sucursalId);
    }
    


}

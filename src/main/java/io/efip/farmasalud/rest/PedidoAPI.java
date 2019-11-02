package io.efip.farmasalud.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.efip.farmasalud.model.DetallePedido;
import io.efip.farmasalud.model.Pedido;
import io.efip.farmasalud.service.PedidoService;

@RestController
@RequestMapping("/farmasalud/v1")
public class PedidoAPI {

    @Autowired
    private PedidoService pedidoService;
    
    
    @PostMapping("/detallepedido")
    public ResponseEntity<DetallePedido> registrarPedido(@RequestBody DetallePedido pedido) {        
        Long pedidoId = this.pedidoService.registrarPedido(pedido);
        pedido.setId(pedidoId);
        return ResponseEntity.ok(pedido);
    }
    
    @GetMapping("/detallepedido/{pedido_id}")
    public ResponseEntity<List<DetallePedido>> getDetallePedidosById(@PathVariable("pedido_id") Long pedidoId) {           
        List<DetallePedido> pedidos = pedidoService.findDetallePedidoByPedido(pedidoId);
        return ResponseEntity.ok(pedidos);
    }    

    @GetMapping("/pedidos/sucursal/{sucursal_id}")
    public ResponseEntity<List<Pedido>> getPedidosBySucursal(@PathVariable("sucursal_id") Long sucursalId) {           
        List<Pedido> pedidos = pedidoService.findPedidosBySucursal(sucursalId);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/pedidos/{pedido_id}")
    public ResponseEntity<Pedido> getPedidosById(@PathVariable("pedido_id") Long pedidoId) {           
        Optional<Pedido> pedido = pedidoService.findPedidoById(pedidoId);
        
        if (pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

package io.efip.farmasalud.service;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import io.efip.farmasalud.dao.DetallePedidoRepository;
import io.efip.farmasalud.model.DetallePedido;
import io.efip.farmasalud.model.Pedido;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PedidoServiceTest {

    @Autowired
    private PedidoService pedidoService;
    
    @MockBean
    private DetallePedidoRepository detallePedidoRepositoryMock;
    
    @Test
    public void testRegistraPedido() {
        
        Pedido pedido = new Pedido();
        pedido.setNombre("pedido 10");
        pedido.setDescripcion("pedido 10");

        DetallePedido pedidoIn = new DetallePedido();
        pedidoIn.setCantidad(10);
        pedidoIn.setPedido(pedido);
        
        DetallePedido pedidoOut = new DetallePedido();
        pedidoOut.setId(10L);        
        
        when(this.detallePedidoRepositoryMock.save(any(DetallePedido.class))).thenReturn(pedidoOut);
        Long pedidoId = pedidoService.registrarPedido(pedidoIn);

        Long expected[] = {pedidoId};
        Long actuals[] = {pedidoOut.getId()};
        assertArrayEquals(expected, actuals);
    }
}

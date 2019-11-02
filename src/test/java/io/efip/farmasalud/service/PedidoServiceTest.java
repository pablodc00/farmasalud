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

import io.efip.farmasalud.dao.PedidoRepository;
import io.efip.farmasalud.model.Pedido;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PedidoServiceTest {

    @Autowired
    private PedidoService pedidoService;
    
    @MockBean
    private PedidoRepository pedidoRepositoryMock;
    
    @Test
    public void testRegistraPedido() {
        
        Pedido pedidoIn = new Pedido();
        pedidoIn.setNombre("pedido 10");
        pedidoIn.setDescripcion("pedido 10");
        
        Pedido pedidoOut = new Pedido();
        pedidoOut.setId(10L);
        pedidoOut.setNombre(pedidoIn.getNombre());
        pedidoOut.setDescripcion(pedidoIn.getDescripcion());
        
        when(this.pedidoRepositoryMock.save(any(Pedido.class))).thenReturn(pedidoOut);
        Long pedidoId = pedidoService.registrarPedido(pedidoIn);

        Long expected[] = {pedidoId};
        Long actuals[] = {pedidoOut.getId()};
        assertArrayEquals(expected, actuals);
    }
}

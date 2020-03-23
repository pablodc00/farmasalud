package io.efip.farmasalud.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String descripcion;

/*    
    @OneToMany(mappedBy = "pedido",
               fetch = FetchType.EAGER,
               cascade = CascadeType.PERSIST)
    private List<DetallePedido> detallesPedidos;
*/    
    private Date fechaEnvio;
    private int prioridad;
    
    @ManyToOne
    private Sucursal sucursal;
    
}

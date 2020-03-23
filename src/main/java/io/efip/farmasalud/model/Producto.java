package io.efip.farmasalud.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto {
    
    public enum TipoProducto {
        MEDICAMENTO, COMUN;
    }    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    private String nombre;
    @Enumerated(EnumType.STRING)
    private TipoProducto tipo;
    private String descripcion;
    private Date fechaAlta;
    private Date fechaBaja;
    private Date fechaVencimiento;

    @ManyToOne
    private Pais paisOrigen;
    
}

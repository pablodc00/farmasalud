package io.efip.farmasalud.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Distribuidor extends Empresa {
    private String rubro;
}

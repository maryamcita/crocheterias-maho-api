package com.cesde.crocheteriasmaho.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Direccion {
    private String calle;
    private String ciudad;
    private String codigoPostal;
    private String pais;
}
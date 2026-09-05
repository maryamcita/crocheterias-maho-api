package com.cesde.crocheteriasmaho.model.embeddable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Direccion {

    private String calle;

    private String ciudad;

    private String departamento;

    private String codigoPostal;
}

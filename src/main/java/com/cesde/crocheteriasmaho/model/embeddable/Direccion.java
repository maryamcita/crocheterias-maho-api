package com.cesde.crocheteriasmaho.model.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Direccion {

    @Column(length = 120)
    private String calle;

    @Column(length = 60)
    private String ciudad;

    @Column(length = 80)
    private String departamento;

    @Column(name = "codigo_postal", length = 20)
    private String codigoPostal;
}

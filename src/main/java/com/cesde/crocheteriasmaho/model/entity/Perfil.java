package com.cesde.crocheteriasmaho.model.entity;

import com.cesde.crocheteriasmaho.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "perfiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Perfil extends BaseEntity {

    @Column(length = 255)
    private String biografia;

    @Column(name = "foto_url", length = 255)
    private String fotoUrl;

    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false, unique = true)
    @JsonIgnoreProperties({"pedidos", "hibernateLazyInitializer", "handler"})
    private Cliente cliente;
}

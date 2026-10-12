package com.cesde.crocheteriasmaho.model.entity;

import com.cesde.crocheteriasmaho.model.entity.Cliente;
import com.cesde.crocheteriasmaho.model.enums.EstadoPedido;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaPedido;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido;

    @Embedded
    private Direccion direccionEnvio;

    public enum EstadoPedido {
        PENDIENTE,
        EN_PROCESO,
        ENTREGADO,
        CANCELADO
    }
}

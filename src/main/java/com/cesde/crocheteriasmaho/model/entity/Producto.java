package com.cesde.crocheteriasmaho.model.entity; 
import com.cesde.crocheteriasmaho.model.base.BaseEntity; 
import com.fasterxml.jackson.annotation.JsonIgnore; 
import jakarta.persistence.*; 
import lombok.*; 
import lombok.experimental.SuperBuilder; 
import java.math.BigDecimal; 
import java.util.List;

@Entity 
@Table(name = "productos") 
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@SuperBuilder

public class Producto extends BaseEntity {    
    @Column(nullable = false, length = 120)    
    private String nombre;    
    @Column(nullable = false, precision = 10, scale = 2)    
    private BigDecimal precio;    
    @Column(name = "imagen_url", length = 255)    
    private String imagenUrl;    
    @ManyToOne    
    @JoinColumn(name = "categoria_id", nullable = false)    
    private Categoria categoria;    
    @ManyToMany(mappedBy = "productos")    
    @JsonIgnore    
    private List<Pedido> pedidos; 
}
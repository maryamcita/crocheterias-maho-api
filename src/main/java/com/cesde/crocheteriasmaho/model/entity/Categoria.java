package com.cesde.crocheteriasmaho.model.entity; import java.util.List;

import com.cesde.crocheteriasmaho.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder; 
@Entity 
@Table(name = "categorias") 
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@SuperBuilder 
    public class Categoria extends BaseEntity { 
        @Column(nullable = false, unique = true, length = 80) 
        private String nombre;     
        @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)    @JsonIgnore    
        private List<Producto> productos; 
    }
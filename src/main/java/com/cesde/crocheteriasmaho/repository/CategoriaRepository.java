package com.cesde.crocheteriasmaho.repository;


import com.cesde.crocheteriasmaho.model.entity.Categoria; 
import org.springframework.data.jpa.repository.JpaRepository; 
public interface CategoriaRepository extends JpaRepository<Categoria, Long> { 
    boolean existsByNombreIgnoreCase(String nombre);
}
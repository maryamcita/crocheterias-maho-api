package com.cesde.crocheteriasmaho.controller;

import com.cesde.crocheteriasmaho.model.entity.Categoria; 
import com.cesde.crocheteriasmaho.service.CategoriaService; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*; 
@RestController 
@RequestMapping("/api/categorias") 
public class CategoriaController { 
    private final CategoriaService categoriaService; 
    public CategoriaController(CategoriaService categoriaService) { 
        this.categoriaService = categoriaService; 
    } 
    
    @PostMapping 
    public ResponseEntity<Categoria> crear(@RequestBody Categoria categoria){
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.crear(categor ia)); 
    } 
}

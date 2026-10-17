package com.cesde.crocheteriasmaho.controller;

import com.cesde.crocheteriasmaho.model.entity.Producto; 
import com.cesde.crocheteriasmaho.service.ProductoService; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*; 
import java.math.BigDecimal; 
import java.util.List; 
@RestController 
@RequestMapping("/api/productos") 
public class ProductoController { 
    private final ProductoService productoService; 
    public ProductoController(ProductoService productoService) { 
        this.productoService = productoService; 
    } 
    @PostMapping 
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) { 
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.crear(producto)); 
    } 
    @GetMapping 
    public ResponseEntity<List<Producto>> listar(@RequestParam(required = false) String categoria) { 
        return ResponseEntity.ok(productoService.listar(categoria)); 
    } 
    @GetMapping("/precio") 
    public ResponseEntity<List<Producto>> porPrecio(@RequestParam BigDecimal min, @RequestParam BigDecimal max) { 
        return ResponseEntity.ok(productoService.porRangoDePrecio(min, max)); 
    } 
}


package com.cesde.crocheteriasmaho.service; 
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cesde.crocheteriasmaho.exception.RecursoNoEncontradoException;
import com.cesde.crocheteriasmaho.exception.ReglaNegocioException;
import com.cesde.crocheteriasmaho.model.entity.Categoria;
import com.cesde.crocheteriasmaho.model.entity.Producto;
import com.cesde.crocheteriasmaho.repository.CategoriaRepository;
import com.cesde.crocheteriasmaho.repository.ProductoRepository; 
@Service 
public class ProductoService { 
    private final ProductoRepository productoRepository; 
    private final CategoriaRepository categoriaRepository; 
    public ProductoService(ProductoRepository productoRepository, CategoriaRepository categoriaRepository) { 
        this.productoRepository = productoRepository; 
        this.categoriaRepository = categoriaRepository; 
    }    
    public Producto crear(Producto producto) {        
        if (producto.getPrecio() == null || producto.getPrecio().compareTo(BigDecimal.ZERO) <= 0) {            
            throw new ReglaNegocioException("El precio debe ser mayor a cero");
        }        
        if (producto.getCategoria() == null || producto.getCategoria().getId() == null) {            
                throw new ReglaNegocioException("El producto debe tener una categoría");
        }        
        Long categoriaId = producto.getCategoria().getId();        
        Categoria categoria = categoriaRepository.findById(categoriaId).orElseThrow(() -> new RecursoNoEncontradoException("Categoría no existe: " + categoriaId));
        producto.setCategoria(categoria);
        return productoRepository.save(producto);
    }    
    public List<Producto> listar(String categoria) {
        if (categoria == null || categoria.isBlank()) {
            return productoRepository.findAll();
        }       
        return productoRepository.findByCategoriaNombreIgnoreCase(categoria);
    }    
    public List<Producto> porRangoDePrecio(BigDecimal min, BigDecimal max) {        
        if (min.compareTo(max) > 0) {
            throw new ReglaNegocioException("El precio mínimo no puede ser mayor que el máximo");
        }        
        return productoRepository.findByPrecioBetween(min, max);    
    } 
}
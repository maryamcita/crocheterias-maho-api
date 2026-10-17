package com.cesde.crocheteriasmaho.service; 
import com.cesde.crocheteriasmaho.exception.ConflictoException; 
import com.cesde.crocheteriasmaho.model.entity.Categoria; 
import com.cesde.crocheteriasmaho.repository.CategoriaRepository; 
import org.springframework.stereotype.Service; 
@Service 
public class CategoriaService { 
    private final CategoriaRepository categoriaRepository; 
    public CategoriaService(CategoriaRepository categoriaRepository) {
         this.categoriaRepository = categoriaRepository; 
    } 
    public Categoria crear(Categoria categoria) { 
        if (categoriaRepository.existsByNombreIgnoreCase(categoria.getNombre())) { 
                throw new ConflictoException("La categoría ya existe: " + categoria.getNombre()); 
        } 
                return categoriaRepository.save(categoria); 
    } 
}
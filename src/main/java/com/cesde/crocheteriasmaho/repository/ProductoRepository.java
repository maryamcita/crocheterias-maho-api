
package com.cesde.crocheteriasmaho.repository; 
import com.cesde.crocheteriasmaho.model.entity.Producto; 
import org.springframework.data.jpa.repository.JpaRepository; 
import java.math.BigDecimal; 
import java.util.List; 

 public interface ProductoRepository extends JpaRepository<Producto, Long> { 
    List<Producto> findByCategoriaNombreIgnoreCase(String nombre); 
    List<Producto> findByPrecioBetween(BigDecimal min, BigDecimal max);
 }
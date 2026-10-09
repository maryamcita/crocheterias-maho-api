package com.cesde.crocheteriasmaho.repository;

import com.cesde.crocheteriasmaho.model.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    boolean existsByClienteId(Long clienteId);

    Optional<Perfil> findByClienteId(Long clienteId);
}

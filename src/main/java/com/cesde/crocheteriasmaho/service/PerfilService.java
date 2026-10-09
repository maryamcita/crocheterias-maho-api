package com.cesde.crocheteriasmaho.service;

import com.cesde.crocheteriasmaho.exception.ConflictoException;
import com.cesde.crocheteriasmaho.exception.RecursoNoEncontradoException;
import com.cesde.crocheteriasmaho.exception.ReglaNegocioException;
import com.cesde.crocheteriasmaho.model.entity.Cliente;
import com.cesde.crocheteriasmaho.model.entity.Perfil;
import com.cesde.crocheteriasmaho.repository.ClienteRepository;
import com.cesde.crocheteriasmaho.repository.PerfilRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;
    private final ClienteRepository clienteRepository;

    public PerfilService(PerfilRepository perfilRepository, ClienteRepository clienteRepository) {
        this.perfilRepository = perfilRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Perfil crear(Long clienteId, Perfil datos) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cliente no existe: " + clienteId));

        if (perfilRepository.existsByClienteId(clienteId)) {
            throw new ConflictoException("El cliente ya tiene un perfil");
        }

        if (datos.getFotoUrl() != null && !datos.getFotoUrl().startsWith("https://")) {
            throw new ReglaNegocioException("La foto debe ser una URL segura que empiece por https://");
        }

        datos.setCliente(cliente);
        return perfilRepository.save(datos);
    }

    public Perfil obtenerPorCliente(Long clienteId) {
        return perfilRepository.findByClienteId(clienteId)
                .orElseThrow(() -> new RecursoNoEncontradoException("El cliente " + clienteId + " no tiene perfil"));
    }
}

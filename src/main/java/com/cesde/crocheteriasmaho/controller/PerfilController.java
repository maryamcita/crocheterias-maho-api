package com.cesde.crocheteriasmaho.controller;

import com.cesde.crocheteriasmaho.model.entity.Perfil;
import com.cesde.crocheteriasmaho.service.PerfilService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes/{clienteId}/perfil")
public class PerfilController {

    private final PerfilService perfilService;

    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @PostMapping
    public ResponseEntity<Perfil> crear(@PathVariable Long clienteId, @RequestBody Perfil perfil) {
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilService.crear(clienteId, perfil));
    }

    @GetMapping
    public ResponseEntity<Perfil> obtener(@PathVariable Long clienteId) {
        return ResponseEntity.ok(perfilService.obtenerPorCliente(clienteId));
    }
}

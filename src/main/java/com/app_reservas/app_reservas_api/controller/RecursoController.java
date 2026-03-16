package com.app_reservas.app_reservas_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app_reservas.app_reservas_api.entity.Recurso;
import com.app_reservas.app_reservas_api.repository.RecursoRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/recursos")
@RequiredArgsConstructor
public class RecursoController {

    private final RecursoRepository recursoRepository;

    @GetMapping
    public List<Recurso> listar() {
        return recursoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Recurso buscar(@PathVariable Long id) {
        return recursoRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Recurso crear(@RequestBody Recurso recurso) {
        return recursoRepository.save(recurso);
    }

    @PutMapping("/{id}")
    public Recurso actualizar(@PathVariable Long id, @RequestBody Recurso recurso) {
        recurso.setId(id);
        return recursoRepository.save(recurso);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        recursoRepository.deleteById(id);
    }
}
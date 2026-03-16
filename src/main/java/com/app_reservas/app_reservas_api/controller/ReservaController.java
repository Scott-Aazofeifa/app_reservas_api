package com.app_reservas.app_reservas_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app_reservas.app_reservas_api.entity.Reserva;
import com.app_reservas.app_reservas_api.service.ReservaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    /* Listar todas las reservas */
    @GetMapping
    public List<Reserva> listar() {
        return reservaService.listarReservas();
    }

    /* Buscar reserva por id */
    @GetMapping("/{id}")
    public Reserva buscar(@PathVariable Long id) {
        return reservaService.buscarReserva(id);
    }

    /* Crear reserva */
    @PostMapping
    public Reserva crear(@RequestBody Reserva reserva) {
        return reservaService.guardarReserva(reserva);
    }

    /* Cancelar reserva */
    @PutMapping("/{id}/cancelar")
    public Reserva cancelar(@PathVariable Long id) {
        return reservaService.cancelarReserva(id);
    }
}
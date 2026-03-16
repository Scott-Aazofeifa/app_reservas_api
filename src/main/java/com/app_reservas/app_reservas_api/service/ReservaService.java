package com.app_reservas.app_reservas_api.service;

import java.time.Duration;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app_reservas.app_reservas_api.entity.EstadoReserva;
import com.app_reservas.app_reservas_api.entity.Reserva;
import com.app_reservas.app_reservas_api.repository.ReservaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;

    /* Listar todas las reservas */
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    /* Buscar reserva por id */
    public Reserva buscarReserva(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    /* Guardar reserva */
    public Reserva guardarReserva(Reserva reserva) {

        if(reserva.getFechaInicio().isAfter(reserva.getFechaFin())){
            throw new RuntimeException("Inicio debe ser menor que fin");
        }

        Duration duracion = Duration.between(reserva.getFechaInicio(), reserva.getFechaFin());

        if(duracion.toHours() > 2){
            throw new RuntimeException("Duración máxima 2 horas");
        }

        List<Reserva> conflictos =
                reservaRepository.buscarConflictos(
                        reserva.getRecurso().getId(),
                        reserva.getFechaInicio(),
                        reserva.getFechaFin()
                );

        if(!conflictos.isEmpty()){
            throw new RuntimeException("Problema con reserva");
        }

        /*reserva el estado en pendiente*/
        reserva.setEstado(EstadoReserva.PENDIENTE);

        return reservaRepository.save(reserva);
    }

    /* Cancelar reserva */
    public Reserva cancelarReserva(Long id){

        Reserva reserva = buscarReserva(id);

        reserva.setEstado(EstadoReserva.CANCELADA);

        return reservaRepository.save(reserva);
    }

}
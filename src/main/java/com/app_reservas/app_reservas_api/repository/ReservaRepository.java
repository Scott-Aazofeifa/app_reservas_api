package com.app_reservas.app_reservas_api.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app_reservas.app_reservas_api.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    /* Detecta reservas solapadas */
    @Query("""
        SELECT r FROM Reserva r
        WHERE r.recurso.id = :recursoId
        AND r.estado <> 'CANCELADA'
        AND (
            (r.fechaInicio < :fin AND r.fechaFin > :inicio)
        )
    """)
    List<Reserva> buscarConflictos(
        @Param("recursoId") Long recursoId,
        @Param("inicio") LocalDateTime inicio,
        @Param("fin") LocalDateTime fin
    );

    List<Reserva> findByRecursoIdAndFechaInicioBetween(
        Long recursoId,
        LocalDateTime desde,
        LocalDateTime hasta
    );
}
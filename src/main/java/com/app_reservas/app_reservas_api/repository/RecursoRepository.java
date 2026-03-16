package com.app_reservas.app_reservas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app_reservas.app_reservas_api.entity.Recurso;

public interface RecursoRepository extends JpaRepository<Recurso, Long> {
}
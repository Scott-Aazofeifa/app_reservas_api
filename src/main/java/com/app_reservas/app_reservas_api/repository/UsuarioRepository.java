package com.app_reservas.app_reservas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app_reservas.app_reservas_api.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

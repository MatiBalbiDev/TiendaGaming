package com.tiendaGaming.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiendaGaming.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByNombreUsuario(String nombreUsuario);
	Boolean existsByNombreUsuario(String nombreUsuario);
	Boolean existsByEmail(String email);
	
}

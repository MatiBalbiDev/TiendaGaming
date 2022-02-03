package com.tiendaGaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendaGaming.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByUsername(String nombre);
	
}

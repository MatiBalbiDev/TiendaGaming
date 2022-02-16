package com.tiendaGaming.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiendaGaming.model.ERol;
import com.tiendaGaming.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
	
	Optional<Rol> findByNombre(ERol nombre);
}

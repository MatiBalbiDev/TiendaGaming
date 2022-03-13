package com.tiendaGaming.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiendaGaming.model.ERol;
import com.tiendaGaming.model.Rol;
import com.tiendaGaming.repository.RolRepository;

@Service
@Transactional
public class RolService {
	
	@Autowired
	RolRepository rolRepository;
	
	public Optional<Rol> getByERol(ERol nombre){
		return rolRepository.findByNombre(nombre);
	}
	
	public void save(Rol rol) {
		rolRepository.save(rol);
	}
}	

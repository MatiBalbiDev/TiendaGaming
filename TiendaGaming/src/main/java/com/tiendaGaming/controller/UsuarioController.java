package com.tiendaGaming.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiendaGaming.model.Usuario;
import com.tiendaGaming.request.LoginRequest;
import com.tiendaGaming.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private UsuarioService usuarioService;
	
	/*
	@PostMapping("/signin")
	public ResponseEntity<?> iniciarSesion(@Valid @RequestBody LoginRequest loginRequest){
		Authentication autentificacion = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getNombre(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(autentificacion);
		
		
		
	}
	*/
}

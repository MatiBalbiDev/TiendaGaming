package com.tiendaGaming.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendaGaming.model.ERol;
import com.tiendaGaming.model.Rol;
import com.tiendaGaming.model.Usuario;
import com.tiendaGaming.repository.UsuarioRepository;
import com.tiendaGaming.request.LoginRequest;
import com.tiendaGaming.request.RegistroRequest;
import com.tiendaGaming.response.MessageResponse;
import com.tiendaGaming.security.JwtDto;
import com.tiendaGaming.security.JwtProvider;
import com.tiendaGaming.service.RolService;
import com.tiendaGaming.service.UsuarioService;

@RestController
@RequestMapping("/")
public class UsuarioController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RolService rolService;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@PostMapping("/signin")
	public ResponseEntity<JwtDto> iniciarSesion(@Valid @RequestBody LoginRequest loginRequest){
		Authentication autentificacion = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getNombreUsuario(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(autentificacion);
		String jwt = jwtProvider.generateToken(autentificacion);
		UserDetails userDetails = (UserDetails) autentificacion.getPrincipal();
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		return new ResponseEntity<>(jwtDto, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/signup")
	public ResponseEntity<MessageResponse> registrarUsuario(@Valid @RequestBody RegistroRequest registroRequest){
		if(usuarioRepository.existsByNombreUsuario(registroRequest.getNombre())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: El nombre de usuario ya existe y/o esta utilizado"));
		}
		if(usuarioRepository.existsByEmail(registroRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: El email ya existe y/o esta utilizado"));
		}
		Usuario usuario = new Usuario(registroRequest.getNombre(),
										registroRequest.getApellido(),
										registroRequest.getNombreUsuario(),
										registroRequest.getEmail(),
										registroRequest.getTelefono(),
										passwordEncoder.encode(registroRequest.getPassword()));
		Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByERol(ERol.ROLE_USER).get());
        if(registroRequest.getRoles().contains("admin"))
            roles.add(rolService.getByERol(ERol.ROLE_ADMIN).get());
        usuario.setRoles(roles);

        usuarioService.save(usuario);

        return new ResponseEntity<MessageResponse>(new MessageResponse("Usuario creado"), HttpStatus.CREATED);
	}
	
}

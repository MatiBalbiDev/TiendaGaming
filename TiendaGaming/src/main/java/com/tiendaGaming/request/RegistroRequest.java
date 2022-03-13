package com.tiendaGaming.request;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RegistroRequest {
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String apellido;
	
	private String nombreUsuario;
	
	@NotBlank
	@Email
	private String email;
	
	
	@NotBlank
	private String telefono;
	
	@NotBlank
	private String password;
	
	private Set<String> roles = new HashSet<>();
	
	public RegistroRequest(String nombre, String apellido, String nombreUsuario, String email, String telefono, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
	}
}

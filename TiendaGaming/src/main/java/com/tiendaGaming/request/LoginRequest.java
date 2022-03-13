package com.tiendaGaming.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest {
	
	@NotBlank
	private String nombreUsuario;
	
	@NotBlank
	private String password;
	
	public LoginRequest(String nombreUsuario, String password) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}
}

package com.tiendaGaming.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest {
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String password;
}

package com.tiendaGaming.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class JwtDto {
	
	private String token;
	private String nombreUsuario;
	private String bearer = "Bearer";
	private Collection<? extends GrantedAuthority> privilegios;
	
	
	public JwtDto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> privilegios) {
		this.token = token;
		this.nombreUsuario = nombreUsuario;
		this.privilegios = privilegios;
	}

}

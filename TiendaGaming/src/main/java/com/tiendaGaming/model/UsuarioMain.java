package com.tiendaGaming.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/*Clase encargada de otorgar los privilegios a los usuarios.*/

public class UsuarioMain implements UserDetails{
	
	private String nombre;
	private String apellido;
	private String nombreUsuario;
	private String email;
	private String telefono;
	private String password;
	
	private Collection<? extends GrantedAuthority> privilegios;
	
	public UsuarioMain(String nombre, String apellido, String nombreUsuario, String email, String password, Collection<? extends GrantedAuthority> privilegios) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.privilegios = privilegios;
    }
	
	public static UsuarioMain build(Usuario usuario){
        //Convertimos la clase Rol a la clase GrantedAuthority
        List<GrantedAuthority> authorities =
                usuario.getRoles()
                        .stream()
                        .map(rol -> new SimpleGrantedAuthority(rol.getNombre().name()))
                .collect(Collectors.toList());
        return new UsuarioMain(usuario.getNombre(), usuario.getApellido(), usuario.getNombreUsuario(), usuario.getEmail(),
                usuario.getPassword(), authorities);
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.privilegios;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.nombreUsuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

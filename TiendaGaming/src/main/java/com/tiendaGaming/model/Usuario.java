package com.tiendaGaming.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table (name = "usuario")
public class Usuario implements Serializable{
	
	
	private static final long serialVersionUID = -8004612739750418147L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	private String nombre;
	private String apellido;
	@Column(unique = true)
	private String nombreUsuario;
	@Column(unique = true)
	private String email;
	private String telefono;
	private String password;
	
	 //Crear otra tabla que relacione usuarios con roles y listo.
	@NotNull
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", 
	           joinColumns = @JoinColumn(name = "user_id"),
	           inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Rol> roles = new HashSet<>();
	
	@Transient
	private String confirm_password;
	
	public Usuario() {}
	
	public Usuario(String nombre, String apellido, String nombreUsuario, String email, String telefono, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
	}
	
}

package com.tiendaGaming.model;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table (name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String password;
	
	@OneToMany
	@JoinColumn(name="id_usuario")
	private List<Rol> roles;
	
	@Transient
	private String confirm_password;
	
	public Usuario() {}
	
	public Usuario(String nombre, String apellido, String email, String telefono, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
	}
	
}

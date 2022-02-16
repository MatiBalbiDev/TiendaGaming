package com.tiendaGaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "rol")
public class Rol implements Serializable{
	
	
	private static final long serialVersionUID = -2666618599159380170L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_rol;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private ERol nombre;
	
	public Rol() {}
	
	public Rol(ERol nombre) {
	    this.nombre = nombre;
	}
}

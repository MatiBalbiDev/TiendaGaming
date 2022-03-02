package com.tiendaGaming.Request;

import lombok.Data;

@Data
public class ProductoRequest {
	
	private String nombre;
	private String descripcion;
	private Double precio;
	
	public ProductoRequest() {}

	public ProductoRequest(String nombre, String descripcion, Double precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
	
	

}

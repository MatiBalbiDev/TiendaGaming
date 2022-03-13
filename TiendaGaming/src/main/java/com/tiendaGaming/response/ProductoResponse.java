package com.tiendaGaming.response;

import lombok.Data;

@Data
public class ProductoResponse {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private Double precio;
	
	public ProductoResponse() {}

	public ProductoResponse(Integer id, String nombre, String descripcion, Double precio) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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

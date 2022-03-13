package com.tiendaGaming.request;

public class ProductoPutRequest extends ProductoRequest{
	
	private Integer id;
	
	public ProductoPutRequest() {}

	public ProductoPutRequest(String nombre, String descripcion, Double precio, Integer id) {
		super(nombre, descripcion, precio);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}

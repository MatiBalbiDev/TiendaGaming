package com.tiendaGaming.exceptions;

public class ProductoNotFoundException extends RuntimeException{
	
	ProductoNotFoundException(Integer id){
		super("No se pudo encontrar el producto: " + id);
	}

}

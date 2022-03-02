package com.tiendaGaming.Exceptions;

public class ProductoNotFoundException extends RuntimeException{
	
	ProductoNotFoundException(Integer id){
		super("No se pudo encontrar el producto: " + id);
	}

}

package com.tiendaGaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendaGaming.Exceptions.ProductoNotFoundException;
import com.tiendaGaming.Request.ProductoRequest;
import com.tiendaGaming.Response.ProductoResponse;
import com.tiendaGaming.Service.ProductoService;
import com.tiendaGaming.model.Producto;

@RestController
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	
	@PostMapping("/altaProducto")
	public ResponseEntity<?> altaProducto(@RequestBody ProductoRequest request){
		try {
			ProductoResponse response = productoService.altaProducto(request);
			return new ResponseEntity<ProductoResponse>(response,HttpStatus.OK);
		}catch(ProductoNotFoundException ex) {
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping("/productos")
	public ResponseEntity<?> productos(){
		try {
			List<Producto> productos = productoService.productos();
			return new ResponseEntity<List<Producto>>(productos,HttpStatus.OK);
		}catch(ProductoNotFoundException e){
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

}

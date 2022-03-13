package com.tiendaGaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendaGaming.exceptions.ProductoNotFoundException;
import com.tiendaGaming.model.Producto;
import com.tiendaGaming.request.ProductoPutRequest;
import com.tiendaGaming.request.ProductoRequest;
import com.tiendaGaming.response.ProductoResponse;
import com.tiendaGaming.service.ProductoService;

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
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/productos")
	public ResponseEntity<?> productos(){
		try {
			List<Producto> productos = productoService.productos();
			return new ResponseEntity<List<Producto>>(productos,HttpStatus.OK);
		}catch(ProductoNotFoundException e){
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<?> producto(@PathVariable("id")Integer id){
		try {
			Producto prod = productoService.productoById(id);
			return new ResponseEntity<Producto>(prod, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/putProducto")
	public ResponseEntity<?> putProducto(@RequestBody ProductoPutRequest request){
		try {
			ProductoResponse response = productoService.putProducto(request);
			return new ResponseEntity<ProductoResponse>(response, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@PathVariable("id")Integer id) {
		try {
			productoService.delete(id);
			return new ResponseEntity<String>("Se ha eliminado el producto", HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}

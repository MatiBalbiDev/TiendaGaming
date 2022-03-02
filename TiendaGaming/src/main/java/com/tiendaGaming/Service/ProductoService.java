package com.tiendaGaming.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import com.tiendaGaming.Request.ProductoPutRequest;
import com.tiendaGaming.Request.ProductoRequest;
import com.tiendaGaming.Response.ProductoResponse;
import com.tiendaGaming.model.Producto;
import com.tiendaGaming.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	ProductoRepository productoRepository;
	
	public ProductoResponse altaProducto(ProductoRequest request) {
		Producto producto = new Producto();
		producto.setNombre(request.getNombre());
		producto.setDescripcion(request.getDescripcion());
		producto.setPrecio(request.getPrecio());
		
		Producto respuesta = productoRepository.save(producto);
		
		ProductoResponse response = new ProductoResponse();
		response.setId(respuesta.getId());
		response.setNombre(respuesta.getNombre());
		response.setDescripcion(respuesta.getDescripcion());
		response.setPrecio(respuesta.getPrecio());
		
		return response;
	}
	
	public List<Producto> productos(){
		List<Producto> productos = new ArrayList<>();
		productos = productoRepository.findAll();
		return productos;
	}
	
	
	public Producto productoById(Integer id) {
		return productoRepository.findById(id).get();
	}
	
	public ProductoResponse putProducto(ProductoPutRequest request) {
		Producto prod = productoById(request.getId());
		
		if(request.getNombre() != null && !request.getNombre().isEmpty()) {
			prod.setNombre(prod.getNombre());
		}
		if(request.getPrecio() != null) {
			prod.setPrecio(prod.getPrecio());
		}
		if(request.getDescripcion() != null && !request.getDescripcion().isEmpty()) {
			prod.setDescripcion(prod.getDescripcion());
		}
		
		Producto respuesta = productoRepository.save(prod);
		
		ProductoResponse response = new ProductoResponse();
		response.setId(respuesta.getId());
		response.setNombre(respuesta.getNombre());
		response.setPrecio(respuesta.getPrecio());
		response.setDescripcion(respuesta.getDescripcion());
		
		return response;
	}
	
	public void delete(Integer id) {
		if(productoRepository.existsById(id)) {
			productoRepository.deleteById(id);
		}
		else {
			throw new RuntimeException("no se encontro el producto");
		}
	}
	
}

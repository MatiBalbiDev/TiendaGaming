package com.tiendaGaming.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

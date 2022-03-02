package com.tiendaGaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiendaGaming.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}

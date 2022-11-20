package com.upc.repository;

import org.springframework.data.repository.CrudRepository;
import com.upc.model.Producto;
public interface ProductoRepository extends CrudRepository<Producto, Integer>{

}

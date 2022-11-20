package com.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.model.Producto;
import com.upc.repository.ProductoRepository;
import com.upc.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired//Notación correspondiente
    private ProductoRepository productoRepository;

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void updateProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public Producto getProducto(int CProducto) {
        Optional<Producto> optional = productoRepository.findById(CProducto);
        Producto producto = optional.get();
        return producto;
    }

    @Override
    public List<Producto> getProductos() {
        return (List<Producto>)productoRepository.findAll();
    }

    @Override
    public void deleteProducto(int CProducto) {
        productoRepository.deleteById(CProducto);
    }

    @Override
    public boolean isProductoExist(int CProducto) {
        return productoRepository.existsById(CProducto);
    }
}

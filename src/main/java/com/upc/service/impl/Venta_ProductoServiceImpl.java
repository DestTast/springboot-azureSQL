package com.upc.service.impl;


import com.upc.model.Venta_Producto;
import com.upc.repository.Venta_ProductoRepository;
import com.upc.service.Venta_ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Venta_ProductoServiceImpl implements Venta_ProductoService{
    @Autowired//Notación correspondiente
    private Venta_ProductoRepository venta_productoRepository;
    @Override
    public Venta_Producto createVenta_Producto(Venta_Producto venta_producto) {
        return venta_productoRepository.save(venta_producto);
    }

    @Override
    public void updateVenta_Producto(Venta_Producto venta_producto) {
        venta_productoRepository.save(venta_producto);
    }

    @Override
    public Venta_Producto getVenta_Producto(int CVenta_Producto) {
        Optional<Venta_Producto> optional = venta_productoRepository.findById(CVenta_Producto);
        Venta_Producto venta_producto = optional.get();
        return venta_producto;
    }

    @Override
    public List<Venta_Producto> getVenta_Productos() {
        return (List<Venta_Producto>)venta_productoRepository.findAll();
    }

    @Override
    public void deleteVenta_Producto(int CVenta_Producto) {
        venta_productoRepository.deleteById(CVenta_Producto);
    }

    @Override
    public boolean isVenta_ProductoExist(int CVenta_Producto) {
        return venta_productoRepository.existsById(CVenta_Producto);
    }
}

package com.upc.service.impl;


import com.upc.model.Tipo_Producto;

import com.upc.repository.Tipo_ProductoRepository;
import com.upc.service.Tipo_ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Tipo_ProductoServiceImpl implements Tipo_ProductoService {
    @Autowired//Notación correspondiente
    private Tipo_ProductoRepository Tipo_ProductoRepository;
    @Override
    public Tipo_Producto createTipo_Producto(Tipo_Producto Tipo_Producto) {
        return Tipo_ProductoRepository.save(Tipo_Producto);
    }

    @Override
    public void updateTipo_Producto(Tipo_Producto Tipo_Producto) {
        Tipo_ProductoRepository.save(Tipo_Producto);
    }

    @Override
    public Tipo_Producto getTipo_Producto(Integer CTipo_Producto) {
        Optional<Tipo_Producto> optional = Tipo_ProductoRepository.findById(CTipo_Producto);
        Tipo_Producto Tipo_Producto = optional.get();
        return Tipo_Producto;
    }

    @Override
    public List<Tipo_Producto> getTipo_Productos() {
        return (List<Tipo_Producto>)Tipo_ProductoRepository.findAll();
    }

    @Override
    public void deleteTipo_Producto(Integer CTipo_Producto) {
        Tipo_ProductoRepository.deleteById(CTipo_Producto);
    }

    @Override
    public boolean isTipo_ProductoExist(Integer CTipo_Producto) {
        return Tipo_ProductoRepository.existsById(CTipo_Producto);
    }
}

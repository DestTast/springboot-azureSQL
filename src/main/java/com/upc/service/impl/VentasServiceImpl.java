package com.upc.service.impl;


import com.upc.model.Ventas;
import com.upc.repository.VentasRepository;
import com.upc.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentasServiceImpl implements VentasService{
    @Autowired//Notación correspondiente
    private VentasRepository ventasRepository;
    @Override
    public Ventas createVentas(Ventas ventas) {
        return ventasRepository.save(ventas);
    }

    @Override
    public void updateVentas(Ventas ventas) {
        ventasRepository.save(ventas);
    }

    @Override
    public Ventas getVentas(int CVenta) {
        Optional<Ventas> optional = ventasRepository.findById(CVenta);
        Ventas ventas = optional.get();
        return ventas;
    }

    @Override
    public List<Ventas> getVentass() {
        return (List<Ventas>)ventasRepository.findAll();
    }

    @Override
    public void deleteVentas(int CVenta) {
        ventasRepository.deleteById(CVenta);
    }

    @Override
    public boolean isVentasExist(int CVenta) {
        return ventasRepository.existsById(CVenta);
    }
}

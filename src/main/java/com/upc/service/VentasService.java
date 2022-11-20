package com.upc.service;

import com.upc.model.Ventas;

import java.util.List;

public interface VentasService {

    public abstract Ventas createVentas(Ventas ventas);

    public abstract void updateVentas(Ventas ventas);

    public abstract Ventas getVentas(int id);

    public abstract List<Ventas> getVentass();

    public abstract void deleteVentas(int id);

    public abstract boolean isVentasExist(int id);
}

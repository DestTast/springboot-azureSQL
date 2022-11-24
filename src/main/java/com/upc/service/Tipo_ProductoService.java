package com.upc.service;

import com.upc.model.Tipo_Producto;

import java.util.List;

public interface Tipo_ProductoService {

    public abstract Tipo_Producto createTipo_Producto(Tipo_Producto Tipo_Producto);

    public abstract void updateTipo_Producto(Tipo_Producto Tipo_Producto);

    public abstract Tipo_Producto getTipo_Producto(Integer CTipo_Producto);

    public abstract List<Tipo_Producto> getTipo_Productos();

    public abstract void deleteTipo_Producto(Integer CTipo_Producto);

    public abstract boolean isTipo_ProductoExist(Integer CTipo_Producto);
}

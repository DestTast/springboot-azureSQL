package com.upc.service;

import com.upc.model.Venta_Producto;

import java.util.List;

public interface Venta_ProductoService {

    public abstract Venta_Producto createVenta_Producto(Venta_Producto venta_producto);

    public abstract void updateVenta_Producto(Venta_Producto venta_producto);

    public abstract Venta_Producto getVenta_Producto(int CVenta_Producto);

    public abstract List<Venta_Producto> getVenta_Productos();

    public abstract void deleteVenta_Producto(int CVenta_Producto);

    public abstract boolean isVenta_ProductoExist(int CVenta_Producto);
}

package com.upc.service;

import java.util.List;
import com.upc.model.Producto;

public interface ProductoService {

    public abstract Producto createProducto(Producto producto);

    public abstract void updateProducto(Producto producto);

    public abstract Producto getProducto(int CProducto);

    public abstract List<Producto> getProductos();

    public abstract void deleteProducto(int CProducto);

    public abstract boolean isProductoExist(int CProducto);
}

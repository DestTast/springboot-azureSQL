package com.upc.model;

import javax.persistence.*;

@Entity
public class Venta_Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CVENTA_PRODUCTO", nullable = false)
    private Integer CVenta_Producto;

    @Column(name = "CPRODUCTO", nullable = false)
    private Integer CProducto;

    @Column(name = "CVENTA", nullable = false)
    private Integer CVenta;


    @Column(name = "QCANTIDAD")
    private Integer QCantidad;


    public Integer getCVenta_Producto() {
        return CVenta_Producto;
    }

    public void setCVenta_Producto(Integer CVenta_Producto) {
        this.CVenta_Producto = CVenta_Producto;
    }

    public Integer getCProducto() {
        return CProducto;
    }

    public void setCProducto(Integer CProducto) {
        this.CProducto = CProducto;
    }

    public Integer getCVenta() {
        return CVenta;
    }

    public void setCVenta(Integer CVenta) {
        this.CVenta = CVenta;
    }

    public Integer getQCantidad() {
        return QCantidad;
    }

    public void setQCantidad(Integer QCantidad) {
        this.QCantidad = QCantidad;
    }

    @Override
    public String toString()
    {
        return "Producto [CProducto=" + CProducto + ", QCantidad=" + QCantidad + ", QCantidad="
        + QCantidad + "]";
    }


}

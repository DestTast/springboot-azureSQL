package com.upc.model;

import javax.persistence.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CPRODUCTO", nullable = false )
    private Integer CProducto;

    @Column(name = "NPRODUCTO", nullable = false, length = 50)
    private String NProducto;


    @Column(name = "CTIPO_PRODUCTO", nullable = false)
    private Integer CTipo_Producto;

    @Column(name = "NTIPO_PRODUCTO", nullable = false, length = 50)
    private String NTipo_Producto;

    @Column(name = "MPRECIO", nullable = false)
    private Integer MPrecio;

    public Integer getCProducto() {
        return CProducto;
    }

    public void setCProducto(Integer CProducto) {
        this.CProducto = CProducto;
    }

    public String getNProducto() {
        return NProducto;
    }

    public void setNProducto(String NProducto) {
        this.NProducto = NProducto;
    }

    public Integer getCTipo_Producto() {
        return CTipo_Producto;
    }

    public void setCTipo_Producto(Integer CTipo_Producto) {
        this.CTipo_Producto = CTipo_Producto;
    }

    public String getNTipo_Producto() {
        return NTipo_Producto;
    }

    public void setNTipo_Producto(String NTipo_Producto) {
        this.NTipo_Producto = NTipo_Producto;
    }

    public Integer getMPrecio() {
        return MPrecio;
    }

    public void setMPrecio(Integer MPrecio) {
        this.MPrecio = MPrecio;
    }




    @Override
    public String toString()
    {
        return "Producto [CProducto=" + CProducto + ", NProducto=" + NProducto + ", CTipo_Producto="
                + CTipo_Producto + ", NTipo_Producto=" + NTipo_Producto +", MPrecio"+ MPrecio
                + "]";
    }


}

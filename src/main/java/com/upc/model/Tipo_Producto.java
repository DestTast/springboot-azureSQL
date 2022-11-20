package com.upc.model;

import javax.persistence.*;

@Entity
public class Tipo_Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CTipo_Producto" )
    private Number CTipo_Producto;

    @Column(name = "NTipo_Producto")
    private String NTipo_Producto;


    public Number getCTipo_Producto() {
        return CTipo_Producto;
    }

    public void setCTipo_Producto(Number CTipo_Producto) {
        this.CTipo_Producto = CTipo_Producto;
    }

    public String getNTipo_Producto() {
        return NTipo_Producto;
    }

    public void setNTipo_Producto(String NTipo_Producto) {
        this.NTipo_Producto = NTipo_Producto;
    }

    @Override
    public String toString()
    {
        return "Tipo_Producto [CTipo_Producto=" + CTipo_Producto +
                ", NTipo_Producto=" + NTipo_Producto + "]";
    }


}

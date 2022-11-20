package com.upc.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CVENTA", nullable = false )
    private Integer CVenta;

    @Column(name = "CEMPLEADO", nullable = false)
    private Integer CEmpleado;


    @Column(name = "DFECHA",nullable = false)
    private Date DFecha;

    @Column(name = "MMonto",nullable = false)
    private Double MMonto;


    public Integer getCVenta() {
        return CVenta;
    }

    public void setCVenta(Integer CVenta) {
        this.CVenta = CVenta;
    }

    public Integer getCEmpleado() {
        return CEmpleado;
    }

    public void setCEmpleado(Integer CEmpleado) {
        this.CEmpleado = CEmpleado;
    }

    public Date getDFecha() {
        return DFecha;
    }

    public void setDFecha(Date DFecha) {
        this.DFecha = DFecha;
    }

    public Double getMMonto() {
        return MMonto;
    }

    public void setMMonto(Double MMonto) {
        this.MMonto = MMonto;
    }

    @Override
    public String toString()
    {
        return "Ventas [CVenta =" + CVenta + ", CEmpleado=" + CEmpleado + ", DFecha="
                + DFecha + ", MMonto=" + MMonto  + "]";
    }


}

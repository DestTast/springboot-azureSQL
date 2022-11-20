package com.upc.model;

import javax.persistence.*;

@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CEMPLEADO", nullable = false )
    private Integer CEmpleado;

    public Integer getCEmpleado() {
        return CEmpleado;
    }

    public void setCEmpleado(Integer CEmpleado) {
        this.CEmpleado = CEmpleado;
    }

    @Override
    public String toString()
    {
        return "Empleado [CEmpleado=" + CEmpleado + "]";
    }


}

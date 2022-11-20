package com.upc.model;

import javax.persistence.*;

@Entity
public class Gerente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CGERENTE", nullable = false )
    private Integer CGerente;


    public Integer getCGerente() {
        return CGerente;
    }

    public void setCGerente(Integer CGerente) {
        this.CGerente = CGerente;
    }

    @Override
    public String toString()
    {
        return "Producto [CGerente=" + CGerente + "]";
    }


}

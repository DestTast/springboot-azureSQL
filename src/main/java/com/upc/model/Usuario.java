
package com.upc.model;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSUARIO", nullable = false )
    private Integer CUsuario;

    @Column(name = "NUSUARIO", nullable = false, length = 100)
    private String NUsuario;


    @Column(name = "TCONTRASENA", nullable = false, length = 100)
    private Integer TContrasena;


    public Integer getCUsuario() {
        return CUsuario;
    }

    public void setCUsuario(Integer CUsuario) {
        this.CUsuario = CUsuario;
    }

    public String getNUsuario() {
        return NUsuario;
    }

    public void setNUsuario(String NUsuario) {
        this.NUsuario = NUsuario;
    }

    public Integer getTContrasena() {
        return TContrasena;
    }

    public void setTContrasena(Integer TContrasena) {
        this.TContrasena = TContrasena;
    }

    @Override
    public String toString()
    {
        return "Usuario [CUsuario=" + CUsuario + ", TContrasena="
            + TContrasena + ", NUsuario=" + NUsuario  + "]";
    }


}

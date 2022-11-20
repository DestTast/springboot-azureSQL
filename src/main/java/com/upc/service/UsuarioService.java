package com.upc.service;

import com.upc.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public abstract Usuario createUsuario(Usuario usuario);

    public abstract void updateUsuario(Usuario usuario);

    public abstract Usuario getUsuario(int CUsuario);

    public abstract List<Usuario> getUsuarios();

    public abstract void deleteUsuario(int CUsuario);

    public abstract boolean isUsuarioExist(int CUsuario);
}

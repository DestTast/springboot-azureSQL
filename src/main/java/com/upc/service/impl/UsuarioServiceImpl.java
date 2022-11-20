package com.upc.service.impl;


import com.upc.model.Usuario;
import com.upc.repository.UsuarioRepository;
import com.upc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired//Notación correspondiente
    private UsuarioRepository usuarioRepository;
    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getUsuario(int CUsuario) {
        Optional<Usuario> optional = usuarioRepository.findById(CUsuario);
        Usuario usuario = optional.get();
        return usuario;
    }

    @Override
    public List<Usuario> getUsuarios() {
        return (List<Usuario>)usuarioRepository.findAll();
    }

    @Override
    public void deleteUsuario(int CUsuario) {
        usuarioRepository.deleteById(CUsuario);
    }

    @Override
    public boolean isUsuarioExist(int CUsuario) {
        return usuarioRepository.existsById(CUsuario);
    }
}

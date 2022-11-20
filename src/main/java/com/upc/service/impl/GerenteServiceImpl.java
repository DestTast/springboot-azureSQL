package com.upc.service.impl;


import com.upc.model.Gerente;
import com.upc.repository.GerenteRepository;
import com.upc.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GerenteServiceImpl implements GerenteService{
    @Autowired//Notación correspondiente
    private GerenteRepository gerenteRepository;
    @Override
    public Gerente createGerente(Gerente gerente) {
        return gerenteRepository.save(gerente);
    }

    @Override
    public void updateGerente(Gerente gerente) {
        gerenteRepository.save(gerente);
    }

    @Override
    public Gerente getGerente(int CGerente) {
        Optional<Gerente> optional = gerenteRepository.findById(CGerente);
        Gerente gerente = optional.get();
        return gerente;
    }

    @Override
    public List<Gerente> getGerentes() {
        return (List<Gerente>)gerenteRepository.findAll();
    }

    @Override
    public void deleteGerente(int CGerente) {
        gerenteRepository.deleteById(CGerente);
    }

    @Override
    public boolean isGerenteExist(int CGerente) {
        return gerenteRepository.existsById(CGerente);
    }
}

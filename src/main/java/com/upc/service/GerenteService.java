package com.upc.service;

import com.upc.model.Gerente;

import java.util.List;

public interface GerenteService {

    public abstract Gerente createGerente(Gerente gerente);

    public abstract void updateGerente(Gerente gerente);

    public abstract Gerente getGerente(int CGerente);

    public abstract List<Gerente> getGerentes();

    public abstract void deleteGerente(int CGerente);

    public abstract boolean isGerenteExist(int CGerente);
}

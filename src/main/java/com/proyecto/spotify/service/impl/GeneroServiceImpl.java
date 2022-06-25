package com.proyecto.spotify.service.impl;

import com.proyecto.spotify.model.Genero;
import com.proyecto.spotify.repository.GeneroRepository;
import com.proyecto.spotify.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public List<Genero> findAll() {
        return generoRepository.findAll();
    }

    @Override
    public Genero findById(Integer id) {
        Optional<Genero> genero = generoRepository.findById(id);
        return genero.isPresent() ? genero.get() : new Genero();
    }

    @Override
    public List<Genero> findAllByName(String nombre) {
        return generoRepository.findAllByNombre(nombre);
    }

    @Override
    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    public Genero update(Genero genero, Integer id) {
        return save(genero);
    }

    @Override
    public boolean deleteById(Integer id) {
        generoRepository.deleteById(id);
        return true;
    }

}

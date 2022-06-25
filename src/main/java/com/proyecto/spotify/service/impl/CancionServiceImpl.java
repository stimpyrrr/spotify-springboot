package com.proyecto.spotify.service.impl;

import com.proyecto.spotify.model.Cancion;
import com.proyecto.spotify.repository.CancionRepository;
import com.proyecto.spotify.service.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CancionServiceImpl implements CancionService {

    @Autowired
    private CancionRepository cancionRepository;

    @Override
    public List<Cancion> findAll() {
        return cancionRepository.findAll();
    }

    @Override
    public Cancion findById(Integer id) {
        Optional<Cancion> cancion = cancionRepository.findById(id);
        return cancion.isPresent() ? cancion.get() : new Cancion();
    }

    @Override
    public Cancion save(Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    @Override
    public Cancion update(Cancion cancion, Integer id) {
        return save(cancion);
    }

    @Override
    public boolean deleteById(Integer id) {
        cancionRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Cancion> findAllByName(String nombre) {
        return cancionRepository.findAllByNombre(nombre);
    }
}

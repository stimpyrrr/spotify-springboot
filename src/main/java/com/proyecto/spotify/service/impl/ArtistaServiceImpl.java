package com.proyecto.spotify.service.impl;

import com.proyecto.spotify.exception.ModeloNotFoundException;
import com.proyecto.spotify.model.Artista;
import com.proyecto.spotify.repository.ArtistaRepository;
import com.proyecto.spotify.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaServiceImpl implements ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    @Override
    public List<Artista> findAll() {
        return artistaRepository.findAll();
    }

    @Override
    public Artista findById(Integer id) {
        Optional<Artista> artista = artistaRepository.findById(id);
        if (artista.isPresent()){
            return artista.get();
        }else{
            throw new ModeloNotFoundException("Error al encontrar Artista");
        }
        //return artista.isPresent() ? artista.get() : new Artista();
    }

    @Override
    public Artista save(Artista artista) {
        return artistaRepository.save(artista);
    }

    @Override
    public Artista update(Artista artista, Integer id) {
        return save(artista);
    }

    @Override
    public boolean deleteById(Integer id) {
        artistaRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Artista> findAllByName(String nombre) {
        return artistaRepository.findAllByNombre(nombre);
    }
}

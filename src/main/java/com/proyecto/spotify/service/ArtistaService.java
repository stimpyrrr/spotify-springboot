package com.proyecto.spotify.service;

import com.proyecto.spotify.model.Artista;

import java.util.List;

public interface ArtistaService extends ICRUD<Artista>{
    List<Artista> findAllByName(String nombre);
}

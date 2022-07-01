package com.proyecto.spotify.service;

import com.proyecto.spotify.model.Artista;
import com.proyecto.spotify.model.Cancion;
import com.proyecto.spotify.model.Playlist;

import java.util.List;

public interface CancionService extends ICRUD<Cancion>{
    List<Cancion> findAllByName(String nombre);

    Cancion leerPorId(Integer id);
}

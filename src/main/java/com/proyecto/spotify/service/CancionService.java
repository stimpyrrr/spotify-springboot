package com.proyecto.spotify.service;

import com.proyecto.spotify.model.Cancion;

import java.util.List;

public interface CancionService extends ICRUD<Cancion>{
    List<Cancion> findAllByName(String nombre);
}

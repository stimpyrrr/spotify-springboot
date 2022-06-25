package com.proyecto.spotify.service;

import com.proyecto.spotify.model.Genero;

import java.util.List;

public interface GeneroService extends ICRUD<Genero>{
    List<Genero> findAllByName(String nombre);
}

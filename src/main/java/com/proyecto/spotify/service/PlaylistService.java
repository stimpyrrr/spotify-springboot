package com.proyecto.spotify.service;

import com.proyecto.spotify.model.Playlist;

import java.util.List;

public interface PlaylistService extends ICRUD<Playlist>{
    List<Playlist> findAllByName(String nombre);
    Playlist leerPorId(Integer id);
}

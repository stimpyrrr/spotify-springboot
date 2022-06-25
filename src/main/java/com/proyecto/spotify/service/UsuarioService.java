package com.proyecto.spotify.service;

import com.proyecto.spotify.model.Usuario;

import java.util.List;

public interface UsuarioService extends ICRUD<Usuario>{
    List<Usuario> findAllByName(String nombre);
}

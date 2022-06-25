package com.proyecto.spotify.repository;

import com.proyecto.spotify.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
    List<Artista> findAllByNombre(String nombre);
}

package com.proyecto.spotify.repository;

import com.proyecto.spotify.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CancionRepository extends JpaRepository<Cancion, Integer> {
    List<Cancion> findAllByNombre(String nombre);
}

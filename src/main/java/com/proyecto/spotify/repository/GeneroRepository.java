package com.proyecto.spotify.repository;

import com.proyecto.spotify.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {
    List<Genero> findAllByNombre(String nombre);
}

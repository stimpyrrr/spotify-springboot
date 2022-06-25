package com.proyecto.spotify.repository;

import com.proyecto.spotify.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
    List<Playlist> findAllByNombre(String nombre);
}

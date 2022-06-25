package com.proyecto.spotify.repository;

import com.proyecto.spotify.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findAllByNombre(String nombre);
}

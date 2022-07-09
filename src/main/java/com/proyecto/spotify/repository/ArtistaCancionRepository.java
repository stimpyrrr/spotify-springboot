package com.proyecto.spotify.repository;

import com.proyecto.spotify.model.ArtistaCancion;
import com.proyecto.spotify.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArtistaCancionRepository extends JpaRepository<ArtistaCancion, Integer> {

    @Modifying
    @Query(value = "INSERT INTO artista_cancion(id_artista, id_cancion) VALUES(:idArtista, :idCancion)", nativeQuery = true)
    Integer registrar(@Param("idArtista") Integer idArtista, @Param("idCancion") Integer idCancion);
}

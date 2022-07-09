package com.proyecto.spotify.dto;

import com.proyecto.spotify.model.Cancion;
import org.springframework.hateoas.ResourceSupport;

public class ArtistaDTO extends ResourceSupport {

    private Integer idArtista;

    private Cancion cancion;

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }
}

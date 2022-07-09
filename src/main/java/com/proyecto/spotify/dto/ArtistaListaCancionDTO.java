package com.proyecto.spotify.dto;

import com.proyecto.spotify.model.Artista;
import com.proyecto.spotify.model.Cancion;

import java.util.List;

public class ArtistaListaCancionDTO {

    private Artista artista;

    private List<Cancion> lstCancion;

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public List<Cancion> getLstCancion() {
        return lstCancion;
    }

    public void setLstCancion(List<Cancion> lstCancion) {
        this.lstCancion = lstCancion;
    }
}

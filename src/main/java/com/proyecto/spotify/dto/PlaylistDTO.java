package com.proyecto.spotify.dto;

import com.proyecto.spotify.model.Artista;
import com.proyecto.spotify.model.Cancion;
import org.springframework.hateoas.ResourceSupport;

public class PlaylistDTO extends ResourceSupport {

    private Integer idPlaylist;
    private Artista artista;
    private Cancion cancion;

    public Integer getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(Integer idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }
}

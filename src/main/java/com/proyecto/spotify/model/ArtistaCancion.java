package com.proyecto.spotify.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "artista_cancion")
@IdClass(ArtistaCancionPK.class)
public class ArtistaCancion {

    @Id
    private Artista artista;

    @Id
    private Cancion cancion;

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

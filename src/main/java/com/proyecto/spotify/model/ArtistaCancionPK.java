package com.proyecto.spotify.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ArtistaCancionPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_cancion", nullable = false)
    private Cancion cancion;

    @ManyToOne
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;
}

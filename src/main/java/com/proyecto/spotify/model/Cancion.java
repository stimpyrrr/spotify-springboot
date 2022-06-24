package com.proyecto.spotify.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cancion")
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCancion;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany
    @JoinTable(name = "cancion_playlist", joinColumns = @JoinColumn(name = "id_cancion", referencedColumnName = "idCancion"),
            inverseJoinColumns = @JoinColumn(name = "id_playlist", referencedColumnName = "idPlaylist"))
    private List<Playlist> playlists;

    @ManyToMany
    @JoinTable(name = "cancion_genero", joinColumns = @JoinColumn(name = "id_cancion", referencedColumnName = "idCancion"),
            inverseJoinColumns = @JoinColumn(name = "id_genero", referencedColumnName = "idGenero"))
    private List<Genero> generos;

    public Integer getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

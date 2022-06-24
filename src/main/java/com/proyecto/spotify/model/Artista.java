package com.proyecto.spotify.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "artista")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArtista;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private Boolean estado;

    @ManyToMany
    @JoinTable(name = "artista_cancion", joinColumns = @JoinColumn(name = "id_artista", referencedColumnName = "idArtista"),
                inverseJoinColumns = @JoinColumn(name = "id_cancion", referencedColumnName = "idCancion"))
    private List<Cancion> canciones;

    @ManyToMany
    @JoinTable(name = "artista_genero", joinColumns = @JoinColumn(name = "id_artista", referencedColumnName = "idArtista"),
            inverseJoinColumns = @JoinColumn(name = "id_genero", referencedColumnName = "idGenero"))
    private List<Genero> generos;

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}

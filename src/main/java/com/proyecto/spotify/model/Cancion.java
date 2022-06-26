package com.proyecto.spotify.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@ApiModel(description = "Información o propiedes de canción")
@Entity
@Table(name = "cancion")
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCancion;

    @ApiModelProperty(notes = "Nombre dene tener como minimo 3 caracteres y máximo 50")
    @Size(min = 3, max = 50, message = "El nombre no cumple con los valores especificados")
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

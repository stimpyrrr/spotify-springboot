package com.proyecto.spotify.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@ApiModel(description = "Información o propiedes del artista")
@Entity
@Table(name = "artista")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArtista;

    @ApiModelProperty(notes = "Nombre dene tener como minimo 3 caracteres y máximo 50")
    @Size(min = 3, max = 50, message = "El nombre no cumple con los valores especificados")
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

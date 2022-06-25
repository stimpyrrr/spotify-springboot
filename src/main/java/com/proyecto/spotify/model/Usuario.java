package com.proyecto.spotify.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Size(min = 4, max = 50, message = "El nombre es muy extenso")
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "clave")
    private String clave;

    @Column(name = "estado")
    private Boolean estado;

    @OneToOne
    @JoinColumn(name = "id_plan", nullable = false, foreignKey = @ForeignKey(name = "FK_usuario_plan"))
    private Plan plan;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}

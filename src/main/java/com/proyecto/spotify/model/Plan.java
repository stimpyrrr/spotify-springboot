package com.proyecto.spotify.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlan;

    @Size(min = 4, max = 50, message = "El nombre es muy extenso")
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Float precio;

    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}

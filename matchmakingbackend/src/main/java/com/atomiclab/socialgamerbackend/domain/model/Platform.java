package com.atomiclab.socialgamerbackend.domain.model;

import javax.persistence.Entity;

@Entity
public class Platform {
    private String nombre;
    private String imagen;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}

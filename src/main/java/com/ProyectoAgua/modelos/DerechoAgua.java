package com.ProyectoAgua.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "derechoAguas")
public class DerechoAgua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "El pasaje es requerido")
    private String pasaje;

    @NotBlank(message = "La casa es requerida")
    private String casa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre es requerido") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre es requerido") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "El pasaje es requerido") String getPasaje() {
        return pasaje;
    }

    public void setPasaje(@NotBlank(message = "El pasaje es requerido") String pasaje) {
        this.pasaje = pasaje;
    }

    public @NotBlank(message = "La casa es requerida") String getCasa() {
        return casa;
    }

    public void setCasa(@NotBlank(message = "La casa es requerida") String casa) {
        this.casa = casa;
    }
}

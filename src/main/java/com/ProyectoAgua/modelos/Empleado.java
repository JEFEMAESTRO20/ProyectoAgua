package com.ProyectoAgua.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "El nombre es requerido")
    private String direccion;

    @NotNull
    private LocalDateTime Entrada;

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

    public @NotBlank(message = "El nombre es requerido") String getDireccion() {
        return direccion;
    }

    public void setDireccion(@NotBlank(message = "El nombre es requerido") String direccion) {
        this.direccion = direccion;
    }

    public @NotNull LocalDateTime getEntrada() {
        return Entrada;
    }

    public void setEntrada(@NotNull LocalDateTime entrada) {
        Entrada = entrada;
    }
}

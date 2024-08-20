/*package com.ProyectoAgua.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "El apellido es requerido")
    private String apellido;

    @NotBlank(message = "El login es requerido")
    private String login;

    @NotBlank(message = "La clave es requerida")
    private String clave;

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

    public @NotBlank(message = "El apellido es requerido") String getApellido() {
        return apellido;
    }

    public void setApellido(@NotBlank(message = "El apellido es requerido") String apellido) {
        this.apellido = apellido;
    }

    public @NotBlank(message = "El login es requerido") String getLogin() {
        return login;
    }

    public void setLogin(@NotBlank(message = "El login es requerido") String login) {
        this.login = login;
    }

    public @NotBlank(message = "La clave es requerida") String getClave() {
        return clave;
    }

    public void setClave(@NotBlank(message = "La clave es requerida") String clave) {
        this.clave = clave;
    }
} */
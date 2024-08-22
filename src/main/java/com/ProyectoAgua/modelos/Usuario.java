package com.ProyectoAgua.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table (name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotBlank(message = "El Nombre es requerido")
    private String Nombre;

    @NotBlank(message = "El Apellido es requerido")
    private String Apellido;

    @NotBlank(message = "El Usuario es requerido")
    private String Usuario;

    @NotBlank(message = "El Password es requerido")
    private String Pass;

    @ManyToOne
    @JoinColumn(name="Id_Rol")
    private Rol rol;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public @NotBlank(message = "El nombre es requerido") String getNombre() {
        return Nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre es requerido") String nombre) {
        Nombre = nombre;
    }

    public @NotBlank(message = "El Apellido es requerido") String getApellido() {
        return Apellido;
    }

    public void setApellido(@NotBlank(message = "El Apellido es requerido") String apellido) {
        Apellido = apellido;
    }

    public @NotBlank(message = "El Usuario es requerido") String getUsuario() {
        return Usuario;
    }

    public void setUsuario(@NotBlank(message = "El Usuario es requerido") String usuario) {
        Usuario = usuario;
    }

    public @NotBlank(message = "El Password es requerido") String getPass() {
        return Pass;
    }

    public void setPass(@NotBlank(message = "El Password es requerido") String pass) {
        Pass = pass;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}

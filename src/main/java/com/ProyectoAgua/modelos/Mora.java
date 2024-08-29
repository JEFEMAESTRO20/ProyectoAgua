package com.ProyectoAgua.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "moras")
public class Mora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "La CantidadMecha es requerida")
    private String mora;

    @ManyToOne
    @JoinColumn(name = "id_derechoAgua")
    private DerechoAgua derechoAgua;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "La CantidadMecha es requerida") String getMora() {
        return mora;
    }

    public void setMora(@NotBlank(message = "La CantidadMecha es requerida") String mora) {
        this.mora = mora;
    }

    public DerechoAgua getDerechoAgua() {
        return derechoAgua;
    }

    public void setDerechoAgua(DerechoAgua derechoAgua) {
        this.derechoAgua = derechoAgua;
    }
}

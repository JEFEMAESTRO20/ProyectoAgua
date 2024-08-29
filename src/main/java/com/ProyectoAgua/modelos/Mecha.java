package com.ProyectoAgua.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "mechas")
public class Mecha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "La CantidadMecha es requerida")
    private String cantidadMecha;

    @ManyToOne
    @JoinColumn(name = "id_derechoAgua")
    private DerechoAgua derechoAgua;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "La CantidadMecha es requerida") String getCantidadMecha() {
        return cantidadMecha;
    }

    public void setCantidadMecha(@NotBlank(message = "La CantidadMecha es requerida") String cantidadMecha) {
        this.cantidadMecha = cantidadMecha;
    }

    public DerechoAgua getDerechoAgua() {
        return derechoAgua;
    }

    public void setDerechoAgua(DerechoAgua derechoAgua) {
        this.derechoAgua = derechoAgua;
    }
}

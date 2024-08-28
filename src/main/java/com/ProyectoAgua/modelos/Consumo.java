package com.ProyectoAgua.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "consumos")
public class Consumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El consumo es requerido")
    private String consumo;

    @ManyToOne
    @JoinColumn(name = "idDerechoAgua", nullable = false)
    private DerechoAgua derechoAgua;

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public DerechoAgua getDerechoAgua() {
        return derechoAgua;
    }

    public void setDerechoAgua(DerechoAgua derechoAgua) {
        this.derechoAgua = derechoAgua;
    }

    public void setDerechoAguas(List<DerechoAgua> derechoAgua) {
    }
}

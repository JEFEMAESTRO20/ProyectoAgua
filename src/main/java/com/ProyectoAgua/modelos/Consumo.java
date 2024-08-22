package com.ProyectoAgua.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table (name = "consumos")
public class Consumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El id Derecho Agua es requerido")
    private String idDerechoAgua;

    @NotBlank(message = "El consumo es requerido")
    private String consumo;

    @OneToMany(mappedBy = "consumo")
    private List<DerechoAgua> derechoAguas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "El id es requerido") String getIdDerechoAgua() {
        return idDerechoAgua;
    }

    public void setIdDerechoAgua(@NotBlank(message = "El id es requerido") String idDerechoAgua)
    {
        this.idDerechoAgua = idDerechoAgua;
    }

    public @NotBlank(message = "El consumo es requerido") String getConsumo() {
        return consumo;
    }

    public void setConsumo(@NotBlank(message = "El consumo es requerido") String consumo)
    {
        this.consumo = consumo;
    }

    public List<DerechoAgua> getDerechoAguas() {
        return derechoAguas;
    }

    public void setDerechoAguas(List<DerechoAgua> derechoAguas) {
        this.derechoAguas = derechoAguas;
    }
}

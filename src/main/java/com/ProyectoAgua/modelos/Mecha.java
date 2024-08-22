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

    @NotBlank(message = "El id derecho agua es requerido")
    private String idDerechoAgua;

    @NotBlank(message = "La CantidadMecha es requerida")
    private String cantidadMecha;

    @OneToMany(mappedBy = "mecha")
    private List<DerechoAgua> derechoAguas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "El id derecho agua es requerido") String getIdDerechoAgua() {
        return idDerechoAgua;
    }

    public void setIdDerechoAgua(@NotBlank(message = "El id derecho agua es requerido") String idDerechoAgua) {
        this.idDerechoAgua = idDerechoAgua;
    }

    public @NotBlank(message = "La CantidadMecha es requerida") String getCantidadMecha() {
        return cantidadMecha;
    }

    public void setCantidadMecha(@NotBlank(message = "La CantidadMecha es requerida") String cantidadMecha) {
        this.cantidadMecha = cantidadMecha;
    }

    public List<DerechoAgua> getDerechoAguas() {
        return derechoAguas;
    }

    public void setDerechoAguas(List<DerechoAgua> derechoAguas) {
        this.derechoAguas = derechoAguas;
    }
}

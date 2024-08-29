package com.ProyectoAgua.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

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

    @OneToMany(mappedBy = "derechoAgua", cascade = CascadeType.ALL)
    private List<Consumo> consumos;

    @ManyToOne
    @JoinColumn(name="Id_Consumo")
    private Consumo consumo;

    @ManyToOne
    @JoinColumn(name="Id_Mecha")
    private Mecha mecha;

    @ManyToOne
    @JoinColumn(name="Id_Mora")
    private Mora mora;

    @ManyToOne
    @JoinColumn(name="Id_RegistroAgua")
    private RegistroAgua registroAgua;

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

    public Consumo getConsumo() {
        return consumo;
    }

    public void setConsumo(Consumo consumo) {
        this.consumo = consumo;
    }

    public Mecha getMecha() {
        return mecha;
    }

    public void setMecha(Mecha mecha) {
        this.mecha = mecha;
    }

    public Mora getMora() {
        return mora;
    }

    public void setMora(Mora mora) {
        this.mora = mora;
    }

    public RegistroAgua getRegistroAgua() {
        return registroAgua;
    }

    public void setRegistroAgua(RegistroAgua registroAgua) {
        this.registroAgua = registroAgua;
    }

    public List<Consumo> getConsumos() {
        return consumos;
    }

    public void setConsumos(List<Consumo> consumos) {
        this.consumos = consumos;
    }
}

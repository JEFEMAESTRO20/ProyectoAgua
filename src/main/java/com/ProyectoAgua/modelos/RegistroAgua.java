package com.ProyectoAgua.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "registroAguas")
public class RegistroAgua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El monto de pago es requerido")
    private String pago;

    @NotBlank(message = "La fecha de pago es requerida")
    private String fechaPago;

    @ManyToOne
    @JoinColumn(name = "Id_DerechoAgua")
    private DerechoAgua derechoAgua;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "El monto de pago es requerido") String getPago() {
        return pago;
    }

    public void setPago(@NotBlank(message = "El monto de pago es requerido") String pago) {
        this.pago = pago;
    }

    public @NotBlank(message = "La fecha de pago es requerida") String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(@NotBlank(message = "La fecha de pago es requerida") String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public DerechoAgua getDerechoAgua() {
        return derechoAgua;
    }

    public void setDerechoAgua(DerechoAgua derechoAgua) {
        this.derechoAgua = derechoAgua;
    }
}
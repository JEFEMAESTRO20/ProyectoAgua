package com.ProyectoAgua.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name = "registroAguas")
public class RegistroAgua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El monto de pago es requerido")
    private String pago;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_pago")
    private Date fechaPago;

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

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public DerechoAgua getDerechoAgua() {
        return derechoAgua;
    }

    public void setDerechoAgua(DerechoAgua derechoAgua) {
        this.derechoAgua = derechoAgua;
    }
}
package com.example.lstlearning.features.caja.pago;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.lstlearning.features.usuarios.docente.Docente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pago_docente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagoDocente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago_docente")
    private Integer idPagoDocente;

    @ManyToOne
    @JoinColumn(name = "id_docente", nullable = false)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Docente docente;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @Column(nullable = false)
    private BigDecimal monto;

    private String concepto;

    private String observacion;
}
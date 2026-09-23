package com.example.lstlearning.features.caja.movimiento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.lstlearning.features.usuarios.Usuario;
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
@Table(name = "movimiento_financiero")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimientoFinanciero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Integer idMovimiento;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Usuario usuario;

    @Column(nullable = false)
    private String tipo;

    private String concepto;

    @Column(nullable = false)
    private BigDecimal monto;

    @Builder.Default
    private LocalDateTime fecha = LocalDateTime.now();

    private String descripcion;
}
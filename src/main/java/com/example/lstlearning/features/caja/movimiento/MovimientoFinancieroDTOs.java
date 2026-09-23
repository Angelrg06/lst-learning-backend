package com.example.lstlearning.features.caja.movimiento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MovimientoFinancieroDTOs {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Reader {
        private Integer idMovimiento;
        private Integer idUsuario;
        private String usuarioNombre;
        private String tipo;
        private String concepto;
        private BigDecimal monto;
        private LocalDateTime fecha;
        private String descripcion;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Writer {
        private Integer idUsuario;
        private String tipo;
        private String concepto;
        private BigDecimal monto;
        private String descripcion;
    }
}

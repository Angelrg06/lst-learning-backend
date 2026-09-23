package com.example.lstlearning.features.pensiones;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MensualidadDTOs {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Reader {
        private Integer idMensualidad;
        private Integer idMatricula;
        private String codigoMatricula;
        private String estudianteNombre;
        private Integer mes;
        private Integer anio;
        private BigDecimal monto;
        private LocalDate fechaVencimiento;
        private LocalDate fechaPago;
        private String estado;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Writer {
        private Integer idMatricula;
        private Integer mes;
        private Integer anio;
        private BigDecimal monto;
        private LocalDate fechaVencimiento;
        private LocalDate fechaPago;
        private String estado;
    }
}

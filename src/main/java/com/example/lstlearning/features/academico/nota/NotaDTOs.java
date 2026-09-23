package com.example.lstlearning.features.academico.nota;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class NotaDTOs {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Reader {
        private Integer idNota;
        private String periodoEvaluacion;
        private BigDecimal calificacion;
        private LocalDate fechaRegistro;
        private String estudianteNombre;
        private String asignaturaNombre;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Writer {
        private Integer idMatricula;
        private Integer idAsignacion;
        private String periodoEvaluacion;
        private BigDecimal calificacion;
    }
}
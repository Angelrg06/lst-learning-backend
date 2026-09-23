package com.example.lstlearning.features.matriculas.periodo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PeriodoAcademicoDTOs {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Reader {
        private Integer idPeriodo;
        private String nombre;
        private LocalDate fechaInicio;
        private LocalDate fechaFin;
        private String estado;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Writer {
        private String nombre;
        private LocalDate fechaInicio;
        private LocalDate fechaFin;
        private String estado;
    }
}

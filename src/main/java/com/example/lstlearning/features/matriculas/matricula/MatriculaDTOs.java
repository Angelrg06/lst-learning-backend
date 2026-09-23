package com.example.lstlearning.features.matriculas.matricula;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MatriculaDTOs {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Reader {
        private Integer idMatricula;
        private String codigoMatricula;
        private LocalDate fechaMatricula;
        private String estado;
        private String estudianteNombresCompletos;
        private String periodoNombre;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Writer {
        private Integer idEstudiante;
        private Integer idPeriodo;
        private String codigoMatricula;
    }
}
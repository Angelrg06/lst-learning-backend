package com.example.lstlearning.features.academico.asignacion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AsignacionAcademicaDTOs {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Reader {
        private Integer idAsignacion;
        private Integer idDocente;
        private String docenteNombreCompleto;
        private Integer idAsignatura;
        private String asignaturaNombre;
        private Integer idPeriodo;
        private String periodoNombre;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Writer {
        private Integer idDocente;
        private Integer idAsignatura;
        private Integer idPeriodo;
    }
}

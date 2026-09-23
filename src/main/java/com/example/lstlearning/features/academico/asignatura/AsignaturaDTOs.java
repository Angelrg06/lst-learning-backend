package com.example.lstlearning.features.academico.asignatura;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AsignaturaDTOs {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Reader {
        private Integer idAsignatura;
        private String nombre;
        private String descripcion;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Writer {
        private String nombre;
        private String descripcion;
    }
}

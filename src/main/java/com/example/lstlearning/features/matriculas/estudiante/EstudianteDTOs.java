package com.example.lstlearning.features.matriculas.estudiante;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class EstudianteDTOs {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Reader {
        private Integer idEstudiante;
        private String nombres;
        private String apellidos;
        private String documento;
        private String telefono;
        private String direccion;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Writer {
        private String nombres;
        private String apellidos;
        private String documento;
        private String telefono;
        private String direccion;
    }
}

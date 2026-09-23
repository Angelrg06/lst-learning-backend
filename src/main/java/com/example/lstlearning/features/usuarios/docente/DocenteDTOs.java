package com.example.lstlearning.features.usuarios.docente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DocenteDTOs {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Reader {
        private Integer idDocente;
        private Integer idUsuario;
        private String usuarioNombre;
        private String nombres;
        private String apellidos;
        private String documento;
        private String telefono;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Writer {
        private Integer idUsuario;
        private String nombres;
        private String apellidos;
        private String documento;
        private String telefono;
    }
}

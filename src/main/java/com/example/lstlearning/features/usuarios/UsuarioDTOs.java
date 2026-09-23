package com.example.lstlearning.features.usuarios;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UsuarioDTOs {

    @Data 
    @NoArgsConstructor 
    @AllArgsConstructor 
    @Builder 
    public static class Reader {
        private Integer idUsuario;
        private String nombreUsuario;
        private String correo;
        private Boolean estado;
        private String rolNombre;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Writer {
        private String nombreUsuario;
        private String contrasena;
        private String correo;
        private Integer idRol;
    }
}
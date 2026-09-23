package com.example.lstlearning.util;

public record RegisterResponse(Integer idUsuario,
        String nombreUsuario,
        String correo,
        String rolNombre,
        String token) {

}

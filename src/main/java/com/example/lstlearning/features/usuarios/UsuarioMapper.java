package com.example.lstlearning.features.usuarios;

import com.example.lstlearning.features.usuarios.rol.Rol;

public class UsuarioMapper {
    public static UsuarioDTOs.Reader toReader(Usuario usuario) {
        if (usuario == null)
            return null;
        return UsuarioDTOs.Reader.builder()
                .idUsuario(usuario.getIdUsuario())
                .nombreUsuario(usuario.getNombreUsuario())
                .correo(usuario.getCorreo())
                .estado(usuario.getEstado())
                .rolNombre(usuario.getRol() != null ? usuario.getRol().getNombre() : null)
                .build();
    }

    public static Usuario toEntity(UsuarioDTOs.Writer dto, Rol rol) {
        if (dto == null)
            return null;
        return Usuario.builder()
                .nombreUsuario(dto.getNombreUsuario())
                .contrasena(dto.getContrasena()) // o contrasena según tu entidad
                .correo(dto.getCorreo())
                .rol(rol)
                .estado(true)
                .build();
    }
}

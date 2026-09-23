package com.example.lstlearning.features.usuarios.docente;

import com.example.lstlearning.features.usuarios.Usuario;

public class DocenteMapper {

    public static DocenteDTOs.Reader toReader(Docente docente) {
        if (docente == null)
            return null;
        return DocenteDTOs.Reader.builder()
                .idDocente(docente.getIdDocente())
                .idUsuario(docente.getUsuario() != null ? docente.getUsuario().getIdUsuario() : null)
                .usuarioNombre(docente.getUsuario() != null ? docente.getUsuario().getNombreUsuario() : null)
                .nombres(docente.getNombres())
                .apellidos(docente.getApellidos())
                .documento(docente.getDocumento())
                .telefono(docente.getTelefono())
                .build();
    }

    public static Docente toEntity(DocenteDTOs.Writer dto, Usuario usuario) {
        if (dto == null)
            return null;
        return Docente.builder()
                .usuario(usuario)
                .nombres(dto.getNombres())
                .apellidos(dto.getApellidos())
                .documento(dto.getDocumento())
                .telefono(dto.getTelefono())
                .build();
    }
}

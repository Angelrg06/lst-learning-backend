package com.example.lstlearning.features.usuarios.rol;

public class RolMapper {

    public static RolDTOs.Reader toReader(Rol rol) {
        if (rol == null)
            return null;
        return RolDTOs.Reader.builder()
                .idRol(rol.getIdRol())
                .nombre(rol.getNombre())
                .build();
    }

    public static Rol toEntity(RolDTOs.Writer dto) {
        if (dto == null)
            return null;
        return Rol.builder()
                .nombre(dto.getNombre())
                .build();
    }
}

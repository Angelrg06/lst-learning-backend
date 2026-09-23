package com.example.lstlearning.features.academico.asignatura;

public class AsignaturaMapper {

    public static AsignaturaDTOs.Reader toReader(Asignatura asignatura) {
        if (asignatura == null)
            return null;
        return AsignaturaDTOs.Reader.builder()
                .idAsignatura(asignatura.getIdAsignatura())
                .nombre(asignatura.getNombre())
                .descripcion(asignatura.getDescripcion())
                .build();
    }

    public static Asignatura toEntity(AsignaturaDTOs.Writer dto) {
        if (dto == null)
            return null;
        return Asignatura.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .build();
    }
}

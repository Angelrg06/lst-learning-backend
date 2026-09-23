package com.example.lstlearning.features.matriculas.estudiante;

public class EstudianteMapper {

    public static EstudianteDTOs.Reader toReader(Estudiante estudiante) {
        if (estudiante == null)
            return null;
        return EstudianteDTOs.Reader.builder()
                .idEstudiante(estudiante.getIdEstudiante())
                .nombres(estudiante.getNombres())
                .apellidos(estudiante.getApellidos())
                .documento(estudiante.getDocumento())
                .telefono(estudiante.getTelefono())
                .direccion(estudiante.getDireccion())
                .build();
    }

    public static Estudiante toEntity(EstudianteDTOs.Writer dto) {
        if (dto == null)
            return null;
        return Estudiante.builder()
                .nombres(dto.getNombres())
                .apellidos(dto.getApellidos())
                .documento(dto.getDocumento())
                .telefono(dto.getTelefono())
                .direccion(dto.getDireccion())
                .build();
    }
}

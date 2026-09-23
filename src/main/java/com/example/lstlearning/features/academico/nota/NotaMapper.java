package com.example.lstlearning.features.academico.nota;

import java.time.LocalDate;

import com.example.lstlearning.features.academico.asignacion.AsignacionAcademica;
import com.example.lstlearning.features.matriculas.matricula.Matricula;

public class NotaMapper {

    public static NotaDTOs.Reader toReader(Nota nota) {
        if (nota == null)
            return null;

        String estudianteStr = null;
        if (nota.getMatricula() != null && nota.getMatricula().getEstudiante() != null) {
            estudianteStr = nota.getMatricula().getEstudiante().getNombres() + " "
                    + nota.getMatricula().getEstudiante().getApellidos();
        }

        String asignaturaStr = null;
        if (nota.getAsignacionAcademica() != null && nota.getAsignacionAcademica().getAsignatura() != null) {
            asignaturaStr = nota.getAsignacionAcademica().getAsignatura().getNombre();
        }

        return NotaDTOs.Reader.builder()
                .idNota(nota.getIdNota())
                .periodoEvaluacion(nota.getPeriodoEvaluacion())
                .calificacion(nota.getCalificacion())
                .fechaRegistro(nota.getFechaRegistro())
                .estudianteNombre(estudianteStr)
                .asignaturaNombre(asignaturaStr)
                .build();
    }

    public static Nota toEntity(NotaDTOs.Writer dto, Matricula matricula, AsignacionAcademica asignacion) {
        if (dto == null)
            return null;
        return Nota.builder()
                .matricula(matricula)
                .asignacionAcademica(asignacion)
                .periodoEvaluacion(dto.getPeriodoEvaluacion())
                .calificacion(dto.getCalificacion())
                .fechaRegistro(LocalDate.now())
                .build();
    }
}
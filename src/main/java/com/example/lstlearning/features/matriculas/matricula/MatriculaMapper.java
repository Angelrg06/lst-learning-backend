package com.example.lstlearning.features.matriculas.matricula;

import java.time.LocalDate;

import com.example.lstlearning.features.matriculas.estudiante.Estudiante;
import com.example.lstlearning.features.matriculas.periodo.PeriodoAcademico;

public class MatriculaMapper {

    public static MatriculaDTOs.Reader toReader(Matricula matricula) {
        if (matricula == null)
            return null;

        String nombresCompletos = matricula.getEstudiante() != null
                ? matricula.getEstudiante().getNombres() + " " + matricula.getEstudiante().getApellidos()
                : null;

        return MatriculaDTOs.Reader.builder()
                .idMatricula(matricula.getIdMatricula())
                .codigoMatricula(matricula.getCodigoMatricula())
                .fechaMatricula(matricula.getFechaMatricula())
                .estado(matricula.getEstado())
                .estudianteNombresCompletos(nombresCompletos)
                .periodoNombre(
                        matricula.getPeriodoAcademico() != null ? matricula.getPeriodoAcademico().getNombre() : null)
                .build();
    }

    public static Matricula toEntity(MatriculaDTOs.Writer dto, Estudiante estudiante, PeriodoAcademico periodo) {
        if (dto == null)
            return null;
        return Matricula.builder()
                .estudiante(estudiante)
                .periodoAcademico(periodo)
                .codigoMatricula(dto.getCodigoMatricula())
                .fechaMatricula(LocalDate.now())
                .estado("REGISTRADO")
                .build();
    }
}
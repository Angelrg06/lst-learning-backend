package com.example.lstlearning.features.academico.asignacion;

import com.example.lstlearning.features.academico.asignatura.Asignatura;
import com.example.lstlearning.features.matriculas.periodo.PeriodoAcademico;
import com.example.lstlearning.features.usuarios.docente.Docente;

public class AsignacionAcademicaMapper {

    public static AsignacionAcademicaDTOs.Reader toReader(AsignacionAcademica asignacion) {
        if (asignacion == null)
            return null;

        String docenteNombre = null;
        if (asignacion.getDocente() != null) {
            docenteNombre = asignacion.getDocente().getNombres() + " " + asignacion.getDocente().getApellidos();
        }

        return AsignacionAcademicaDTOs.Reader.builder()
                .idAsignacion(asignacion.getIdAsignacion())
                .idDocente(asignacion.getDocente() != null ? asignacion.getDocente().getIdDocente() : null)
                .docenteNombreCompleto(docenteNombre)
                .idAsignatura(asignacion.getAsignatura() != null ? asignacion.getAsignatura().getIdAsignatura() : null)
                .asignaturaNombre(asignacion.getAsignatura() != null ? asignacion.getAsignatura().getNombre() : null)
                .idPeriodo(asignacion.getPeriodoAcademico() != null ? asignacion.getPeriodoAcademico().getIdPeriodo()
                        : null)
                .periodoNombre(
                        asignacion.getPeriodoAcademico() != null ? asignacion.getPeriodoAcademico().getNombre() : null)
                .build();
    }

    public static AsignacionAcademica toEntity(AsignacionAcademicaDTOs.Writer dto, Docente docente,
            Asignatura asignatura, PeriodoAcademico periodo) {
        if (dto == null)
            return null;
        return AsignacionAcademica.builder()
                .docente(docente)
                .asignatura(asignatura)
                .periodoAcademico(periodo)
                .build();
    }
}

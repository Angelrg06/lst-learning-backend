package com.example.lstlearning.features.matriculas.periodo;

public class PeriodoAcademicoMapper {

    public static PeriodoAcademicoDTOs.Reader toReader(PeriodoAcademico periodo) {
        if (periodo == null)
            return null;
        return PeriodoAcademicoDTOs.Reader.builder()
                .idPeriodo(periodo.getIdPeriodo())
                .nombre(periodo.getNombre())
                .fechaInicio(periodo.getFechaInicio())
                .fechaFin(periodo.getFechaFin())
                .estado(periodo.getEstado())
                .build();
    }

    public static PeriodoAcademico toEntity(PeriodoAcademicoDTOs.Writer dto) {
        if (dto == null)
            return null;
        return PeriodoAcademico.builder()
                .nombre(dto.getNombre())
                .fechaInicio(dto.getFechaInicio())
                .fechaFin(dto.getFechaFin())
                .estado(dto.getEstado() != null ? dto.getEstado() : "ACTIVO")
                .build();
    }
}

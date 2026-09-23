package com.example.lstlearning.features.matriculas.periodo;

import java.util.List;

public interface PeriodoAcademicoService {
    PeriodoAcademicoDTOs.Reader crear(PeriodoAcademicoDTOs.Writer dto);

    List<PeriodoAcademicoDTOs.Reader> obtenerTodos();

    PeriodoAcademicoDTOs.Reader obtenerPorId(Integer id);

    void eliminar(Integer id);
}

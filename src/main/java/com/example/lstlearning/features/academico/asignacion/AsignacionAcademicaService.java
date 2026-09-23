package com.example.lstlearning.features.academico.asignacion;

import java.util.List;

public interface AsignacionAcademicaService {
    AsignacionAcademicaDTOs.Reader crear(AsignacionAcademicaDTOs.Writer dto);

    List<AsignacionAcademicaDTOs.Reader> obtenerTodos();

    AsignacionAcademicaDTOs.Reader obtenerPorId(Integer id);

    void eliminar(Integer id);
}

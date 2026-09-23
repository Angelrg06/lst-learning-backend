package com.example.lstlearning.features.academico.asignatura;

import java.util.List;

public interface AsignaturaService {
    AsignaturaDTOs.Reader crear(AsignaturaDTOs.Writer dto);

    List<AsignaturaDTOs.Reader> obtenerTodos();

    AsignaturaDTOs.Reader obtenerPorId(Integer id);

    void eliminar(Integer id);
}

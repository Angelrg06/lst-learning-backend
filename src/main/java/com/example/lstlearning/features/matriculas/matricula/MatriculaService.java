package com.example.lstlearning.features.matriculas.matricula;

import java.util.List;

public interface MatriculaService {
    MatriculaDTOs.Reader crear(MatriculaDTOs.Writer dto);

    List<MatriculaDTOs.Reader> obtenerTodos();

    MatriculaDTOs.Reader obtenerPorId(Integer id);

    void eliminar(Integer id);
}

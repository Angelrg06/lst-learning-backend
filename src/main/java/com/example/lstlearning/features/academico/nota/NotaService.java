package com.example.lstlearning.features.academico.nota;

import java.util.List;

public interface NotaService {
    NotaDTOs.Reader crear(NotaDTOs.Writer dto);

    List<NotaDTOs.Reader> obtenerTodos();

    NotaDTOs.Reader obtenerPorId(Integer id);

    void eliminar(Integer id);
}

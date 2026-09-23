package com.example.lstlearning.features.usuarios.docente;

import java.util.List;

public interface DocenteService {
    DocenteDTOs.Reader crear(DocenteDTOs.Writer dto);

    List<DocenteDTOs.Reader> obtenerTodos();

    DocenteDTOs.Reader obtenerPorId(Integer id);

    void eliminar(Integer id);
}

package com.example.lstlearning.features.matriculas.estudiante;

import java.util.List;

public interface EstudianteService {
    EstudianteDTOs.Reader crear(EstudianteDTOs.Writer dto);

    List<EstudianteDTOs.Reader> obtenerTodos();

    EstudianteDTOs.Reader obtenerPorId(Integer id);

    void eliminar(Integer id);
}

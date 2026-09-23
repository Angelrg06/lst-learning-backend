package com.example.lstlearning.features.pensiones;

import java.util.List;

public interface MensualidadService {
    MensualidadDTOs.Reader crear(MensualidadDTOs.Writer dto);
    List<MensualidadDTOs.Reader> obtenerTodos();
    MensualidadDTOs.Reader obtenerPorId(Integer id);
    void eliminar(Integer id);
}

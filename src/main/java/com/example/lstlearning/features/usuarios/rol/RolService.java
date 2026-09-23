package com.example.lstlearning.features.usuarios.rol;

import java.util.List;

public interface RolService {
    RolDTOs.Reader crear(RolDTOs.Writer dto);

    List<RolDTOs.Reader> obtenerTodos();

    RolDTOs.Reader obtenerPorId(Integer id);

    void eliminar(Integer id);
}

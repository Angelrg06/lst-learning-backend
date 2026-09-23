package com.example.lstlearning.features.usuarios;

import java.util.List;

public interface UsuarioService {
    UsuarioDTOs.Reader crear(UsuarioDTOs.Writer dto);
    List<UsuarioDTOs.Reader> obtenerTodos();
    UsuarioDTOs.Reader obtenerPorId(Integer id);
    void eliminar(Integer id);
}

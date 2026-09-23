package com.example.lstlearning.features.caja.movimiento;

import java.util.List;

public interface MovimientoFinancieroService {
    MovimientoFinancieroDTOs.Reader crear(MovimientoFinancieroDTOs.Writer dto);

    List<MovimientoFinancieroDTOs.Reader> obtenerTodos();

    MovimientoFinancieroDTOs.Reader obtenerPorId(Integer id);

    void eliminar(Integer id);
}

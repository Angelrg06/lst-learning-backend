package com.example.lstlearning.features.caja.pago;

import java.util.List;

public interface PagoDocenteService {
    PagoDocenteDTOs.Reader crear(PagoDocenteDTOs.Writer dto);

    List<PagoDocenteDTOs.Reader> obtenerTodos();

    PagoDocenteDTOs.Reader obtenerPorId(Integer id);

    void eliminar(Integer id);
}

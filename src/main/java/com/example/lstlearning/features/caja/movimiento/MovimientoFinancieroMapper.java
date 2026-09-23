package com.example.lstlearning.features.caja.movimiento;

import java.time.LocalDateTime;

import com.example.lstlearning.features.usuarios.Usuario;

public class MovimientoFinancieroMapper {

    public static MovimientoFinancieroDTOs.Reader toReader(MovimientoFinanciero movimiento) {
        if (movimiento == null)
            return null;
        return MovimientoFinancieroDTOs.Reader.builder()
                .idMovimiento(movimiento.getIdMovimiento())
                .idUsuario(movimiento.getUsuario() != null ? movimiento.getUsuario().getIdUsuario() : null)
                .usuarioNombre(movimiento.getUsuario() != null ? movimiento.getUsuario().getNombreUsuario() : null)
                .tipo(movimiento.getTipo())
                .concepto(movimiento.getConcepto())
                .monto(movimiento.getMonto())
                .fecha(movimiento.getFecha())
                .descripcion(movimiento.getDescripcion())
                .build();
    }

    public static MovimientoFinanciero toEntity(MovimientoFinancieroDTOs.Writer dto, Usuario usuario) {
        if (dto == null)
            return null;
        return MovimientoFinanciero.builder()
                .usuario(usuario)
                .tipo(dto.getTipo())
                .concepto(dto.getConcepto())
                .monto(dto.getMonto())
                .fecha(LocalDateTime.now())
                .descripcion(dto.getDescripcion())
                .build();
    }
}

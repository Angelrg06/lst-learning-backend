package com.example.lstlearning.features.caja.pago;

import java.time.LocalDate;

import com.example.lstlearning.features.usuarios.docente.Docente;

public class PagoDocenteMapper {

    public static PagoDocenteDTOs.Reader toReader(PagoDocente pago) {
        if (pago == null)
            return null;

        String docenteNombre = null;
        if (pago.getDocente() != null) {
            docenteNombre = pago.getDocente().getNombres() + " " + pago.getDocente().getApellidos();
        }

        return PagoDocenteDTOs.Reader.builder()
                .idPagoDocente(pago.getIdPagoDocente())
                .idDocente(pago.getDocente() != null ? pago.getDocente().getIdDocente() : null)
                .docenteNombreCompleto(docenteNombre)
                .fechaPago(pago.getFechaPago())
                .monto(pago.getMonto())
                .concepto(pago.getConcepto())
                .observacion(pago.getObservacion())
                .build();
    }

    public static PagoDocente toEntity(PagoDocenteDTOs.Writer dto, Docente docente) {
        if (dto == null)
            return null;
        return PagoDocente.builder()
                .docente(docente)
                .fechaPago(dto.getFechaPago() != null ? dto.getFechaPago() : LocalDate.now())
                .monto(dto.getMonto())
                .concepto(dto.getConcepto())
                .observacion(dto.getObservacion())
                .build();
    }
}

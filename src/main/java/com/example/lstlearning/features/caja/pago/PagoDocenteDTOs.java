package com.example.lstlearning.features.caja.pago;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PagoDocenteDTOs {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Reader {
        private Integer idPagoDocente;
        private Integer idDocente;
        private String docenteNombreCompleto;
        private LocalDate fechaPago;
        private BigDecimal monto;
        private String concepto;
        private String observacion;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Writer {
        private Integer idDocente;
        private LocalDate fechaPago;
        private BigDecimal monto;
        private String concepto;
        private String observacion;
    }
}

package com.example.lstlearning.features.pensiones;

import com.example.lstlearning.features.matriculas.matricula.Matricula;

public class MensualidadMapper {

    public static MensualidadDTOs.Reader toReader(Mensualidad mensualidad) {
        if (mensualidad == null)
            return null;

        String estudianteNombre = null;
        if (mensualidad.getMatricula() != null && mensualidad.getMatricula().getEstudiante() != null) {
            estudianteNombre = mensualidad.getMatricula().getEstudiante().getNombres() + " "
                    + mensualidad.getMatricula().getEstudiante().getApellidos();
        }

        return MensualidadDTOs.Reader.builder()
                .idMensualidad(mensualidad.getIdMensualidad())
                .idMatricula(mensualidad.getMatricula() != null ? mensualidad.getMatricula().getIdMatricula() : null)
                .codigoMatricula(
                        mensualidad.getMatricula() != null ? mensualidad.getMatricula().getCodigoMatricula() : null)
                .estudianteNombre(estudianteNombre)
                .mes(mensualidad.getMes())
                .anio(mensualidad.getAnio())
                .monto(mensualidad.getMonto())
                .fechaVencimiento(mensualidad.getFechaVencimiento())
                .fechaPago(mensualidad.getFechaPago())
                .estado(mensualidad.getEstado())
                .build();
    }

    public static Mensualidad toEntity(MensualidadDTOs.Writer dto, Matricula matricula) {
        if (dto == null)
            return null;
        return Mensualidad.builder()
                .matricula(matricula)
                .mes(dto.getMes())
                .anio(dto.getAnio())
                .monto(dto.getMonto())
                .fechaVencimiento(dto.getFechaVencimiento())
                .fechaPago(dto.getFechaPago())
                .estado(dto.getEstado() != null ? dto.getEstado() : "PENDIENTE")
                .build();
    }
}

package com.example.lstlearning.features.academico.nota;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.lstlearning.features.academico.asignacion.AsignacionAcademica;
import com.example.lstlearning.features.matriculas.matricula.Matricula;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nota")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Integer idNota;

    @ManyToOne
    @JoinColumn(name = "id_matricula", nullable = false)
    @JsonIgnoreProperties("mensualidades")
    private Matricula matricula;

    @ManyToOne
    @JoinColumn(name = "id_asignacion", nullable = false)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private AsignacionAcademica asignacionAcademica;

    @Column(name = "periodo_evaluacion")
    private String periodoEvaluacion;

    private BigDecimal calificacion;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;
}
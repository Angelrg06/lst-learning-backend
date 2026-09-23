package com.example.lstlearning.features.academico.asignacion;

import com.example.lstlearning.features.academico.asignatura.Asignatura;
import com.example.lstlearning.features.matriculas.periodo.PeriodoAcademico;
import com.example.lstlearning.features.usuarios.docente.Docente;
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
@Table(name = "asignacion_academica")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AsignacionAcademica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacion")
    private Integer idAsignacion;

    @ManyToOne
    @JoinColumn(name = "id_docente", nullable = false)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "id_asignatura", nullable = false)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Asignatura asignatura;

    @ManyToOne
    @JoinColumn(name = "id_periodo", nullable = false)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private PeriodoAcademico periodoAcademico;
}
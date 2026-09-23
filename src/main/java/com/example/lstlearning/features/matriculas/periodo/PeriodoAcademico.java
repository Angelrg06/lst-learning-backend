package com.example.lstlearning.features.matriculas.periodo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.lstlearning.features.matriculas.matricula.Matricula;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "periodo_academico")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeriodoAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_periodo")
    private Integer idPeriodo;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    private String estado;

    @OneToMany(mappedBy = "periodoAcademico", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("periodoAcademico")
    private List<Matricula> matriculas = new ArrayList<>();
}
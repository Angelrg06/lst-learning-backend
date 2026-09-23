package com.example.lstlearning.features.matriculas.matricula;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.lstlearning.features.matriculas.estudiante.Estudiante;
import com.example.lstlearning.features.matriculas.periodo.PeriodoAcademico;
import com.example.lstlearning.features.pensiones.Mensualidad;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "matricula")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Integer idMatricula;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    @JsonIgnoreProperties("matriculas")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_periodo", nullable = false)
    @JsonIgnoreProperties("matriculas")
    private PeriodoAcademico periodoAcademico;

    @Column(name = "codigo_matricula")
    private String codigoMatricula;

    @Column(name = "fecha_matricula", nullable = false)
    private LocalDate fechaMatricula;

    private String estado;

    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("matricula")
    private List<Mensualidad> mensualidades = new ArrayList<>();
}
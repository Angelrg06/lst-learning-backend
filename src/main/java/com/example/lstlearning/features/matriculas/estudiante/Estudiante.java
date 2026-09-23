package com.example.lstlearning.features.matriculas.estudiante;

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
@Table(name = "estudiante")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Integer idEstudiante;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    private String documento;

    private String telefono;

    private String direccion;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("estudiante")
    private List<Matricula> matriculas = new ArrayList<>();
}
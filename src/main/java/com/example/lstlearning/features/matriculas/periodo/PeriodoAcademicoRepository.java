package com.example.lstlearning.features.matriculas.periodo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoAcademicoRepository extends JpaRepository<PeriodoAcademico, Integer> {
    // agregar consultas para buscar por estado de peridodo
}
package com.example.lstlearning.features.matriculas.matricula;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
    List<Matricula> findByEstudianteIdEstudiante(Integer idEstudiante);

    List<Matricula> findByPeriodoAcademicoIdPeriodo(Integer idPeriodo);
}
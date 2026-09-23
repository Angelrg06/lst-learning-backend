package com.example.lstlearning.features.academico.asignacion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignacionAcademicaRepository extends JpaRepository<AsignacionAcademica, Integer> {
    List<AsignacionAcademica> findByDocenteIdDocente(Integer idDocente);

    List<AsignacionAcademica> findByPeriodoAcademicoIdPeriodo(Integer idPeriodo);
}
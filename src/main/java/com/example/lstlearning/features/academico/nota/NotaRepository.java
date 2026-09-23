package com.example.lstlearning.features.academico.nota;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {
    List<Nota> findByMatriculaIdMatricula(Integer idMatricula);

    List<Nota> findByAsignacionAcademicaIdAsignacion(Integer idAsignacion);
}
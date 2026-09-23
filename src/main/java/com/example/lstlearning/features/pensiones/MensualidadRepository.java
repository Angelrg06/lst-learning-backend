package com.example.lstlearning.features.pensiones;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface MensualidadRepository extends JpaRepository<Mensualidad, Integer> {
    List<Mensualidad> findByMatriculaIdMatricula(Integer idMatricula);
    List<Mensualidad> findByEstado(String estado); // Ej: PENDIENTE, PAGADO
}
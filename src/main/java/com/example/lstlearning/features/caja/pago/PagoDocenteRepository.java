package com.example.lstlearning.features.caja.pago;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoDocenteRepository extends JpaRepository<PagoDocente, Integer> {
    List<PagoDocente> findByDocenteIdDocente(Integer idDocente);
}
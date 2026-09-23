package com.example.lstlearning.features.caja.movimiento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoFinancieroRepository extends JpaRepository<MovimientoFinanciero, Integer> {
    List<MovimientoFinanciero> findByTipo(String tipo);
}
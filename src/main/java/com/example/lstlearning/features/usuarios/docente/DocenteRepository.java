package com.example.lstlearning.features.usuarios.docente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer> {
    Optional<Docente> findByDocumento(String documento);

    Optional<Docente> findByUsuarioIdUsuario(Integer idUsuario);
}
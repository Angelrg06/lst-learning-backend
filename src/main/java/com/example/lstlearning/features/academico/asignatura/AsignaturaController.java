package com.example.lstlearning.features.academico.asignatura;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/asignaturas")
@RequiredArgsConstructor
public class AsignaturaController {

    private final AsignaturaService asignaturaService;

    @GetMapping
    public List<AsignaturaDTOs.Reader> obtenerTodos() {
        return asignaturaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public AsignaturaDTOs.Reader obtenerPorId(@PathVariable Integer id) {
        return asignaturaService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AsignaturaDTOs.Reader crear(@Valid @RequestBody AsignaturaDTOs.Writer dto) {
        return asignaturaService.crear(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        asignaturaService.eliminar(id);
    }
}

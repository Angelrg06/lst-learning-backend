package com.example.lstlearning.features.academico.asignacion;

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
@RequestMapping("/api/asignaciones-academicas")
@RequiredArgsConstructor
public class AsignacionAcademicaController {

    private final AsignacionAcademicaService asignacionAcademicaService;

    @GetMapping
    public List<AsignacionAcademicaDTOs.Reader> obtenerTodos() {
        return asignacionAcademicaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public AsignacionAcademicaDTOs.Reader obtenerPorId(@PathVariable Integer id) {
        return asignacionAcademicaService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AsignacionAcademicaDTOs.Reader crear(@Valid @RequestBody AsignacionAcademicaDTOs.Writer dto) {
        return asignacionAcademicaService.crear(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        asignacionAcademicaService.eliminar(id);
    }
}

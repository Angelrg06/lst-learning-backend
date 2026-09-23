package com.example.lstlearning.features.matriculas.periodo;

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
@RequestMapping("/api/periodos-academicos")
@RequiredArgsConstructor
public class PeriodoAcademicoController {

    private final PeriodoAcademicoService periodoAcademicoService;

    @GetMapping
    public List<PeriodoAcademicoDTOs.Reader> obtenerTodos() {
        return periodoAcademicoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public PeriodoAcademicoDTOs.Reader obtenerPorId(@PathVariable Integer id) {
        return periodoAcademicoService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PeriodoAcademicoDTOs.Reader crear(@Valid @RequestBody PeriodoAcademicoDTOs.Writer dto) {
        return periodoAcademicoService.crear(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        periodoAcademicoService.eliminar(id);
    }
}

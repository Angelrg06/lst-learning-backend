package com.example.lstlearning.features.caja.movimiento;

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
@RequestMapping("/api/movimientos-financieros")
@RequiredArgsConstructor
public class MovimientoFinancieroController {

    private final MovimientoFinancieroService movimientoFinancieroService;

    @GetMapping
    public List<MovimientoFinancieroDTOs.Reader> obtenerTodos() {
        return movimientoFinancieroService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public MovimientoFinancieroDTOs.Reader obtenerPorId(@PathVariable Integer id) {
        return movimientoFinancieroService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovimientoFinancieroDTOs.Reader crear(@Valid @RequestBody MovimientoFinancieroDTOs.Writer dto) {
        return movimientoFinancieroService.crear(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        movimientoFinancieroService.eliminar(id);
    }
}

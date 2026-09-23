package com.example.lstlearning.features.caja.pago;

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
@RequestMapping("/api/pagos-docentes")
@RequiredArgsConstructor
public class PagoDocenteController {

    private final PagoDocenteService pagoDocenteService;

    @GetMapping
    public List<PagoDocenteDTOs.Reader> obtenerTodos() {
        return pagoDocenteService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public PagoDocenteDTOs.Reader obtenerPorId(@PathVariable Integer id) {
        return pagoDocenteService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PagoDocenteDTOs.Reader crear(@Valid @RequestBody PagoDocenteDTOs.Writer dto) {
        return pagoDocenteService.crear(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        pagoDocenteService.eliminar(id);
    }
}

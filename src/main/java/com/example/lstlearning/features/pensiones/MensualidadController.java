package com.example.lstlearning.features.pensiones;

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
@RequestMapping("/api/mensualidades")
@RequiredArgsConstructor
public class MensualidadController {

    private final MensualidadService mensualidadService;

    @GetMapping
    public List<MensualidadDTOs.Reader> obtenerTodos() {
        return mensualidadService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public MensualidadDTOs.Reader obtenerPorId(@PathVariable Integer id) {
        return mensualidadService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MensualidadDTOs.Reader crear(@Valid @RequestBody MensualidadDTOs.Writer dto) {
        return mensualidadService.crear(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        mensualidadService.eliminar(id);
    }
}

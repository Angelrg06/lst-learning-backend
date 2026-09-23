package com.example.lstlearning.features.caja.pago;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lstlearning.features.usuarios.docente.Docente;
import com.example.lstlearning.features.usuarios.docente.DocenteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagoDocenteServiceImpl implements PagoDocenteService {

    private final PagoDocenteRepository pagoDocenteRepository;
    private final DocenteRepository docenteRepository;

    @Override
    public List<PagoDocenteDTOs.Reader> obtenerTodos() {
        return pagoDocenteRepository.findAll()
                .stream()
                .map(PagoDocenteMapper::toReader)
                .toList();
    }

    @Override
    public PagoDocenteDTOs.Reader obtenerPorId(Integer id) {
        PagoDocente entidad = pagoDocenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        return PagoDocenteMapper.toReader(entidad);
    }

    @Override
    public PagoDocenteDTOs.Reader crear(PagoDocenteDTOs.Writer dto) {
        Docente docente = docenteRepository.findById(dto.getIdDocente())
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));

        PagoDocente entidad = PagoDocenteMapper.toEntity(dto, docente);
        PagoDocente guardado = pagoDocenteRepository.save(entidad);
        return PagoDocenteMapper.toReader(guardado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!pagoDocenteRepository.existsById(id)) {
            throw new RuntimeException("Registro no encontrado");
        }
        pagoDocenteRepository.deleteById(id);
    }
}

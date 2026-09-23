package com.example.lstlearning.features.academico.asignatura;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AsignaturaServiceImpl implements AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    @Override
    public List<AsignaturaDTOs.Reader> obtenerTodos() {
        return asignaturaRepository.findAll()
                .stream()
                .map(AsignaturaMapper::toReader)
                .toList();
    }

    @Override
    public AsignaturaDTOs.Reader obtenerPorId(Integer id) {
        Asignatura entidad = asignaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        return AsignaturaMapper.toReader(entidad);
    }

    @Override
    public AsignaturaDTOs.Reader crear(AsignaturaDTOs.Writer dto) {
        Asignatura entidad = AsignaturaMapper.toEntity(dto);
        Asignatura guardado = asignaturaRepository.save(entidad);
        return AsignaturaMapper.toReader(guardado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!asignaturaRepository.existsById(id)) {
            throw new RuntimeException("Registro no encontrado");
        }
        asignaturaRepository.deleteById(id);
    }
}

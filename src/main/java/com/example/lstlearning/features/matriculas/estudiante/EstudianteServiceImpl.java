package com.example.lstlearning.features.matriculas.estudiante;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Override
    public List<EstudianteDTOs.Reader> obtenerTodos() {
        return estudianteRepository.findAll()
                .stream()
                .map(EstudianteMapper::toReader)
                .toList();
    }

    @Override
    public EstudianteDTOs.Reader obtenerPorId(Integer id) {
        Estudiante entidad = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        return EstudianteMapper.toReader(entidad);
    }

    @Override
    public EstudianteDTOs.Reader crear(EstudianteDTOs.Writer dto) {
        Estudiante entidad = EstudianteMapper.toEntity(dto);
        Estudiante guardado = estudianteRepository.save(entidad);
        return EstudianteMapper.toReader(guardado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!estudianteRepository.existsById(id)) {
            throw new RuntimeException("Registro no encontrado");
        }
        estudianteRepository.deleteById(id);
    }
}

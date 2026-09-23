package com.example.lstlearning.features.matriculas.matricula;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lstlearning.features.matriculas.estudiante.Estudiante;
import com.example.lstlearning.features.matriculas.estudiante.EstudianteRepository;
import com.example.lstlearning.features.matriculas.periodo.PeriodoAcademico;
import com.example.lstlearning.features.matriculas.periodo.PeriodoAcademicoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final EstudianteRepository estudianteRepository;
    private final PeriodoAcademicoRepository periodoAcademicoRepository;

    @Override
    public List<MatriculaDTOs.Reader> obtenerTodos() {
        return matriculaRepository.findAll()
                .stream()
                .map(MatriculaMapper::toReader)
                .toList();
    }

    @Override
    public MatriculaDTOs.Reader obtenerPorId(Integer id) {
        Matricula entidad = matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        return MatriculaMapper.toReader(entidad);
    }

    @Override
    public MatriculaDTOs.Reader crear(MatriculaDTOs.Writer dto) {
        Estudiante estudiante = estudianteRepository.findById(dto.getIdEstudiante())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        PeriodoAcademico periodo = periodoAcademicoRepository.findById(dto.getIdPeriodo())
                .orElseThrow(() -> new RuntimeException("Periodo académico no encontrado"));

        Matricula entidad = MatriculaMapper.toEntity(dto, estudiante, periodo);
        Matricula guardada = matriculaRepository.save(entidad);
        return MatriculaMapper.toReader(guardada);
    }

    @Override
    public void eliminar(Integer id) {
        if (!matriculaRepository.existsById(id)) {
            throw new RuntimeException("Registro no encontrado");
        }
        matriculaRepository.deleteById(id);
    }
}

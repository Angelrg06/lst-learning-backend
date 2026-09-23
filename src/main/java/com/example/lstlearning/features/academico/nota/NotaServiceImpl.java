package com.example.lstlearning.features.academico.nota;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lstlearning.features.academico.asignacion.AsignacionAcademica;
import com.example.lstlearning.features.academico.asignacion.AsignacionAcademicaRepository;
import com.example.lstlearning.features.matriculas.matricula.Matricula;
import com.example.lstlearning.features.matriculas.matricula.MatriculaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotaServiceImpl implements NotaService {

    private final NotaRepository notaRepository;
    private final AsignacionAcademicaRepository asignacionAcademicaRepository;
    private final MatriculaRepository matriculaRepository;

    @Override
    public List<NotaDTOs.Reader> obtenerTodos() {
        return notaRepository.findAll()
                .stream()
                .map(NotaMapper::toReader)
                .toList();
    }

    @Override
    public NotaDTOs.Reader obtenerPorId(Integer id) {
        Nota entidad = notaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        return NotaMapper.toReader(entidad);
    }

    @Override
    public NotaDTOs.Reader crear(NotaDTOs.Writer dto) {
        Matricula matricula = matriculaRepository.findById(dto.getIdMatricula())
                .orElseThrow(() -> new RuntimeException("Matrícula no encontrada"));
        AsignacionAcademica asignacion = asignacionAcademicaRepository.findById(dto.getIdAsignacion())
                .orElseThrow(() -> new RuntimeException("Asignación académica no encontrada"));

        Nota entidad = NotaMapper.toEntity(dto, matricula, asignacion);
        Nota guardada = notaRepository.save(entidad);
        return NotaMapper.toReader(guardada);
    }

    @Override
    public void eliminar(Integer id) {
        if (!notaRepository.existsById(id)) {
            throw new RuntimeException("Registro no encontrado");
        }
        notaRepository.deleteById(id);
    }
}

package com.example.lstlearning.features.academico.asignacion;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lstlearning.features.academico.asignatura.Asignatura;
import com.example.lstlearning.features.academico.asignatura.AsignaturaRepository;
import com.example.lstlearning.features.matriculas.periodo.PeriodoAcademico;
import com.example.lstlearning.features.matriculas.periodo.PeriodoAcademicoRepository;
import com.example.lstlearning.features.usuarios.docente.Docente;
import com.example.lstlearning.features.usuarios.docente.DocenteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AsignacionAcademicaServiceImpl implements AsignacionAcademicaService {

    private final AsignacionAcademicaRepository asignacionAcademicaRepository;
    private final DocenteRepository docenteRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final PeriodoAcademicoRepository periodoAcademicoRepository;

    @Override
    public List<AsignacionAcademicaDTOs.Reader> obtenerTodos() {
        return asignacionAcademicaRepository.findAll()
                .stream()
                .map(AsignacionAcademicaMapper::toReader)
                .toList();
    }

    @Override
    public AsignacionAcademicaDTOs.Reader obtenerPorId(Integer id) {
        AsignacionAcademica entidad = asignacionAcademicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        return AsignacionAcademicaMapper.toReader(entidad);
    }

    @Override
    public AsignacionAcademicaDTOs.Reader crear(AsignacionAcademicaDTOs.Writer dto) {
        Docente docente = docenteRepository.findById(dto.getIdDocente())
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));
        Asignatura asignatura = asignaturaRepository.findById(dto.getIdAsignatura())
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));
        PeriodoAcademico periodo = periodoAcademicoRepository.findById(dto.getIdPeriodo())
                .orElseThrow(() -> new RuntimeException("Periodo académico no encontrado"));

        AsignacionAcademica entidad = AsignacionAcademicaMapper.toEntity(dto, docente, asignatura, periodo);
        AsignacionAcademica guardado = asignacionAcademicaRepository.save(entidad);
        return AsignacionAcademicaMapper.toReader(guardado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!asignacionAcademicaRepository.existsById(id)) {
            throw new RuntimeException("Registro no encontrado");
        }
        asignacionAcademicaRepository.deleteById(id);
    }
}

package com.example.lstlearning.features.matriculas.periodo;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PeriodoAcademicoServiceImpl implements PeriodoAcademicoService {

    private final PeriodoAcademicoRepository periodoAcademicoRepository;

    @Override
    public List<PeriodoAcademicoDTOs.Reader> obtenerTodos() {
        return periodoAcademicoRepository.findAll()
                .stream()
                .map(PeriodoAcademicoMapper::toReader)
                .toList();
    }

    @Override
    public PeriodoAcademicoDTOs.Reader obtenerPorId(Integer id) {
        PeriodoAcademico entidad = periodoAcademicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        return PeriodoAcademicoMapper.toReader(entidad);
    }

    @Override
    public PeriodoAcademicoDTOs.Reader crear(PeriodoAcademicoDTOs.Writer dto) {
        PeriodoAcademico entidad = PeriodoAcademicoMapper.toEntity(dto);
        PeriodoAcademico guardado = periodoAcademicoRepository.save(entidad);
        return PeriodoAcademicoMapper.toReader(guardado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!periodoAcademicoRepository.existsById(id)) {
            throw new RuntimeException("Registro no encontrado");
        }
        periodoAcademicoRepository.deleteById(id);
    }
}

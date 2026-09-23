package com.example.lstlearning.features.pensiones;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lstlearning.features.matriculas.matricula.Matricula;
import com.example.lstlearning.features.matriculas.matricula.MatriculaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MensualidadServiceImpl implements MensualidadService {

    private final MensualidadRepository mensualidadRepository;
    private final MatriculaRepository matriculaRepository;

    @Override
    public List<MensualidadDTOs.Reader> obtenerTodos() {
        return mensualidadRepository.findAll()
                .stream()
                .map(MensualidadMapper::toReader)
                .toList();
    }

    @Override
    public MensualidadDTOs.Reader obtenerPorId(Integer id) {
        Mensualidad entidad = mensualidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        return MensualidadMapper.toReader(entidad);
    }

    @Override
    public MensualidadDTOs.Reader crear(MensualidadDTOs.Writer dto) {
        Matricula matricula = matriculaRepository.findById(dto.getIdMatricula())
                .orElseThrow(() -> new RuntimeException("Matrícula no encontrada"));

        Mensualidad entidad = MensualidadMapper.toEntity(dto, matricula);
        Mensualidad guardado = mensualidadRepository.save(entidad);
        return MensualidadMapper.toReader(guardado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!mensualidadRepository.existsById(id)) {
            throw new RuntimeException("Registro no encontrado");
        }
        mensualidadRepository.deleteById(id);
    }
}

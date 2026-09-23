package com.example.lstlearning.features.usuarios.rol;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    @Override
    public List<RolDTOs.Reader> obtenerTodos() {
        return rolRepository.findAll()
                .stream()
                .map(RolMapper::toReader)
                .toList();
    }

    @Override
    public RolDTOs.Reader obtenerPorId(Integer id) {
        Rol entidad = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        return RolMapper.toReader(entidad);
    }

    @Override
    public RolDTOs.Reader crear(RolDTOs.Writer dto) {
        Rol entidad = RolMapper.toEntity(dto);
        Rol guardado = rolRepository.save(entidad);
        return RolMapper.toReader(guardado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!rolRepository.existsById(id)) {
            throw new RuntimeException("Registro no encontrado");
        }
        rolRepository.deleteById(id);
    }
}

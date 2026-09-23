package com.example.lstlearning.features.usuarios.docente;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lstlearning.features.usuarios.Usuario;
import com.example.lstlearning.features.usuarios.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocenteServiceImpl implements DocenteService {

    private final DocenteRepository docenteRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<DocenteDTOs.Reader> obtenerTodos() {
        return docenteRepository.findAll()
                .stream()
                .map(DocenteMapper::toReader)
                .toList();
    }

    @Override
    public DocenteDTOs.Reader obtenerPorId(Integer id) {
        Docente entidad = docenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        return DocenteMapper.toReader(entidad);
    }

    @Override
    public DocenteDTOs.Reader crear(DocenteDTOs.Writer dto) {
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Docente entidad = DocenteMapper.toEntity(dto, usuario);
        Docente guardado = docenteRepository.save(entidad);
        return DocenteMapper.toReader(guardado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!docenteRepository.existsById(id)) {
            throw new RuntimeException("Registro no encontrado");
        }
        docenteRepository.deleteById(id);
    }
}

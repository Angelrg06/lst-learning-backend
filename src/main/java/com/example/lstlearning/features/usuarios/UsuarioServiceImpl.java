package com.example.lstlearning.features.usuarios;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.lstlearning.features.usuarios.rol.Rol;
import com.example.lstlearning.features.usuarios.rol.RolRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UsuarioDTOs.Reader> obtenerTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toReader)
                .toList();
    }

    @Override
    public UsuarioDTOs.Reader obtenerPorId(Integer id) {
        Usuario entidad = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        return UsuarioMapper.toReader(entidad);
    }

    @Override
    public UsuarioDTOs.Reader crear(UsuarioDTOs.Writer dto) {
        Rol rol = rolRepository.findById(dto.getIdRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        Usuario entidad = UsuarioMapper.toEntity(dto, rol);
        entidad.setContrasena(passwordEncoder.encode(dto.getContrasena()));
        Usuario guardado = usuarioRepository.save(entidad);
        return UsuarioMapper.toReader(guardado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Registro no encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}

package com.example.lstlearning.features.caja.movimiento;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lstlearning.features.usuarios.Usuario;
import com.example.lstlearning.features.usuarios.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovimientoFinancieroServiceImpl implements MovimientoFinancieroService {

    private final MovimientoFinancieroRepository movimientoFinancieroRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<MovimientoFinancieroDTOs.Reader> obtenerTodos() {
        return movimientoFinancieroRepository.findAll()
                .stream()
                .map(MovimientoFinancieroMapper::toReader)
                .toList();
    }

    @Override
    public MovimientoFinancieroDTOs.Reader obtenerPorId(Integer id) {
        MovimientoFinanciero entidad = movimientoFinancieroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        return MovimientoFinancieroMapper.toReader(entidad);
    }

    @Override
    public MovimientoFinancieroDTOs.Reader crear(MovimientoFinancieroDTOs.Writer dto) {
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        MovimientoFinanciero entidad = MovimientoFinancieroMapper.toEntity(dto, usuario);
        MovimientoFinanciero guardado = movimientoFinancieroRepository.save(entidad);
        return MovimientoFinancieroMapper.toReader(guardado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!movimientoFinancieroRepository.existsById(id)) {
            throw new RuntimeException("Registro no encontrado");
        }
        movimientoFinancieroRepository.deleteById(id);
    }
}

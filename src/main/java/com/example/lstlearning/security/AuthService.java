package com.example.lstlearning.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.lstlearning.features.usuarios.Usuario;
import com.example.lstlearning.features.usuarios.UsuarioRepository;
import com.example.lstlearning.features.usuarios.rol.Rol;
import com.example.lstlearning.features.usuarios.rol.RolRepository;
import com.example.lstlearning.util.AuthRequest;
import com.example.lstlearning.util.AuthResponse;
import com.example.lstlearning.util.RegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final UserDetailsServiceImpl userDetailsService; // Inyectamos tu UserDetailsServic
    private final PasswordEncoder passwordEncoder;

    public AuthResponse authenticate(AuthRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.username(),
                            request.password()));
        } catch (Exception e) {
            System.err.println("========================================");
            System.err.println("ERROR DE AUTENTICACIÓN: " + e.getClass().getName());
            System.err.println("MENSAJE: " + e.getMessage());
            System.err.println("========================================");
            throw e;
        }

        Usuario usuario = usuarioRepository.findByNombreUsuario(request.username())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        Map<String, Object> claims = new HashMap<>();
        String rolNombre = usuario.getRol() != null ? usuario.getRol().getNombre() : "USER";
        claims.put("rol", rolNombre);

        var userDetails = userDetailsService.loadUserByUsername(request.username());
        String jwtToken = jwtService.generateToken(claims, userDetails);

        return new AuthResponse(jwtToken);
    }

    public AuthResponse register(RegisterRequest request) {

        if (request.idRol() == null) {
            throw new IllegalArgumentException("idRol nulo");
        }

        Rol rol = rolRepository.findById(request.idRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + request.idRol()));


        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(request.nombreUsuario());
        usuario.setCorreo(request.correo());
        usuario.setContrasena(passwordEncoder.encode(request.contrasena()));
        usuario.setRol(rol);
        usuario.setEstado(true);

        usuarioRepository.save(usuario);

        //Generar el token directamente tras registrarse, o quitar por login nomas
        var userDetails = userDetailsService.loadUserByUsername(request.nombreUsuario());
        Map<String, Object> claims = new HashMap<>();
        claims.put("rol", rol.getNombre());
        String jwtToken = jwtService.generateToken(claims, userDetails);

        return new AuthResponse(jwtToken);
    }
}

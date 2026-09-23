package com.example.lstlearning.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.lstlearning.features.usuarios.Usuario;
import com.example.lstlearning.features.usuarios.UsuarioRepository;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository userRepository;

    public UserDetailsServiceImpl(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario user = userRepository.findByNombreUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        String rolNombre = user.getRol() != null ? user.getRol().getNombre() : "USER";

        return User.builder()
                .username(user.getNombreUsuario())
                .password(user.getContrasena())
                .authorities(List.of(new SimpleGrantedAuthority("ROLE_" + rolNombre)))
                .build();
    }

}

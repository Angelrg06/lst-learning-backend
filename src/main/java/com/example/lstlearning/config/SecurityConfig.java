package com.example.lstlearning.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.security.config.Customizer;

import com.example.lstlearning.security.JwtAuthFilter;

import lombok.RequiredArgsConstructor;

/**

 *
 * Reglas de autorizacion:
 * - /auth/** -> publico (login / registro)
 * - GET /api/usuarios/** -> ADMIN, DOCENTE
 * - POST /api/usuarios/** -> ADMIN
 * - /api/estudiantes/** -> ADMIN, DOCENTE
 * - /api/matriculas/** -> ADMIN, DOCENTE
 * - /api/pensiones/** -> ADMIN
 * - /api/caja/** -> ADMIN
 * - /api/academico/** -> ADMIN, DOCENTE
 * - El resto -> autenticado
 */
@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthFilter jwtFilter;

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        // Preflight CORS
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        // Endpoints publicos
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/actuator/**").permitAll()
                        // Usuarios: GET para ADMIN y DOCENTE, escritura solo ADMIN
                        .requestMatchers(HttpMethod.GET, "/api/usuarios/**").hasAnyRole("ADMIN", "DOCENTE")
                        .requestMatchers(HttpMethod.POST, "/api/usuarios/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/usuarios/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/api/usuarios/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/usuarios/**").hasRole("ADMIN")
                        // Matriculas y Estudiantes
                        .requestMatchers("/api/matriculas/**").hasAnyRole("ADMIN", "DOCENTE")
                        .requestMatchers("/api/estudiantes/**").hasAnyRole("ADMIN", "DOCENTE")
                        // Pensiones y Caja (solo ADMIN)
                        .requestMatchers("/api/pensiones/**").hasRole("ADMIN")
                        .requestMatchers("/api/caja/**").hasRole("ADMIN")
                        // Modulo academico: asignaciones, asignaturas y notas
                        .requestMatchers("/api/academico/**").hasAnyRole("ADMIN", "DOCENTE")
                        .requestMatchers("/api/notas/**").hasAnyRole("ADMIN", "DOCENTE")
                        .requestMatchers("/api/asignaturas/**").hasAnyRole("ADMIN", "DOCENTE")
                        // Cualquier otra ruta requiere autenticacion
                        // Endpoints publicos
                        .requestMatchers("/auth/**", "/api/auth/**").permitAll()
                        .anyRequest()
                        .authenticated())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:5173"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

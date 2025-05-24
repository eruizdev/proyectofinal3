package com.example.backend.service;

import com.example.backend.dto.RegisterDTO;
import com.example.backend.model.Usuario;
import com.example.backend.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authManager;

    /**
     * Valida credenciales contra el hash guardado.
     * @return Usuario si coincide, o null si no.
     */
    public Usuario validateUser(String username, String rawPassword) {
        return authRepository.findById(username)
                             .filter(u -> encoder.matches(rawPassword, u.getPassword()))
                             .orElse(null);
    }

    /**
     * Registra un usuario nuevo, guardando la pass como hash BCrypt.
     * @return true si lo creó, false si ya existía.
     */
    public boolean registerUser(RegisterDTO dto) {
        if (authRepository.existsById(dto.getUsername())) {
            return false;
        }
        String hash = encoder.encode(dto.getPassword());
        Usuario u = new Usuario(dto.getUsername(), hash, dto.getRol());
        authRepository.save(u);
        return true;
    }

    /**
     * Usa AuthenticationManager para autenticar (lanza excepción si falla).
     */
    public void login(String username, String rawPassword) {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, rawPassword)
        );
    }
}

package com.example.backend.controller;

import com.example.backend.dto.LoginDTO;
import com.example.backend.dto.RegisterDTO;
import com.example.backend.model.Usuario;
import com.example.backend.security.JwtUtil;
import com.example.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            // autentica con Spring Security
            authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginDTO.getUsername(), loginDTO.getPassword()
                )
            );
            // obtiene usuario y genera token
            Usuario u = authService.validateUser(loginDTO.getUsername(), loginDTO.getPassword());
            String token = jwtUtil.generateToken(u.getUsername(), u.getRol());
            // devuelve el rol en el body y el token en la cabecera
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                    .body(u.getRol());
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO dto) {
        if (authService.registerUser(dto)) {
            return ResponseEntity.ok("Registro exitoso");
        } else {
            return ResponseEntity.badRequest().body("El usuario ya existe");
        }
    }
}
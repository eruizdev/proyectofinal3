package com.example.backend.controller;

import com.example.backend.dto.LoginDTO;
import com.example.backend.dto.RegisterDTO;
import com.example.backend.model.Usuario;
import com.example.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        Usuario user = authService.validateUser(loginDTO.getUsername(), loginDTO.getPassword());
        if (user != null) {
            // Retornamos el rol real (ejemplo: "admin" o "veterinario")
            return ResponseEntity.ok(user.getRol());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO) {
        if (authService.registerUser(registerDTO)) {
            return ResponseEntity.ok("Registro exitoso");
        } else {
            return ResponseEntity.badRequest().body("El usuario ya existe");
        }
    }
}

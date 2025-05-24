package com.example.backend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/menu")
    public ResponseEntity<?> getMenu() {
        List<String> opciones = Arrays.asList(
            "Gestión de Mascotas",
            "Gestión de Clientes",
            "Historial Médico",
            "Agenda de Citas",
            "Inventario",
            "Facturación",
            "Reportes",
            "Salir"
        );
        return ResponseEntity.ok(opciones);
    }
}

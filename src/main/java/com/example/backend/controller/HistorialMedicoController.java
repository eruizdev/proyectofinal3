package com.example.backend.controller;

import com.example.backend.dto.HistorialMedicoDTO;
import com.example.backend.service.HistorialMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/historialMedico")
public class HistorialMedicoController {

    @Autowired
    private HistorialMedicoService historialMedicoService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarHistorial(@RequestBody HistorialMedicoDTO dto) {
        historialMedicoService.guardarHistorial(dto);
        return ResponseEntity.ok("Historial médico guardado exitosamente");
    }

    @GetMapping("/historial")
    public ResponseEntity<?> getHistorial() {
        return ResponseEntity.ok(historialMedicoService.obtenerHistorial());
    }
}

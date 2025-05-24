package com.example.backend.controller;

import com.example.backend.dto.CitaDTO;
import com.example.backend.model.Cita;
import com.example.backend.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarCita(@RequestBody CitaDTO dto) {
        citaService.guardarCita(dto);
        return ResponseEntity.ok("Cita guardada exitosamente");
    }

    @GetMapping("/historial")
    public ResponseEntity<?> getHistorial() {
        List<Cita> historial = citaService.obtenerHistorial();
        return ResponseEntity.ok(historial);
    }

    // NUEVO ENDPOINT: Buscar cita por ID
    @GetMapping("/buscar/{idCita}")
    public ResponseEntity<?> getCitaById(@PathVariable String idCita) {
        Cita cita = citaService.buscarPorId(idCita);
        if (cita != null) {
            return ResponseEntity.ok(cita);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("No se encontró la cita con ID: " + idCita);
        }
    }
}

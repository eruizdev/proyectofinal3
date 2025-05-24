package com.example.backend.controller;

import com.example.backend.dto.MascotaDTO;
import com.example.backend.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarMascota(@RequestBody MascotaDTO mascotaDTO) {
        mascotaService.guardarMascota(mascotaDTO);
        return ResponseEntity.ok("Mascota guardada exitosamente");
    }

    @GetMapping("/historial")
    public ResponseEntity<?> getHistorial() {
        return ResponseEntity.ok(mascotaService.obtenerHistorial());
    }
}

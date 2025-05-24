package com.example.backend.controller;

import com.example.backend.dto.FacturaDTO;
import com.example.backend.model.Factura;
import com.example.backend.service.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturacion")
public class FacturacionController {

    @Autowired
    private FacturacionService facturacionService;

    @PostMapping("/generar")
    public ResponseEntity<?> generarFactura(@RequestBody FacturaDTO dto) {
        facturacionService.generarFactura(dto);
        return ResponseEntity.ok("Factura generada exitosamente");
    }

    @GetMapping("/historial")
    public ResponseEntity<List<Factura>> getHistorial() {
        return ResponseEntity.ok(facturacionService.obtenerHistorial());
    }

    // Nuevo endpoint: buscar factura por ID
    @GetMapping("/buscar/{idFactura}")
    public ResponseEntity<?> getFacturaById(@PathVariable String idFactura) {
        Factura factura = facturacionService.buscarPorId(idFactura);
        if (factura != null) {
            return ResponseEntity.ok(factura);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("No se encontró la factura con ID: " + idFactura);
        }
    }
}

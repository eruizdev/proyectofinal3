package com.example.backend.controller;

import com.example.backend.dto.ProductoDTO;
import com.example.backend.model.Producto;
import com.example.backend.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarProducto(@RequestBody ProductoDTO dto) {
        Producto producto = inventarioService.agregarProducto(dto);
        return ResponseEntity.ok("Producto agregado exitosamente con id: " + producto.getId());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
        inventarioService.eliminarProducto(id);
        return ResponseEntity.ok("Producto eliminado exitosamente");
    }

    @GetMapping("/historial")
    public ResponseEntity<?> getHistorial() {
        List<Producto> historial = inventarioService.obtenerHistorial();
        return ResponseEntity.ok(historial);
    }
}

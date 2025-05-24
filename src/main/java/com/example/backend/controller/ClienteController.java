package com.example.backend.controller;

import com.example.backend.dto.ClienteDTO;
import com.example.backend.model.Cliente;
import com.example.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarCliente(@RequestBody ClienteDTO clienteDTO) {
        clienteService.guardarCliente(clienteDTO);
        return ResponseEntity.ok("Cliente guardado exitosamente");
    }

    @GetMapping("/historial")
    public ResponseEntity<List<Cliente>> getHistorial() {
        return ResponseEntity.ok(clienteService.obtenerHistorial());
    }

    // Nuevo endpoint: buscar cliente por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("No se encontró el cliente con ID: " + id);
        }
    }
}

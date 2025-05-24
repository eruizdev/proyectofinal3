package com.example.backend.service;

import com.example.backend.dto.ClienteDTO;
import com.example.backend.model.Cliente;
import com.example.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente guardarCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente(
            null,
            dto.getNombre(),
            dto.getTelefono(),
            dto.getCorreo(),
            dto.getNombreMascota()
        );
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obtenerHistorial() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
}
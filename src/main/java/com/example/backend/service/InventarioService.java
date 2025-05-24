package com.example.backend.service;

import com.example.backend.dto.ProductoDTO;
import com.example.backend.model.Producto;
import com.example.backend.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public Producto agregarProducto(ProductoDTO dto) {
        Producto producto = new Producto(
            null,
            dto.getNombre(),
            dto.getCategoria(),
            dto.getCantidadDisponible(),
            dto.getPrecioUnitario()
        );
        return inventarioRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
        inventarioRepository.deleteById(id);
    }

    public List<Producto> obtenerHistorial() {
        return inventarioRepository.findAll();
    }

    public Producto buscarPorId(Long id) {
        return inventarioRepository.findById(id).orElse(null);
    }
}
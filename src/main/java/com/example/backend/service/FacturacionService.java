package com.example.backend.service;

import com.example.backend.dto.FacturaDTO;
import com.example.backend.model.Factura;
import com.example.backend.repository.FacturacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturacionService {

    @Autowired
    private FacturacionRepository facturacionRepository;

    public void generarFactura(FacturaDTO dto) {
        Factura factura = new Factura(
            dto.getIdFactura(),
            dto.getNombreCliente(),
            dto.getNombreMascota(),
            dto.getServicioRealizado(),
            dto.getFecha(),
            dto.getTotal(),
            dto.getMetodoPago()
        );
        facturacionRepository.save(factura);
    }

    public List<Factura> obtenerHistorial() {
        return facturacionRepository.findAll();
    }

    public Factura buscarPorId(String idFactura) {
        return facturacionRepository.findById(idFactura).orElse(null);
    }
}
package com.example.backend.service;

import com.example.backend.dto.HistorialMedicoDTO;
import com.example.backend.model.HistorialMedico;
import com.example.backend.repository.HistorialMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialMedicoService {

    @Autowired
    private HistorialMedicoRepository historialMedicoRepository;

    public void guardarHistorial(HistorialMedicoDTO dto) {
        HistorialMedico hm = new HistorialMedico(
            null,
            dto.getIdMascota(),
            dto.getFecha(),
            dto.getDiagnostico(),
            dto.getTratamiento()
        );
        historialMedicoRepository.save(hm);
    }

    public List<HistorialMedico> obtenerHistorial() {
        return historialMedicoRepository.findAll();
    }

    public HistorialMedico buscarPorId(Long id) {
        return historialMedicoRepository.findById(id).orElse(null);
    }
}
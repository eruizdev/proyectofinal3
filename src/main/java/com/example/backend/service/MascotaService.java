package com.example.backend.service;

import com.example.backend.dto.MascotaDTO;
import com.example.backend.model.Mascota;
import com.example.backend.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public Mascota guardarMascota(MascotaDTO dto) {
        Mascota mascota = new Mascota(
            null,
            dto.getNombre(),
            dto.getEspecie(),
            dto.getRaza(),
            dto.getEdad(),
            dto.getNombreDueno(),
            dto.getSintomas()
        );
        return mascotaRepository.save(mascota);
    }

    public List<Mascota> obtenerHistorial() {
        return mascotaRepository.findAll();
    }

    public Mascota buscarPorId(Long id) {
        return mascotaRepository.findById(id).orElse(null);
    }
}
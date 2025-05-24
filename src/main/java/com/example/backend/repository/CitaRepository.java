package com.example.backend.repository;

import com.example.backend.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, String> {
    // findById ya busca por idCita
}
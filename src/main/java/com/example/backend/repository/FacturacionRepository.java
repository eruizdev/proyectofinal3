package com.example.backend.repository;

import com.example.backend.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturacionRepository extends JpaRepository<Factura, String> {
}
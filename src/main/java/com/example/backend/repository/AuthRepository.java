package com.example.backend.repository;

import com.example.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Usuario, String> {
    // findByUsername se deriva automáticamente
}
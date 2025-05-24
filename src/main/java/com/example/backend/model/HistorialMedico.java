package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "historial_medico")
public class HistorialMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_mascota", nullable = false)
    private Long idMascota;

    @Column(nullable = false)
    private String fecha;

    @Column(nullable = false)
    private String diagnostico;

    @Column(nullable = false)
    private String tratamiento;

    public HistorialMedico() {}

    public HistorialMedico(Long id, Long idMascota, String fecha, String diagnostico, String tratamiento) {
        this.id = id;
        this.idMascota = idMascota;
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdMascota() { return idMascota; }
    public void setIdMascota(Long idMascota) { this.idMascota = idMascota; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public String getTratamiento() { return tratamiento; }
    public void setTratamiento(String tratamiento) { this.tratamiento = tratamiento; }
}
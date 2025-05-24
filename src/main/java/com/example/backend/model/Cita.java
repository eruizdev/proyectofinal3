package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @Column(name = "id_cita", nullable = false, length = 64)
    private String idCita;

    @Column(name = "nombre_dueno", nullable = false)
    private String nombreDueno;

    @Column(name = "hora", nullable = false)
    private String hora;

    @Column(name = "veterinario_asignado", nullable = false)
    private String veterinarioAsignado;

    @Column(name = "nombre_mascota", nullable = false)
    private String nombreMascota;

    @Column(name = "fecha", nullable = false)
    private String fecha;

    @Column(name = "motivo", nullable = false)
    private String motivo;

    public Cita() {}

    public Cita(String idCita, String nombreDueno, String hora, String veterinarioAsignado,
                String nombreMascota, String fecha, String motivo) {
        this.idCita = idCita;
        this.nombreDueno = nombreDueno;
        this.hora = hora;
        this.veterinarioAsignado = veterinarioAsignado;
        this.nombreMascota = nombreMascota;
        this.fecha = fecha;
        this.motivo = motivo;
    }

    public String getIdCita() { return idCita; }
    public void setIdCita(String idCita) { this.idCita = idCita; }

    public String getNombreDueno() { return nombreDueno; }
    public void setNombreDueno(String nombreDueno) { this.nombreDueno = nombreDueno; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public String getVeterinarioAsignado() { return veterinarioAsignado; }
    public void setVeterinarioAsignado(String veterinarioAsignado) { this.veterinarioAsignado = veterinarioAsignado; }

    public String getNombreMascota() { return nombreMascota; }
    public void setNombreMascota(String nombreMascota) { this.nombreMascota = nombreMascota; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
}
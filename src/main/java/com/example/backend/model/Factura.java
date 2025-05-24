package com.example.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "facturas")
public class Factura {

    @Id
    @Column(name = "id_factura", length = 64)
    private String idFactura;

    @Column(name = "nombre_cliente", nullable = false)
    private String nombreCliente;

    @Column(name = "nombre_mascota", nullable = false)
    private String nombreMascota;

    @Column(name = "servicio_realizado", nullable = false)
    private String servicioRealizado;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private double total;

    @Column(name = "metodo_pago", nullable = false)
    private String metodoPago;

    public Factura() {}

    public Factura(String idFactura, String nombreCliente, String nombreMascota,
                   String servicioRealizado, LocalDate fecha, double total, String metodoPago) {
        this.idFactura = idFactura;
        this.nombreCliente = nombreCliente;
        this.nombreMascota = nombreMascota;
        this.servicioRealizado = servicioRealizado;
        this.fecha = fecha;
        this.total = total;
        this.metodoPago = metodoPago;
    }

    public String getIdFactura() { return idFactura; }
    public void setIdFactura(String idFactura) { this.idFactura = idFactura; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public String getNombreMascota() { return nombreMascota; }
    public void setNombreMascota(String nombreMascota) { this.nombreMascota = nombreMascota; }

    public String getServicioRealizado() { return servicioRealizado; }
    public void setServicioRealizado(String servicioRealizado) { this.servicioRealizado = servicioRealizado; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
}
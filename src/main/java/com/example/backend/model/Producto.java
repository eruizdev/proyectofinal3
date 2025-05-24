package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String categoria;

    @Column(name = "cantidad_disponible", nullable = false)
    private int cantidadDisponible;

    @Column(name = "precio_unitario", nullable = false)
    private double precioUnitario;

    public Producto() {}

    public Producto(Long id, String nombre, String categoria,
                    int cantidadDisponible, double precioUnitario) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidadDisponible = cantidadDisponible;
        this.precioUnitario = precioUnitario;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getCantidadDisponible() { return cantidadDisponible; }
    public void setCantidadDisponible(int cantidadDisponible) { this.cantidadDisponible = cantidadDisponible; }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }
}
package com.example.backend.dto;

public class ProductoDTO {
    private String nombre;
    private String categoria;
    private int cantidadDisponible;
    private double precioUnitario;

    public ProductoDTO() {}

    public ProductoDTO(String nombre, String categoria, int cantidadDisponible, double precioUnitario) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidadDisponible = cantidadDisponible;
        this.precioUnitario = precioUnitario;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public int getCantidadDisponible() { return cantidadDisponible; }
    public void setCantidadDisponible(int cantidadDisponible) { this.cantidadDisponible = cantidadDisponible; }
    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }
}

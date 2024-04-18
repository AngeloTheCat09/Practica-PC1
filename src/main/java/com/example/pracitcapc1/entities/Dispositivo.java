package com.example.pracitcapc1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dispositivo {

    @Id // Indica la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La estrategia de generación automática para el ID
    private Long id;

    @Column(name = "nombre") // Mapea este campo con la columna de nombre "nombre" en la base de datos
    private String nombre;

    @Column(name = "tipo") // Mapea este campo con la columna de nombre "tipo" en la base de datos
    private String tipo;

    @Column(name = "so") // Mapea este campo con la columna de nombre "so" en la base de datos
    private String so;

    @Temporal(TemporalType.DATE) // Indica que solo la fecha es relevante, sin tiempo
    @Column(name = "fecha_compra") // Mapea este campo con la columna de nombre "fecha_compra" en la base de datos
    private Date fechaCompra;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}

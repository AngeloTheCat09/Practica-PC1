package com.example.pracitcapc1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "apps")
public class App {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tiempo_uso_minutos")
    private Integer tiempoUsoMinutos;

    @Column(name = "calificacion")
    private Double calificacion;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "memoria_ocupada")
    private Integer memoriaOcupada;


    // Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getTiempoUsoMinutos() {
        return tiempoUsoMinutos;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getMemoriaOcupada() {
        return memoriaOcupada;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTiempoUsoMinutos(Integer tiempoUsoMinutos) {
        this.tiempoUsoMinutos = tiempoUsoMinutos;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMemoriaOcupada(Integer memoriaOcupada) {
        this.memoriaOcupada = memoriaOcupada;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof App)) return false;
        App app = (App) o;
        return Objects.equals(getId(), app.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}

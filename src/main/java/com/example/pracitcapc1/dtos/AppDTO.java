package com.example.pracitcapc1.dtos;

import jakarta.persistence.Column;

public class AppDTO {
    private Long id;

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

    public Integer getTiempoUsoMinutos() {
        return tiempoUsoMinutos;
    }

    public void setTiempoUsoMinutos(Integer tiempoUsoMinutos) {
        this.tiempoUsoMinutos = tiempoUsoMinutos;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getMemoriaOcupada() {
        return memoriaOcupada;
    }

    public void setMemoriaOcupada(Integer memoriaOcupada) {
        this.memoriaOcupada = memoriaOcupada;
    }

    private String nombre;


    private Integer tiempoUsoMinutos;


    private Double calificacion;


    private String tipo;


    private Integer memoriaOcupada;
}

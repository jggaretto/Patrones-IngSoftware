package com.patronesingsoft.Patrones_de_Comportamiento.Observer;

import java.util.Objects;

/** OBSERVADOR CONCRETO: conserva el último aviso recibido. */
public class Alumno implements Observador {
    private final String nombre;
    private String ultimoAviso = "";

    public Alumno(String nombre) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre requerido");
        this.nombre = nombre;
    }

    public void actualizar(String aviso) {
        ultimoAviso = Objects.requireNonNull(aviso);
        System.out.println(nombre + " recibio: " + aviso);
    }

    public String getUltimoAviso() { return ultimoAviso; }
}

package com.patronesingsoft.behavioral.Mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** COLEGA: conoce al mediador, no a los demás usuarios. */
public final class Usuario {
    private final String nombre;
    private final Mediador mediador;
    private final List<String> recibidos = new ArrayList<>();

    public Usuario(String nombre, Mediador mediador) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre requerido");
        this.nombre = nombre;
        this.mediador = Objects.requireNonNull(mediador);
    }

    public String getNombre() { return nombre; }
    public List<String> getRecibidos() { return List.copyOf(recibidos); }
    public void enviar(String mensaje) { mediador.enviar(mensaje, this); }
    boolean pertenece(Mediador sala) { return mediador == sala; }
    void recibir(String mensaje) { recibidos.add(mensaje); }
}

package com.patronesingsoft.creational.DependencyInjection;

import java.util.Objects;

/** CLIENTE DE LA DEPENDENCIA: recibe el notificador desde afuera. */
public class ServicioInscripcion {
    private final Notificador notificador;

    public ServicioInscripcion(Notificador notificador) {
        // No hace new Correo(): la composición se resuelve en la Demo.
        this.notificador = Objects.requireNonNull(notificador);
    }

    public String inscribir(String alumno) {
        if (alumno == null || alumno.isBlank()) {
            throw new IllegalArgumentException("El alumno necesita un nombre");
        }
        return notificador.enviar(alumno);
    }
}

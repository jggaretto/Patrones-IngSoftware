package com.patronesingsoft.structural.Decorator;

import java.util.Objects;

/** DECORADOR BASE: envuelve otro componente con la misma interfaz. */
public abstract class DecoradorNotificador implements Notificador {
    protected final Notificador envuelto;

    protected DecoradorNotificador(Notificador envuelto) {
        this.envuelto = Objects.requireNonNull(envuelto);
    }
}

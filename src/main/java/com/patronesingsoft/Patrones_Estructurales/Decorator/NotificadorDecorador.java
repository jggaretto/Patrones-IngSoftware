package com.patronesingsoft.Patrones_Estructurales.Decorator;

/**
 * DECORATOR (Decorador base).
 *
 * Implementa la misma interfaz que el componente y ADEMAS guarda una
 * referencia a otro Notificador (el "envuelto"). Por defecto delega todo en
 * el. Los decoradores concretos sobrescriben enviar() para agregar su
 * comportamiento antes o despues de delegar.
 */
public abstract class NotificadorDecorador implements Notificador {

    protected final Notificador envuelto;

    protected NotificadorDecorador(Notificador envuelto) {
        this.envuelto = envuelto;
    }

    @Override
    public void enviar(String mensaje) {
        envuelto.enviar(mensaje);
    }
}

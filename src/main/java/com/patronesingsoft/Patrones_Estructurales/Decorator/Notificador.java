package com.patronesingsoft.Patrones_Estructurales.Decorator;

/**
 * COMPONENT (Componente).
 *
 * Interfaz comun que comparten el objeto base y todos los decoradores.
 * El cliente solo conoce esta interfaz, por eso no distingue si esta
 * hablando con el notificador "pelado" o con uno decorado varias veces.
 */
public interface Notificador {

    void enviar(String mensaje);
}
